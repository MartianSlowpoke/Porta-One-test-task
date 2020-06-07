package view;

import org.apache.commons.cli.Option;

public interface View {

	public void display(String str);

	public void displayError(String error);

	public Option[] getInputParameters();

	public String[] getInputArguments();
	
	public void setArguments(String[] args) throws org.apache.commons.cli.ParseException;
	
}
