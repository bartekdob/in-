package hotelAPI.reservation;

import hotelAPI.room.Room;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class ReservationTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(@JoinColumn(name="HotelId", referencedColumnName="id"))
    private Room room;
    @Column(name="roomId", insertable = false, updatable = false, nullable = false)
    private Integer roomId;

    @NotNull
    private int clientId;
    private int paymentId;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;


    public ReservationTestEntity() {

    }



    public ReservationTestEntity(@NotNull int clientId, Date startDate, Date endDate, int paymentId, int roomId) {
        super();
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentId = paymentId;
        this.roomId = roomId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
