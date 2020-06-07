package model;

import java.util.List;

public interface BinaryTree {

	public void put(Double value);

	public void putAll(List<Double> numbers);

	public Double max();

	public Double min();

	public List<Double> getAll();

	public void clear();

	public int size();

}
