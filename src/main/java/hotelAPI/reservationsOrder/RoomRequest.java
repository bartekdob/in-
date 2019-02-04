package hotelAPI.reservationsOrder;


public class RoomRequest{
    private int roomTypeId;
    private int requestedNumber;


    public RoomRequest(){

    }

    public RoomRequest(int roomTypeId, int requestedNumber) {
        this.roomTypeId = roomTypeId;
        this.requestedNumber = requestedNumber;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getRequestedNumber() {
        return requestedNumber;
    }

    public void setRequestedNumber(int requestedNumber) {
        this.requestedNumber = requestedNumber;
    }
}
