package datastructures.queue;

public class Queue {
	private int[] array;
	private int capacity;
	private int size;

	private int headPos;
	private int tailPos;

	public Queue(int capacity) {
		this.array = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
		this.headPos = 0;
		this.tailPos = 0;
	}

	public boolean enqueue(int key) {
		if (size == capacity) {
			System.out.println("Capacity Exceeded");
			return false;
		} else {
			if (tailPos == capacity) {
				tailPos = 0;
			}
			this.array[tailPos++] = key;
			this.size++;
			return true;
		}
	}

	public int dequeue() {
		if (size == 0) {
			System.out.println("Queue Empty");
			return Integer.MIN_VALUE;
		} else {
			if (headPos == capacity) {
				headPos = 0;
			}
			this.size--;
			return this.array[headPos++];
		}
	}

	public int peek() {
		if (size == 0) {
			System.out.println("Queue Empty");
			return Integer.MIN_VALUE;
		} else {
			return this.array[headPos];
		}
	}

	public void printQueue() {
		if (tailPos < headPos) {
			int i = headPos;
			while (i < array.length) {
				System.out.print(i + "->");
				i++;
			}
			i = 0;
			while (i < tailPos) {
				System.out.print(i + "->");
				i++;
			}
		} else {
			int i = headPos;
			while (i < tailPos) {
				System.out.print(i + "->");
				i++;
			}
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getQueueSize() {
		return size;
	}
}
