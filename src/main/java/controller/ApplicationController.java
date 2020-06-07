package controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.Option;

import model.FileParser;
import model.NumberParser;
import service.Service;
import view.View;

public class ApplicationController {

	private View view;
	private Service service;
	private FileParser fileParser;
	private NumberParser numberParser;
	private File storage;
	private String[] args;

	public ApplicationController(View view, Service service, FileParser fileParser, NumberParser numberParser) {
		super();
		this.view = view;
		this.service = service;
		this.fileParser = fileParser;
		this.numberParser = numberParser;
	}

	public void execute() throws Exception {
		try {
			long start = System.currentTimeMillis();
			view.setArguments(args);
			String[] targetArgs = view.getInputArguments();
			if (targetArgs.length == 0) {
				throw new IllegalArgumentException("no target arguments were specified");
			}
			storage = new File(targetArgs[0]);
			List<Double> data = numberParser.parse(fileParser.parse(storage));
			List<String> params = new ArrayList<>();
			if (view.getInputParameters().length == 0) {
				params.add("min");
				params.add("max");
				params.add("median");
				params.add("avg");
			} else {
				for (Option opt : view.getInputParameters()) {
					if (opt.hasLongOpt()) {
						params.add(opt.getLongOpt());
					}
				}
			}
			if (data.size() == 0) {
				view.displayError("the file doesn't contain any number matched");
				throw new IllegalArgumentException("no numbers");
			}
			service.putAll(data);
			process(params);
			long end = (System.currentTimeMillis() - start) / 1000;
			view.display("total time: " + end + " seconds");
		} catch (Exception ex) {
			view.displayError(ex.getMessage());
			throw new Exception(ex.getMessage());
		}
	}

//	private void clearCode(List<String> params) {
//		long caseStartTime, caseTime;
//		for (String param : params) {
//			caseStartTime = System.currentTimeMillis();
//			OptionHandler handler = handlers.get(param);
//			String result = handler.handle();
//			caseTime = (System.currentTimeMillis() - caseStartTime);
//			view.display(param + ": " + result + ": taken " + caseTime + " milliseconds");
//		}
//	}

	private void process(List<String> params) {
		long caseStartTime, caseTime;
		for (String param : params) {
			switch (param) {
			case "min":
				caseStartTime = System.currentTimeMillis();
				Double min = service.min();
				caseTime = (System.currentTimeMillis() - caseStartTime);
				view.display("min: " + new BigDecimal(min).toPlainString() + ": taken " + caseTime + " milliseconds");
				break;
			case "max":
				caseStartTime = System.currentTimeMillis();
				Double max = service.max();
				caseTime = (System.currentTimeMillis() - caseStartTime);
				view.display("max: " + new BigDecimal(max).toPlainString() + ": taken " + caseTime + " milliseconds");
				break;
			case "median":
				caseStartTime = System.currentTimeMillis();
				Double median = service.median();
				caseTime = (System.currentTimeMillis() - caseStartTime);
				view.display(
						"median: " + new BigDecimal(median).toPlainString() + ": taken " + caseTime + " milliseconds");
				break;
			case "avg":
				caseStartTime = System.currentTimeMillis();
				Double avg = service.average();
				caseTime = (System.currentTimeMillis() - caseStartTime);
				view.display("avg: " + new BigDecimal(avg).toPlainString() + ": taken " + caseTime + " milliseconds");
				break;
			}
		}
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

}
