package hotelAPI.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel; 
	@ManyToOne
	@JoinColumn(name = "roomType_id", nullable = false)
	private RoomType rType;
		
	private int storey;
	private float area;
	
	public Room() {
		
	}

	public Room(@NotNull int hotelId, @NotNull int typeId, int storey, float area)
	{
		this.hotel.setId(hotelId);
		this.rType.setId(typeId);
		this.storey = storey;
		this.area = area;
	}
	
	public Room(Hotel hotel, RoomType rType)
	{
		this.hotel = hotel;
		this.rType = rType;
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

	public int getRoomTypeId() {
		return rType.getId();
	}

	public void setRoomTypeId(int roomTypeId) {
		rType.setId(roomTypeId);
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

	
}
