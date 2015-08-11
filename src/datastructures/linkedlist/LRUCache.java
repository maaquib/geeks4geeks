package datastructures.linkedlist;

import java.util.HashMap;

public class LRUCache<T> {
	private int cacheSize;
	private HashMap<Integer, DoublyNode<T>> map = new HashMap<>();
	private DoublyNode<T> head, tail;

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		head = null;
		tail = null;
	}

	/**
	 * Sets the given node to head of the linked list
	 * 
	 * @param node
	 */
	public void setHead(DoublyNode<T> node) {
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		if (tail == null) {
			tail = head;
		}
	}

	/**
	 * Returns the value of given key if it exists, else returns null
	 * 
	 * @param key
	 * @return
	 */
	public T get(int key) {
		T value = null;
		if (map.containsKey(key)) {
			DoublyNode<T> node = map.get(key);
			delete(key);
			map.put(key, node);
			setHead(node);
			value = node.getValue();
		}
		return value;
	}

	/**
	 * Deletes the key if exists and returns true, else returns false
	 * 
	 * @param key
	 * @return
	 */
	public boolean delete(int key) {
		DoublyNode<T> node = null;
		if (map.containsKey(key)) {
			node = map.get(key);
			map.remove(key);
			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				head = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				tail = node.prev;
			}
			return true;
		}
		return false;
	}

	/**
	 * Sets a key value pair in the map and the linked list
	 * 
	 * @param key
	 * @param value
	 */
	public void set(int key, T value) {
		DoublyNode<T> node = new DoublyNode<>(key, value);
		if (map.containsKey(key)) {
			map.put(key, node);
			setHead(node);
		} else {
			if (map.size() == cacheSize) {
				deleteLast();
			}
			map.put(key, node);
			setHead(node);
		}
	}

	/**
	 * Deletes the last node in the linked list if Cache reaches capacity
	 */
	private void deleteLast() {
		if (head != null) {
			map.remove(tail.getKey());
			if (tail != null && head != tail) {
				tail.prev.next = null;
			} else if (tail == head) {
				head = null;
			}
		}
	}

	public void printCache() {
		DoublyNode<T> node = head;
		while (node != null) {
			System.out.print(node.getValue() + "->");
			node = node.next;
		}
		System.out.println();
	}
}
