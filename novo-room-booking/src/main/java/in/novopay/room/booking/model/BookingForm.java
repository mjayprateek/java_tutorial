package in.novopay.room.booking.model;

public class BookingForm {
	private String roomSelect;
	private String bookingDate;
	private String bookFromSlot;
	private String bookToSlot;
	private String repeatType;
	private String repeatTill;
	private String username;
	
	public String getRoomSelect() {
		return roomSelect;
	}
	public void setRoomSelect(String roomSelect) {
		this.roomSelect = roomSelect;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getRepeatType() {
		return repeatType;
	}
	public void setRepeatType(String repeatType) {
		this.repeatType = repeatType;
	}
	public String getRepeatTill() {
		return repeatTill;
	}
	public void setRepeatTill(String repeatTill) {
		this.repeatTill = repeatTill;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBookFromSlot() {
		return bookFromSlot;
	}
	public void setBookFromSlot(String bookFromSlot) {
		this.bookFromSlot = bookFromSlot;
	}
	public String getBookToSlot() {
		return bookToSlot;
	}
	public void setBookToSlot(String bookToSlot) {
		this.bookToSlot = bookToSlot;
	}
	
	
}
