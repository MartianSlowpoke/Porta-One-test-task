package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileParser {

	public List<String> parse(File file, Integer limit) throws IOException, FileNotFoundException;

	public List<String> parse(File file) throws IOException, FileNotFoundException;

}
