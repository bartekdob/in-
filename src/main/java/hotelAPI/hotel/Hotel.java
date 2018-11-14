package hotelAPI.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	public String city;
	public String street;
	public String buildingNr;
	public String zipCode;
	
	public Hotel() {
		
	}

	public Hotel(String name, String city, String street, String buildingNr, String zipCode)
	{
		this.hotelName = name;
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
