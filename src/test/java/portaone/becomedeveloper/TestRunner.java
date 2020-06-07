package portaone.becomedeveloper;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MedianTester.class);
		for (Failure f : result.getFailures()) {
			System.out.println(f.getTestHeader());
			System.out.println(f.getTrace());
			System.out.println(f.getDescription());
		}
		System.out.println(result.wasSuccessful());
	}

}
