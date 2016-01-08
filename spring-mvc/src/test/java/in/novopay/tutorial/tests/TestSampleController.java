package in.novopay.tutorial.tests;
import static org.junit.Assert.assertEquals;
import in.novopay.tutorial.controllers.SampleController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring/application-config.xml", "classpath:src/main/webapp/WEB-INF/mvc-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSampleController {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetMessageReturnsCorrectStatusAndView() throws Exception {
        this.mockMvc.perform(get("/sample/message"))
            .andExpect(status().isOk())
            .andExpect(view().name("showMessage"));
    }
	
	@Test
	public void testGetMessageReturnsCorrectView() {
		SampleController controller = new SampleController();
		String s = controller.showMessage(new ModelMap());
		assertEquals("showMessage", s);
	}

}
