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

	public void printMiddle() {
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		if (head != null) {
			while (fastPointer != null && fastPointer.next != null) {
				fastPointer = fastPointer.next.next;
				slowPointer = slowPointer.next;
			}
			System.out.println(slowPointer.getValue());
		}
	}

	public void printNthFromLast(int n) {
		System.out.println();
		Node<T> fastPointer = head;
		Node<T> slowPointer = head;
		for (int i = 0; i < n; i++) {
			fastPointer = fastPointer.next;
		}
		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}
		System.out.print(slowPointer.getValue());
	}

	public boolean areIdentical(Node<T> first, Node<T> second) {
		if (first == null && second == null)
			return true;
		if (first == null || second == null)
			return false;
		if (!first.getValue().equals(second.getValue()))
			return false;
		return areIdentical(first.next, second.next);
	}

	public T findMergeNode(Node<T> headOther) {
		Node<T> temp = this.head, tempA = this.head, tempB = headOther;
		int d = 0;
		while (temp != null) {
			d++;
			temp = temp.next;
		}
		temp = headOther;
		while (temp != null) {
			d--;
			temp = temp.next;
		}
		if (d > 0) {
			tempA = this.head;
			while (d > 0) {
				tempA = tempA.next;
				d--;
			}
		} else {
			tempB = headOther;
			while (d < 0) {
				tempB = tempB.next;
				d++;
			}
		}
		while (!tempA.getValue().equals(tempB.getValue())) {
			tempA = tempA.next;
			tempB = tempB.next;
		}
		return tempA.getValue();
	}

	public void print() {
		Node<T> tempNode = this.head;
		while (tempNode != null) {
			System.out.print(tempNode.getValue() + "->");
			tempNode = tempNode.next;
		}
	}

	public void printReverse() {
		printReverse(this.head);
	}

	private void printReverse(Node<T> node) {
		if (node == null) {
			return;
		}
		printReverse(node.next);
		System.out.print(node.getValue() + "->");
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
