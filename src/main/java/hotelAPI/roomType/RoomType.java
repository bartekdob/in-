package hotelAPI.roomType;

import hotelAPI.hotel.Hotel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(@JoinColumn(name="HotelId", referencedColumnName="id"))
	private Hotel hotel;
	@Column(name="HotelId", insertable = false, updatable = false, nullable = false)
	private Integer hotelId;
	@NotNull
	private String roomTypeName;
	private int doubleBedCount;
	private int singleBedCount;
	private int bathroomCount;
	private String description;
	private boolean tv;
	private float prize;

	public RoomType() {
		
	}

	public RoomType(@NotNull String roomTypeName, int hotelId, int doubleBedCount, int singleBedCount, int bathroomCount,
			String description, boolean tv, float prize) {
		this.roomTypeName = roomTypeName;
		this.doubleBedCount = doubleBedCount;
		this.singleBedCount = singleBedCount;
		this.bathroomCount = bathroomCount;
		this.description = description;
		this.tv = tv;
		this.prize = prize;
		this.hotelId= hotelId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public int getDoubleBedCount() {
		return doubleBedCount;
	}

	public void setDoubleBedCount(int doubleBedCount) {
		this.doubleBedCount = doubleBedCount;
	}

	public int getSingleBedCount() {
		return singleBedCount;
	}

	public void setSingleBedCount(int singleBedCount) {
		this.singleBedCount = singleBedCount;
	}

	public int getBathroomCount() {
		return bathroomCount;
	}

	public void setBathroomCount(int bathroomCount) {
		this.bathroomCount = bathroomCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	

	
	
}
