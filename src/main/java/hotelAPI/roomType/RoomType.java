package hotelAPI.roomType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;
	@NotNull
	private String roomTypeName;
	private int doubleBedCount;
	private int singleBedCount;
	private int bathroomCount;
	private String description;
	private boolean tv;
	
	public RoomType() {
		
	}

	public RoomType(@NotNull String roomTypeName, int doubleBedCount, int singleBedCount, int bathroomCount, 
			String description, boolean tv) {
		this.roomTypeName = roomTypeName;
		this.doubleBedCount = doubleBedCount;
		this.singleBedCount = singleBedCount;
		this.bathroomCount = bathroomCount;
		this.description = description;
		this.tv = tv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	
	
}
