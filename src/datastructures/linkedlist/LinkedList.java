package datastructures.linkedlist;

public class LinkedList<T> {
	public Node<T> head;

	public LinkedList(T val) {
		this.head = new Node<T>(val);
	}

	public void append(T val) {
		Node<T> lastNode = getLastNode();
		if (lastNode == null) {
			this.head = new Node<T>(val);
		} else {
			lastNode.next = new Node<T>(val);
		}
	}

	public void push(T val) {
		Node<T> tempNode = new Node<T>(val);
		tempNode.next = this.head;
		this.head = tempNode;
	}

	public boolean insertAfter(T after, T val) {
		Node<T> tempNode = this.head;
		while (tempNode != null && !tempNode.getValue().equals(after)) {
			tempNode = tempNode.next;
		}
		if (tempNode == null) {
			return false;
		} else {
			Node<T> newNode = new Node<T>(val);
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			return true;
		}
	}

	public Node<T> delete(T val) {
		Node<T> tempNode = this.head;
		if (this.head.getValue().equals(val)) {
			this.head = this.head.next;
			return tempNode;
		}
		while (tempNode.next != null && !tempNode.next.getValue().equals(val)) {
			tempNode = tempNode.next;
		}
		if (tempNode.next == null) {
			return null;
		} else {
			Node<T> deletedNode = tempNode.next;
			tempNode.next = tempNode.next.next;
			return deletedNode;
		}
	}

	public int getCount() {
		return getCount(this.head);
	}

	private int getCount(Node<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getCount(node.next);
		}
	}

	public T getNth(int N) {
		return getNth(this.head, N - 1);
	}

	private T getNth(Node<T> node, int N) {
		if (node == null) {
			return null;
		}
		if (N == 0) {
			return node.getValue();
		} else {
			return getNth(node.next, N - 1);
		}
	}

	public void print() {
		Node<T> tempNode = this.head;
		while (tempNode != null) {
			System.out.print(tempNode.getValue() + "->");
			tempNode = tempNode.next;
		}
	}

	private Node<T> getLastNode() {
		if (head == null) {
			return null;
		}
		Node<T> tempNode = head;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
}
