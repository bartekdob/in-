package hotelAPI.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import hotelAPI.DBFile.DBFile;
import hotelAPI.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
//@Table(name="Hotels")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;
	@NotNull
	private String hotelName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(@JoinColumn(name="mainPhotoId", referencedColumnName="id"))
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private DBFile mainPhoto;

	private String description;

	private String city;
	private String street;
	private String buildingNr;
	private String zipCode;

	
	public Hotel() {
		mainPhoto = new DBFile();
	}

	public Hotel(String hotelName, String city, String street, String buildingNr, String zipCode, String description)
	{
		this.hotelName = hotelName;
		this.city = city;
		this.street = street; 
		this.buildingNr = buildingNr; 
		this.zipCode = zipCode;
		this.description = description;
	}

	public Hotel(HotelCreateDTO hcDTO)
	{
		this.hotelName = hcDTO.getName();
		this.city = hcDTO.getCity();
		this.street = hcDTO.getStreet();
		this.buildingNr = hcDTO.getBuildingNr();
		this.zipCode = hcDTO.getZipCode();
		this.description = hcDTO.getDescription();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getMainPhotoId() {
		return mainPhoto.getId();
	}

	public DBFile getMainPhoto() {
		return mainPhoto;
	}

	public void setMainPhoto(DBFile mainPhoto) {
		this.mainPhoto = mainPhoto;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMainPhotoId(String mainPhotoId) {
		this.mainPhoto.setId(mainPhotoId);
	}

	public String getName() {
		return hotelName;
	}

	public void setName(String name) {
		this.hotelName = name;
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
