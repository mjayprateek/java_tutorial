package in.novopay.tutorial.tests;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestWithSpringRunner {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
