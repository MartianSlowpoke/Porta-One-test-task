package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParserImpl implements FileParser {

	@Override
	public List<String> parse(File file) throws IOException, FileNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			List<String> rows = new ArrayList<>();
			for (String row = reader.readLine(); row != null; row = reader.readLine()) {
				rows.add(row);
			}
			return rows;
		}
	}

	@Override
	public List<String> parse(File file, Integer limit) throws IOException, FileNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			List<String> rows = new ArrayList<>();
			for (int i = 0; i < limit; i++) {
				String row = reader.readLine();
				if (row != null) {
					rows.add(row);
				} else {
					break;
				}
			}
			return rows;
		}
	}

}
