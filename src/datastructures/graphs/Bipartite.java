package datastructures.graphs;

import java.util.Stack;

/**
 * Checks to see if the graph is bipartite. If it isn't returns the odd cycle
 * 
 * @author aaqib
 *
 */
public class Bipartite {
	private int[] parent;
	private boolean[] visited;
	private boolean[] color;
	private Stack<Integer> cycle;
	private boolean isBipartite;

	public Bipartite(Graph g) {
		isBipartite = true;

		parent = new int[g.getVerticesCount()];
		visited = new boolean[g.getVerticesCount()];
		color = new boolean[g.getVerticesCount()];

		for (int i = 0; i < g.getVerticesCount(); i++) {
			if (!visited[i]) {
				dfs(g, i);
			}
		}
	}

	private void dfs(Graph g, int src) {
		visited[src] = true;
		for (Edge edge : g.getAdjList(src)) {
			Integer vertex = edge.to();
			if (cycle != null) {
				isBipartite = false;
				return;
			}
			if (!visited[vertex]) {
				parent[vertex] = src;
				color[vertex] = !color[src];
				dfs(g, vertex);
			} else if (color[vertex] == color[src]) {
				isBipartite = false;
				cycle = new Stack<>();
				for (int i = src; i != vertex; i = parent[i]) {
					cycle.push(i);
				}
				cycle.push(vertex);
			}
		}
	}

	public boolean isBipartite() {
		return isBipartite;
	}

	public void printCycle() {
		if (isBipartite) {
			System.out.println("Graph is Bipartite. No odd cycle");
			return;
		}
		for (Integer item : cycle) {
			System.out.print(item + "<-");
		}
		System.out.println();
	}
}
