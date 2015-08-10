package datastructures.graphs;

public class TopologicalSort {
	private int[] rank;
	private Iterable<Integer> order;

	public TopologicalSort(Graph g) {
		if (!new GraphCycle(g).hasCycle()) {
			rank = new int[g.getVerticesCount()];
			DFSOrder dfsOrder = new DFSOrder(g);
			int i = 0;
			order = dfsOrder.reversePostOrder();
			for (Integer item : order) {
				rank[item] = i++;
			}
		}
	}

	public void printRanks() {
		for (int i = 0; i < rank.length; i++) {
			System.out.println(i + "'s rank is: " + rank[i] + ", ");
		}
	}

	public int getRank(int vertice) {
		if (order != null)
			return rank[vertice];
		return -1;
	}
}
