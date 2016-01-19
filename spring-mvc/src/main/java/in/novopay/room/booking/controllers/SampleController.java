package in.novopay.room.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/sample")
public class SampleController {
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public String showMessage(ModelMap map) {
		map.addAttribute("message", "Hello World!");
		return "showMessage";
	}
	
	
}
