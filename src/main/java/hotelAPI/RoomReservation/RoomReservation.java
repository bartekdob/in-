package hotelAPI.RoomReservation;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import hotelAPI.reservation.Reservation;
import hotelAPI.room.Room;



@Entity
public class RoomReservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;
	@NotNull
	@ManyToOne
	private Room room;
//		private int roomId;
	@ManyToOne
	private Reservation reservation;
//	private int reservationId;
	
	public RoomReservation() 
	{
		
	}

	public RoomReservation(@NotNull int roomId, int reservationId) 
	{
		super();
//		this.roomId = roomId;
//		this.reservationId = reservationId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//
//	public int getRoomId() {
//		return roomId;
//	}
//
//	public void setRoomId(int roomId) {
//		this.roomId = roomId;
//	}
//
//	public int getReservationId() {
//		return reservationId;
//	}
//
//	public void setReservationId(int reservationId) {
//		this.reservationId = reservationId;
//	}

	
	
}
