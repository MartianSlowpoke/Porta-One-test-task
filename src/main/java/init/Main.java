package init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.ApplicationController;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			ApplicationController controller = (ApplicationController) context.getBean("controller");
			controller.setArgs(args);
			controller.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
