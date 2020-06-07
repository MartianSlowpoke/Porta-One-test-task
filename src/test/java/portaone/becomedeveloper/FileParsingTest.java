package portaone.becomedeveloper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.FileParser;
import model.NumberParser;
import service.Service;

public class FileParsingTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private File file = new File("src/test/resources/test.txt");

	/*
	 * it checks whether the number parser works right or not
	 */
	@Test
	public void parsingOfNumbersOutOfFile() throws FileNotFoundException, IOException {
		FileParser fileParser = (FileParser) context.getBean("file-parser");
		NumberParser numberParser = (NumberParser) context.getBean("number-parser");
		List<String> lines = fileParser.parse(file);
		List<Double> numbers = numberParser.parse(lines);
		List<Double> expected = new ArrayList<>();
		expected.add(1.5d);
		expected.add(2.5d);
		expected.add(-3.5d);
		expected.add(-3.51d);
		expected.add(2323d);
		expected.add(32231321.23d);
		expected.add(32231321.55d);
		expected.add(322d);
		expected.add(3232d);
		expected.add(-3.432d);
		assertEquals(expected, numbers);
	}

	/*
	 * it checks whether the calculation operation results are right or not
	 */
	@Test
	public void whenMinOrMaxOrMedianOrAverageAreWrongThenShit() throws FileNotFoundException, IOException {
		FileParser fileParser = (FileParser) context.getBean("file-parser");
		NumberParser numberParser = (NumberParser) context.getBean("number-parser");
		List<String> lines = fileParser.parse(file);
		List<Double> numbers = numberParser.parse(lines);
		Service service = (Service) context.getBean("service");
		service.putAll(numbers);
		Double min = service.min();
		assertTrue(Double.compare(-3.51d, min) == 0);
		Double max = service.max();
		assertTrue(Double.compare(32231321.55, max) == 0);
		Double median = service.median();
		assertTrue(Double.compare(162.25d, median) == 0);
		Double avg = service.average();
		assertTrue(Double.compare(6446851.3338, avg) == 0);
	}

	@Test
	public void whenCommaThenReplaceByDot() throws FileNotFoundException, IOException {
		List<String> lines = new ArrayList<>();
		lines.add("-3,543");
		lines.add("-342.231");
		lines.add("903,23");
		NumberParser numberParser = (NumberParser) context.getBean("number-parser");
		List<Double> numbers = numberParser.parse(lines);
		List<Double> expected = new ArrayList<>();
		expected.add(-3.543);
		expected.add(-342.231);
		expected.add(903.23);
		assertEquals(expected, numbers);
	}

}
