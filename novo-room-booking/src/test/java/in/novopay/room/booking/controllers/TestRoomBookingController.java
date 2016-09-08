package in.novopay.room.booking.controllers;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/application-config.xml", 
		"file:src/main/webapp/WEB-INF/mvc-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRoomBookingController {
	
	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetMessageReturnsCorrectStatusAndView() throws Exception {
        this.mockMvc.perform(get("/booking/message"))
            .andExpect(status().isOk())
            .andExpect(view().name("login"));
    }

	@Test
	public void testGetMessage() {
		RoomBookingController c = new RoomBookingController();
		
		ModelMap map = new ModelMap();
		String s = c.getMessage(map);
		
		assertEquals("login", s);
	}
	
	@Test
	public void shouldReturnRoomsInfoInAModel() throws Exception {
		this.mockMvc.perform(get("/booking/rooms"))
			.andExpect(status().isOk())
			.andExpect(view().name("rooms"))
			.andExpect(model().size(3))
			.andExpect(model().attribute("rooms", notNullValue()))
			.andExpect(model().attribute("timeslots", notNullValue()))
			.andExpect(model().attribute("repeats", notNullValue()));
	}
	
	@Test
	public void testPointerSwap() {
		int a=5, b=10;
		swap(a,b);
		System.out.println("a: " + a + " b: " + b);
	}
	
	private void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}
