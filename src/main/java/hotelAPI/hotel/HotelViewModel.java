package hotelAPI.hotel;

public class HotelViewModel {
    private Integer id;
    private String name;
    private byte[] photo;

    private String city;
    private String street;
    private String buildingNr;
    private String zipCode;

    public HotelViewModel(Hotel hotel)
    {
        id = hotel.getId();
        name = hotel.getName();
        city = hotel.getCity();
        street = hotel.getStreet();
        buildingNr = hotel.getBuildingNr();
        zipCode = hotel.getZipCode();
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
