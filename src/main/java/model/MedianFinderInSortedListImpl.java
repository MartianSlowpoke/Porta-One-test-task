package model;

import java.util.Collection;
import java.util.List;

public class MedianFinderInSortedListImpl implements MedianFinder {

	@Override
	public Double find(List<Double> numbers) {
		if (numbers.size() == 0) {
			throw new IllegalArgumentException("there are not numbers");
		}
		if ((numbers.size() % 2) != 0) {
			// odd
			return toArray(numbers)[numbers.size() / 2];
		} else {
			// even
			Double[] temp = toArray(numbers);
			Double first = temp[(numbers.size() / 2) - 1];
			Double second = temp[numbers.size() / 2];
			return (first + second) / 2;
		}
	}

	private Double[] toArray(Collection<Double> numbers) {
		Double[] result = new Double[numbers.size()];
		int pos = 0;
		for (Double d : numbers) {
			result[pos] = d;
			pos = pos + 1;
		}
		return result;
	}

}
