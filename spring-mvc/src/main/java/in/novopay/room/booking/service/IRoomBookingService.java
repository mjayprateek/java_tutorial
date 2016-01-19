package in.novopay.room.booking.service;

import in.novopay.room.booking.entity.Room;
import in.novopay.room.booking.entity.TimeSlot;
import in.novopay.room.booking.entity.TimeSlot.RepeatType;

import java.util.Collection;
import java.util.List;

public interface IRoomBookingService {
	public Room getRoomInfo(String id);
	public Collection<Room> getRooms();
	public Collection<TimeSlot> getTimeSlots();
	public Collection<RepeatType> getRepeats();
	
}
