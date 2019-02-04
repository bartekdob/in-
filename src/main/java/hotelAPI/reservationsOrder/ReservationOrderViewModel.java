package hotelAPI.reservationsOrder;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

public class ReservationOrderViewModel {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;
    private int hotelId;
    private ArrayList<RoomRequest> roomRequests;
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

    public ArrayList<RoomRequest> getRoomRequests() {
        return roomRequests;
    }

    public void setRoomRequests(ArrayList<RoomRequest> roomRequests) {
        this.roomRequests = roomRequests;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }
}
