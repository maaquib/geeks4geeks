package datastructures.graphs;

import java.util.Stack;

/**
 * Checks for cycles in a Directed graph
 * 
 * @author aaqib
 *
 */
public class GraphCycle {
	private int[] parent;
	private boolean[] onStack;
	private boolean[] visited;
	private Stack<Integer> cycle;

	public GraphCycle(Graph g) {
		parent = new int[g.getVerticesCount()];
		onStack = new boolean[g.getVerticesCount()];
		visited = new boolean[g.getVerticesCount()];

		for (int i = 0; i < g.getVerticesCount(); i++) {
			if (!visited[i] && cycle == null) {
				dfs(g, i);
			}
		}
	}

	private void dfs(Graph g, int src) {
		onStack[src] = true;
		visited[src] = true;
		for (Edge edge : g.getAdjList(src)) {
			Integer vertice = edge.to();
			if (cycle != null) {
				return;
			} else if (!visited[vertice]) {
				parent[vertice] = src;
				dfs(g, vertice);
			} else if (onStack[vertice]) {
				cycle = new Stack<>();

				/**
				 * Cycle Traceback
				 */
				for (int j = src; j != vertice; j = parent[j]) {
					cycle.push(j);
				}
				cycle.push(vertice);
				cycle.push(src);
			}
		}
		onStack[src] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public void printCycle() {
		for (Integer vertice : cycle) {
			System.out.print(vertice + "<-");
		}
	}
}
