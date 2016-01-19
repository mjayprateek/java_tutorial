package in.novopay.room.booking.service;

import in.novopay.room.booking.entity.Room;
import in.novopay.room.booking.entity.TimeSlot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component("hashmapBased")
public class HashMapBasedRoomBookingService implements IRoomBookingService {
	
	static Map<String, Room> rooms = new ConcurrentHashMap<String, Room>();
	
	static Map<Integer, TimeSlot> timeslots = new ConcurrentHashMap<Integer, TimeSlot>();
	
	public HashMapBasedRoomBookingService() throws ParseException {
		Room room1 = new Room("1", "Novopay conference room", "Novopay, Above Spencers", 10);
		room1.setBooked(true);
		room1.setStartTime(new SimpleDateFormat("yyy-MM-dd hh:mm").parse("2016-01-10 09:00"));
		room1.setEndTime(new SimpleDateFormat("yyy-MM-dd hh:mm").parse("2016-01-10 10:00"));
		room1.setRepeatDescription("Every Sunday");
		rooms.put("1", room1);
		
		Room room2 = new Room("2", "Khoslalabs conference room", "Khosla Labs", 15);
		room1.setBooked(true);
		rooms.put("2", room2);
		
		timeslots.put(1, new TimeSlot(1, "09:00"));
		timeslots.put(2, new TimeSlot(2, "10:00"));
		timeslots.put(3, new TimeSlot(3, "11:00"));
		timeslots.put(4, new TimeSlot(4, "12:00"));
		timeslots.put(5, new TimeSlot(5, "13:00"));
		timeslots.put(6, new TimeSlot(6, "14:00"));
	}

	public Room getRoomInfo(String roomId) {
		return rooms.get(roomId);
	}

	public Collection<Room> getRooms() {
		return rooms.values();
	}

	public Collection<TimeSlot> getTimeSlots() {
		return timeslots.values();
	}

}
