package datastructures.linkedlist;

public class LRUCacheTest {

	public static void main(String[] args) {
		LRUCache<String> cache = new LRUCache<>(5);
		cache.printCache();
		cache.set(1, "a");
		cache.set(2, "b");
		cache.set(3, "c");
		cache.set(4, "d");
		cache.set(5, "e");
		cache.printCache();
		cache.delete(1);
		cache.printCache();
		cache.set(6, "f");
		cache.printCache();
		System.out.println("Value at 3: " + cache.get(3));
		cache.printCache();
		System.out.println("Value at 8: " + cache.get(8));
		cache.set(7, "g");
		cache.printCache();
	}
}
