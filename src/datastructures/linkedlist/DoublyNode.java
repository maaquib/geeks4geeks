package datastructures.linkedlist;

public class DoublyNode<T> {
	private int key;
	private T value;
	public DoublyNode<T> next;
	public DoublyNode<T> prev;

	public DoublyNode(int key, T val) {
		this.key = key;
		this.value = val;
		this.next = null;
		this.prev = null;
	}

	public T getValue() {
		return value;
	}

	public int getKey() {
		return key;
	}
}
