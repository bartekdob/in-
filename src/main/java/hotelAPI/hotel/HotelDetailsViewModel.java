package hotelAPI.hotel;

import hotelAPI.roomType.RoomType;

import java.util.ArrayList;

public class HotelDetailsViewModel {
    private Integer id;
    private String name;
    private ArrayList<byte[]> roomPhotos;
    private String city;
    private String street;
    private String buildingNr;
    private String zipCode;
    private ArrayList<RoomType> roomTypes;

    public HotelDetailsViewModel(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.city = hotel.getCity();
        this.street = hotel.getStreet();
        this.buildingNr = hotel.getBuildingNr();
        this.zipCode = hotel.getZipCode();
        this.roomPhotos = new ArrayList<>();
        this.roomTypes = new ArrayList<>();
    }

    public ArrayList<byte[]> getRoomPhotos() {
        return roomPhotos;
    }

    public void setRoomPhotos(ArrayList<byte[]> roomPhotos) {
        this.roomPhotos = roomPhotos;
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(ArrayList<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNr() {
        return buildingNr;
    }

    public void setBuildingNr(String buildingNr) {
        this.buildingNr = buildingNr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
