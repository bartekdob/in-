package hotelAPI.reservationsOrder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.Map;

public class ReservationOrderViewModel {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;
    private int hotelId;
    private Map<Integer, Integer> roomTypeRequest; // kluczem bedzie RoomTypeId, a wartoscia ilosc zamawianych pokoi danego typu.
    private float totalCost;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Map<Integer, Integer> getRoomTypeRequest() {
        return roomTypeRequest;
    }

    public void setRoomTypeRequest(Map<Integer, Integer> roomTypeRequest) {
        this.roomTypeRequest = roomTypeRequest;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
