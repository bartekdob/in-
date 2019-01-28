package hotelAPI.room;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import hotelAPI.hotel.Hotel;
import hotelAPI.roomType.RoomType;



@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(@JoinColumn(name="hotelId", referencedColumnName="id"))
	private Hotel hotel;
	@Column(name="hotelId", insertable = false, updatable = false, nullable = false)
	private Integer hotelId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(@JoinColumn(name="roomTypeId", referencedColumnName="id"))
	private RoomType roomType;
	@Column(name="roomTypeId", insertable = false, updatable = false, nullable = false)
	private Integer roomTypeId;

	private int storey;
	private float area;
	
	public Room() {
		/*this.hotel = new Hotel();
		this.roomType = new RoomType();*/
		
	}

	public Room(@NotNull int hotelId, @NotNull int typeId, int storey, float area)
	{
		this.hotelId = hotelId;
		this.roomTypeId = typeId;
		this.hotel = new Hotel();
		this.roomType = new RoomType();
		this.hotel.setId(hotelId);
		this.roomType.setId(typeId);
		this.storey = storey;
		this.area = area;
	}
	
	public Room(Hotel hotel, RoomType rType)
	{
		this.hotel = hotel;
		this.roomType = rType;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotelId() {
		return hotel.getId();
	}

	public void setHotelId(int hotelId) {
		this.hotel.setId(hotelId);
	}

	public int getStorey() {
		return storey;
	}

	public void setStorey(int storey) {
		this.storey = storey;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
}
