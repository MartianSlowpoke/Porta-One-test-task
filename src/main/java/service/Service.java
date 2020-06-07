package service;

import java.util.List;

public interface Service {
	
	public Double max();

	public Double min();

	public Double median();

	public Double average();
	
	public void putAll(List<Double> numbers);
	
}
