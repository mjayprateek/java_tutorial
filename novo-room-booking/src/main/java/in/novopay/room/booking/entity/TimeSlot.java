package in.novopay.room.booking.entity;

import java.util.Random;

public class TimeSlot {
	
	private String time;
	private int id;

	public TimeSlot(String time) {
		this.time = time;
		this.id = new Random().nextInt();
	}

	public TimeSlot(int id, String time) {
		this.id = id;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
