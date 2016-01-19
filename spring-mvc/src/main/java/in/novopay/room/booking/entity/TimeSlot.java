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
	
	
	public static enum RepeatType {
		DAILY(1, "Days", "Daily"), WEEKLY(2, "Weeks", "Weekly"), MONTHLY(3, "Months", "Monthly");
		
		int id;
		String units;
		String description;
		
		RepeatType(int id, String units, String description) {
			this.id = id;
			this.description = description;
			this.units = units;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}
	
	public static enum RepeatTill {
		NUMBER("1", "Number"), TILL_DATE("2", "Till Date");
		
		String id;
		String description;
		
		RepeatTill(String id, String description) {
			this.id = id;
			this.description = description;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}
	
}
