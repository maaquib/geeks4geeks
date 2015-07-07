package datastructures.linkedlist;

public class Node<T> {
	private T value;
	public Node<T> next;

	public Node(T val) {
		this.value = val;
		this.next = null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
