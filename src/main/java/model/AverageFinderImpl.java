package model;

import java.util.List;

public class AverageFinderImpl implements AverageFinder {

	@Override
	public Double obtain(List<Double> numbers) {
		Double sum = 0.0d;
		for (Double d : numbers) {
			sum = sum + d;
		}
		return sum / numbers.size();
	}

}
