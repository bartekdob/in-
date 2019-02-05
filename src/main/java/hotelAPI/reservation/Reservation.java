package hotelAPI.reservation;


import com.fasterxml.jackson.annotation.JsonProperty;
import hotelAPI.reservationsOrder.ReservationsOrder;
import hotelAPI.room.Room;
import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;


@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;

	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumns(@JoinColumn(name="roomId", referencedColumnName="id"))
	private Room room;
	@Column(name="roomId", insertable = false, updatable = false, nullable = false)
	private Integer roomId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(@JoinColumn(name="orderId", referencedColumnName="id"))
	private ReservationsOrder reservationsOrder;
	@Column(name="orderId", insertable = false, updatable = false, nullable = false)
	private Integer orderId;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date endDate;


	public Reservation() {

	}

	public Reservation(Integer roomId, Integer orderId, Date startDate, Date endDate) {
		this.roomId = roomId;
		this.orderId = orderId;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.room = new Room();
		//this.reservationsOrder = new ReservationsOrder();
		this.room.setId(roomId);
	}

	public Reservation(Room room, ReservationsOrder reservationsOrder, Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.room = room;
		this.reservationsOrder = reservationsOrder;
		this.orderId = reservationsOrder.getId();
		this.roomId = room.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public ReservationsOrder getReservationsOrder() {
		return reservationsOrder;
	}

	public void setReservationsOrder(ReservationsOrder reservationsOrder) {
		this.reservationsOrder = reservationsOrder;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
