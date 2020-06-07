package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParserImpl implements NumberParser {

	private String regex;

	public static void main(String[] args) {
		String regex = "-?[0-9]+[.]?[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		String test = "3.14529 -255.34 	128";
		Matcher matcher = pattern.matcher(test);
		while (matcher.find()) {
			System.out.println(Double.parseDouble(matcher.group()));
		}
	}

	public NumberParserImpl() {
	}

	@Override
	public List<Double> parse(List<String> rows) {
		Pattern p = Pattern.compile(regex);
		List<Double> result = new ArrayList<>();
		for (String row : rows) {
			Matcher m = p.matcher(row);
			while (m.find()) {
				String captured = m.group();
				result.add(Double.parseDouble(captured.replaceAll(",", ".")));
			}
		}
		return result;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

}
