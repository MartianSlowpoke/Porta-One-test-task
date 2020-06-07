package service;

import java.util.List;

import model.AverageFinder;
import model.BinaryTree;
import model.MedianFinder;

public class ServiceImpl implements Service {

	private BinaryTree btree;
	private MedianFinder medianFinder;
	private AverageFinder avgFinder;
	private List<Double> cache;

	public ServiceImpl(BinaryTree btree, MedianFinder medianFinder, AverageFinder avgFinder) {
		this.btree = btree;
		this.medianFinder = medianFinder;
		this.avgFinder = avgFinder;
	}

	@Override
	public Double max() {
		return btree.max();
	}

	@Override
	public Double min() {
		return btree.min();
	}

	@Override
	public Double median() throws IllegalArgumentException{
		return medianFinder.find(cache);
	}

	@Override
	public Double average() {
		return avgFinder.obtain(cache);
	}

	@Override
	public void putAll(List<Double> numbers) {
		btree.putAll(numbers);
		cache = btree.getAll();
	}

}
