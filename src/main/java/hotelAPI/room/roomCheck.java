package hotelAPI.room;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import java.sql.Date;

public class roomCheck {
    public int roomTypeId;
    public int hotelId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public java.util.Date dateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public java.util.Date dateTo;
}
