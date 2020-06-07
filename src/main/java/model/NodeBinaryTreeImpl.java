package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NodeBinaryTreeImpl implements BinaryTree {

	private Node root;
	private Double maxValue;
	private Double minValue;
	private int size;

	public NodeBinaryTreeImpl(List<Double> collection) {
		for (Double val : collection) {
			put(val);
		}
	}

	public NodeBinaryTreeImpl() {
	}

	@Override
	public void put(Double value) {
		if (root == null) {
			root = new Node(value);
			maxValue = value;
			minValue = value;
		} else {
			Node current = root;
			while (true) {
				if (value.compareTo(current.getValue()) <= 0) {
					// left child
					if (current.getLeft() == null) {
						Node leftNode = new Node(value);
						current.setLeft(leftNode);
						break;
					} else {
						current = current.getLeft();
					}
				} else {
					// right child
					if (current.getRight() == null) {
						Node rightNode = new Node(value);
						current.setRight(rightNode);
						break;
					} else {
						current = current.getRight();
					}
				}
			}
		}
		if (value.compareTo(minValue) < 0) {
			minValue = value;
		}
		if (value.compareTo(maxValue) > 0) {
			maxValue = value;
		}
		size++;
	}

	@Override
	public Double max() {
		return maxValue;
	}

	@Override
	public Double min() {
		return minValue;
	}

	@Override
	public List<Double> getAll() {
		List<Double> values = new ArrayList<>();
		in_order(root, values);
		return values;
	}

	public void in_order(Node node, Collection<Double> result) {
		if (node != null) {
			in_order(node.getLeft(), result);
			result.add(node.getValue());
			in_order(node.getRight(), result);
		}
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void putAll(List<Double> numbers) {
		for (Double val : numbers) {
			put(val);
		}
	}

}
