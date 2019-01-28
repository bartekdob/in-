package hotelAPI.reservation;

import hotelAPI.roomType.RoomType;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

public class ReservationViewModel implements Serializable {

    private int hotelId;
    private Date startDate;
    private Date endDate;
    private Map<Integer, Integer> roomTypeRequest; // kluczem bedzie RoomTypeId, a wartoscia ilosc zamawianych pokoi danego typu.
    private int clientId;

    public ReservationViewModel(int hotelId, Date startDate, Date endDate, Map<Integer, Integer> roomTypeRequest, int clientId) {
        this.hotelId = hotelId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomTypeRequest = roomTypeRequest;
        this.clientId = clientId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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

    public Map<Integer, Integer> getRoomTypeRequest() {
        return roomTypeRequest;
    }

    public void setRoomTypeRequest(Map<Integer, Integer> roomTypeRequest) {
        this.roomTypeRequest = roomTypeRequest;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
