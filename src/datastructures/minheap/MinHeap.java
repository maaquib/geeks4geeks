package datastructures.minheap;

public class MinHeap {
	private int capacity;
	private int size;
	private int[] array;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.array = new int[capacity];
	}

	public void swap(int i, int j) {
		int temp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = temp;
	}

	public int parent(int key) {
		return (key - 1) / 2;
	}

	public int left(int key) {
		return 2 * key + 1;
	}

	public int right(int key) {
		return 2 * key + 2;
	}

	public int getMin() {
		return array[0];
	}

	public void minHeapify(int position) {
		int left = left(position);
		int right = right(position);
		int min = position;
		if (left < size && array[left] < array[min]) {
			min = left;
		}
		if (right < size && array[right] < array[min]) {
			min = right;
		}
		if (min != position) {
			swap(min, position);
			minHeapify(min);
		}
	}

	public boolean insertKey(int key) {
		if (capacity == size) {
			return false;
		}
		int i = size;
		array[size++] = key;
		while (i != 0 && array[parent(i)] > array[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
		return true;
	}

	public void decreaseKey(int position, int new_value) {
		array[position] = new_value;
		while (position != 0 && array[parent(position)] > array[position]) {
			swap(parent(position), position);
			position = parent(position);
		}
	}

	public int extractMin() {
		if (size <= 0) {
			return Integer.MAX_VALUE;
		}
		if (size == 1) {
			size--;
			return array[0];
		}
		int root = array[0];
		array[0] = array[size - 1];
		size--;
		minHeapify(0);
		return root;
	}

	public void deleteKey(int position) {
		decreaseKey(position, Integer.MIN_VALUE);
		extractMin();
	}
}
