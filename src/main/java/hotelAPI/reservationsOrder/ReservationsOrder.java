package hotelAPI.reservationsOrder;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
    @NotNull
    @Column(name="userId", insertable = false, updatable = false, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int userId;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumns(@JoinColumn(name="hotelId", referencedColumnName="id"))
    private Hotel hotel;
    @Column(name="hotelId", insertable = false, updatable = false, nullable = false)
    private int hotelId;

    @NotNull
    private float totalCost;
    private int paymentId;

    public ReservationsOrder() {
    }

    public ReservationsOrder(int userId, @NotNull int hotelId, float totalCost) {
        this.hotel = new Hotel();
        this.user = new User();
        this.userId = userId;
        this.hotelId = hotelId;
        this.hotel.setId(hotelId);
        this.user.setId(userId);
        this.totalCost = totalCost;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
