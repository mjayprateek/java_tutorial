package in.novopay.room.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/booking")
public class RoomBookingController {
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public String getMessage(ModelMap map) {
		map.addAttribute("message", "Welcome to Novo Booking");
		return "showMessage";
	}
	
	@RequestMapping
	public String getMessage2(ModelMap map) {
		return "showMessage";
	}
	
}
