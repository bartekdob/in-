package hotelAPI.hotel;

import hotelAPI.roomType.RoomTypeDTO;

import java.util.ArrayList;

public class HotelCreateDTO {
    private String buildingNr;
    private String city;
    private String description;
    private String name;
    private String street;
    private String zipCode;
    private ArrayList<RoomTypeDTO> roomTypes;

    public HotelCreateDTO() {
    }

    public String getBuildingNr() {
        return buildingNr;
    }

    public void setBuildingNr(String buildingNr) {
        this.buildingNr = buildingNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ArrayList<RoomTypeDTO> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(ArrayList<RoomTypeDTO> roomTypes) {
        this.roomTypes = roomTypes;
    }
}
