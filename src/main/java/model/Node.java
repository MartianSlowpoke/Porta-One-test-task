package model;

public class Node {

	private Double value;
	private Node left;
	private Node right;

	public Node(Double value) {
		super();
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
