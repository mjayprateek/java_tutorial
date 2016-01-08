package in.novopay.tutorial.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapBasedRoomBookingService implements IRoomBookingService {
	
	static Map<String, Room> rooms = new HashMap<String, Room>();
	
	public HashMapBasedRoomBookingService() {
		rooms.put("1", new Room("1", "Novopay conference room", "Novopay, Above Spencers"));
		rooms.put("2", new Room("2", "Khoslalabs conference room", "Khosla Labs"));
	}

	public Room getRoomInfo(String roomId) {
		return rooms.get(roomId);
	}

	public List<Room> getRoomInfo() {
		return (List<Room>) rooms.values();
	}

}
