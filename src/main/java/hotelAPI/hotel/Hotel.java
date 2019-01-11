package hotelAPI.hotel;

import hotelAPI.DBFile.DBFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
//@Table(name="Hotels")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;
	@NotNull
	private String hotelName;
	@ManyToOne
	@JoinColumns(@JoinColumn(name="mainPhotoId", referencedColumnName="id"))
	public DBFile mainPhoto;

	public String city;
	public String street;
	public String buildingNr;
	public String zipCode;


	
	public Hotel() {
		mainPhoto = new DBFile();
	}

	public Hotel(String hotelName, String city, String street, String buildingNr, String zipCode)
	{
		this.hotelName = hotelName;
		this.city = city;
		this.street = street; 
		this.buildingNr = buildingNr; 
		this.zipCode = zipCode;
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
