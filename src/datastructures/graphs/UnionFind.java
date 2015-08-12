package datastructures.graphs;

public class UnionFind {
	private int[] parent;
	private int[] rank;
	private int count;

	public UnionFind(int N) {
		parent = new int[N];
		rank = new int[N];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		count = N;
	}

	/**
	 * Returns the representative element in the given set
	 * 
	 * @param p
	 * @return
	 */
	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	/**
	 * Returns the number of components in the set
	 * 
	 * @return
	 */
	public int numberOfComponents() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int idP = find(p);
		int idQ = find(q);

		/**
		 * Make root of smaller rank point to root of larger rank to keep paths
		 * short. If ranks are similar pick arbitrarily
		 */
		if (rank[idP] < rank[idQ]) {
			parent[idP] = idQ;
		} else if (rank[idQ] < rank[idP]) {
			parent[idQ] = idP;
		} else {
			parent[idQ] = idP;
			rank[idP]++;
		}
		count--;
	}
}
