package hotelAPI.roomType;

public class RoomTypeDTO {
    private String roomTypeName;
    private int doubleBedCount;
    private int singleBedCount;
    private int bathroomCount;
    private String description;
    private boolean tv;
    private float prize;
    private int quantity;

    public RoomTypeDTO() {
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public int getDoubleBedCount() {
        return doubleBedCount;
    }

    public void setDoubleBedCount(int doubleBedCount) {
        this.doubleBedCount = doubleBedCount;
    }

    public int getSingleBedCount() {
        return singleBedCount;
    }

    public void setSingleBedCount(int singleBedCount) {
        this.singleBedCount = singleBedCount;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
