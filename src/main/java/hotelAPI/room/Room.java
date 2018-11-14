package hotelAPI.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import hotelAPI.hotel.Hotel;
import hotelAPI.roomType.RoomType;



@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;
	@ManyToOne
	private Hotel hotel; 
	//private int hotelId;
	@ManyToOne
	private RoomType rType;
	//private int roomTypeId;
	
	public Room() {
		
	}

	public Room(int hotelId, int typeId)
	{
//		this.hotelId = hotelId;
//		this.roomTypeId = typeId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getHotelId() {
//		return hotelId;
//	}
//
//	public void setHotelId(int hotelId) {
//		this.hotelId = hotelId;
//	}
//
//	public int getRoomTypeId() {
//		return roomTypeId;
//	}
//
//	public void setRoomTypeId(int roomTypeId) {
//		this.roomTypeId = roomTypeId;
//	}

	
}
