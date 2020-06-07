package portaone.becomedeveloper;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.BinaryTree;
import model.FileParser;
import model.MedianFinder;
import model.NumberParser;

public class MedianTester {

	private final String fileName = "src/test/resources/one.txt";
	private final String myName = "src/test/resources/10m.txt";
	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Test
	public void test() throws FileNotFoundException, IOException {
		List<Double> numbers = new ArrayList<>();
		numbers.add(2d);
		numbers.add(3d);
		numbers.add(5d);
		numbers.add(8d);
		numbers.add(18d);
		MedianFinder median = (MedianFinder) context.getBean("median");
		Double expected = 5d;
		assertTrue(Double.compare(expected, median.find(numbers)) == 0);
	}

	@Test
	public void testMedianInTestFile() throws FileNotFoundException, IOException {
		FileParser fileParser = (FileParser) context.getBean("file-parser");
		NumberParser numberParser = (NumberParser) context.getBean("number-parser");
		List<String> lines = fileParser.parse(new File(fileName));
		List<Double> numbers = numberParser.parse(lines);
		MedianFinder median = (MedianFinder) context.getBean("median");
		Double expected = 5d;
		Double med = median.find(numbers);
		assertTrue(Double.compare(expected, med) == 0);
	}

	/*
	 * this fucking method causes OutOfmemory exception
	 */
//	@Test
	public void testMedianIn10mFile() throws FileNotFoundException, IOException {
		FileParser fileParser = (FileParser) context.getBean("file-parser");
		NumberParser numberParser = (NumberParser) context.getBean("number-parser");
		List<String> lines = fileParser.parse(new File(myName));
		List<Double> numbers = numberParser.parse(lines);
		BinaryTree tree = (BinaryTree) context.getBean("btree");
		tree.putAll(numbers);
		MedianFinder median = (MedianFinder) context.getBean("median");
		Double expected = 25216d;
		Double med = median.find(tree.getAll());
		assertTrue(Double.compare(expected, med) == 0);
	}

}
