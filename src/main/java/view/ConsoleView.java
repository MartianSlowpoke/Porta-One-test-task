package view;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ConsoleView implements View {

	private CommandLineParser cmdParser = new DefaultParser();
	private HelpFormatter formatter = new HelpFormatter();
	private CommandLine cmd;
	private Options options;

	public ConsoleView() {
	}

	private void initOptions() {
		Option minOption = new Option("x", "min", false, "find min value");
		Option maxOption = new Option("c", "max", false, "find max value");
		Option medianOption = new Option("m", "median", false, "find median value");
		Option avgOption = new Option("a", "avg", false, "find average value");
		Option sumOption = new Option("s", "sum", false, "find sum value");
		options = new Options();
		options.addOption(minOption);
		options.addOption(maxOption);
		options.addOption(medianOption);
		options.addOption(avgOption);
		options.addOption(sumOption);
	}

	@Override
	public void display(String str) {
		System.out.println(str);
	}

	@Override
	public void displayError(String error) {
		formatter.printHelp(error, options);
	}

	@Override
	public Option[] getInputParameters() {
		return cmd.getOptions();
	}

	@Override
	public String[] getInputArguments() {
		return cmd.getArgs();
	}

	@Override
	public void setArguments(String[] args) throws ParseException {
		initOptions();
		cmd = cmdParser.parse(options, args);
	}

}
