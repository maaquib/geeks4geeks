package datastructures.minheap;

public class MinHeapTest {

	public static void main(String[] args) {
		MinHeap h = new MinHeap(11);
		h.insertKey(3);
		h.insertKey(2);
		h.deleteKey(1);
		h.insertKey(15);
		h.insertKey(5);
		h.insertKey(4);
		h.insertKey(45);
		System.out.println(h.extractMin());
		System.out.println(h.getMin());

		h.decreaseKey(2, 1);
		System.out.println(h.getMin());
	}
}
