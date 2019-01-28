package hotelAPI.reservationsOrder;

import hotelAPI.hotel.Hotel;
import hotelAPI.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ReservationsOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(@JoinColumn(name="userId", referencedColumnName="id"))
    private User user;
    @NotNull
    @Column(name="userId", insertable = false, updatable = false, nullable = false)
    private int userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(@JoinColumn(name="hotelId", referencedColumnName="id"))
    private Hotel hotel;
    @Column(name="hotelId", insertable = false, updatable = false, nullable = false)
    private int hotelId;

    private int paymentId;

    public ReservationsOrder() {
    }

    public ReservationsOrder(int userId, @NotNull int hotelId) {
        this.hotel = new Hotel();
        this.user = new User();
        this.userId = userId;
        this.hotelId = hotelId;
        hotel.setId(hotelId);
        user.setId(userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
