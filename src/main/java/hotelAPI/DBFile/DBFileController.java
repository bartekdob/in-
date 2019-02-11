package hotelAPI.DBFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DBFileController {

    private static final Logger logger = LoggerFactory.getLogger(DBFileController.class);

    @Autowired
    private DBFileService DBFileService;

    @PostMapping("/uploadHotelPhoto")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("hotelId") Integer hotelId) {
        DBFile dbFile = DBFileService.storeFile(file, hotelId);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/uploadHotelPhotos/{hotelId}", method = RequestMethod.POST)
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @PathVariable Integer hotelId) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, hotelId))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity downloadFile(@PathVariable String fileId) {
        // Load file from database
        DBFile dbFile = DBFileService.getFile(fileId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        // Load file from database
        DBFile dbFile = DBFileService.getNoPhotoAvailableGraphic();

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

}