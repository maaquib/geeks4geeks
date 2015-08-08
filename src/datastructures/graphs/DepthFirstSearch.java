package datastructures.graphs;

import java.util.Stack;

public class DepthFirstSearch {
	private Graph g;
	private boolean visited[];
	private int parent[];

	/**
	 * Count of Connected components
	 */
	private int connected;

	/**
	 * DFS traversal
	 * 
	 * @param g
	 * @param src
	 */
	public DepthFirstSearch(Graph g, int src) {
		this.g = g;
		visited = new boolean[g.getVerticesCount()];
		parent = new int[g.getVerticesCount()];
		dfsUtil(src);
	}

	private void dfsUtil(int src) {
		connected++;
		visited[src] = true;
		for (Integer vertice : g.getAdjList(src)) {
			if (!visited[vertice]) {
				dfsUtil(vertice);
			}
		}
	}

	/**
	 * Returns path to destination from source if it exists
	 * 
	 * @param dest
	 * @return
	 */
	public Iterable<Integer> pathToDest(int dest) {
		if (!visited[dest])
			return null;
		Stack<Integer> pathStack = new Stack<>();
		for (int i = dest; parent[i] != 0; i = parent[i]) {
			pathStack.push(i);
		}
		pathStack.push(0);
		return pathStack;
	}

	public int getCountOfConnectedComps() {
		return this.connected;
	}
}
