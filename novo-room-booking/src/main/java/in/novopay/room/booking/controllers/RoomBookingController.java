package in.novopay.room.booking.controllers;

import in.novopay.room.booking.service.IRoomBookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/booking")
public class RoomBookingController {
	
	@Autowired
	IRoomBookingService roomBookingService;
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public String getMessage(ModelMap map) {
		map.addAttribute("message", "Welcome to Novo Booking");
		return "showMessage";
	}
	
	@RequestMapping
	public String getMessage2(ModelMap map) {
		return "showMessage";
	}
	
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	public String getRooms(ModelMap map) {
		map.addAttribute("rooms", roomBookingService.getRooms());
		map.addAttribute("timeslots", roomBookingService.getTimeSlots());
		map.addAttribute("repeats", roomBookingService.getRepeats());
		
		return "rooms";
	}

}
