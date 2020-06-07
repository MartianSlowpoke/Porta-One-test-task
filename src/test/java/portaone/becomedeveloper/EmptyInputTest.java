package portaone.becomedeveloper;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.ApplicationController;
import model.MedianFinder;

public class EmptyInputTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private String[] args = new String[] { "src/test/resources/empty.txt" };

	@Test(expected = Exception.class)
	public void whenNoNumbersInFileThenThrowsIllegal() throws Exception {
		ApplicationController controller = (ApplicationController) context.getBean("controller");
		controller.setArgs(args);
		controller.execute();
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenNoNumbersThenMedianThrowsException() {
		MedianFinder median = (MedianFinder) context.getBean("median");
		median.find(new ArrayList<>());
	}

}
