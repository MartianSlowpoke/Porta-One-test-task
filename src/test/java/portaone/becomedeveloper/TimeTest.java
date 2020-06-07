package portaone.becomedeveloper;

import org.junit.Test;

import init.Main;

public class TimeTest {

	private final String fileName = "src/test/resources/10m.txt";
	private final String[] args = new String[] { fileName };

	@Test(timeout = 90000)
	public void testExecutionTime() {
		Main.main(args);
	}

}
