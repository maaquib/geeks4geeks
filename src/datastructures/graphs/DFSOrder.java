package datastructures.graphs;

import java.util.Stack;

import datastructures.queue.Queue;

/**
 * Topological Sorting for DAGs
 * 
 * @author aaqib
 *
 */
public class DFSOrder {
	private boolean[] visited;

	private int[] preOrder;
	private int[] postOrder;

	private Queue preQ;
	private Queue postQ;
	private int preCounter;
	private int postCounter;

	public DFSOrder(Graph g) {
		visited = new boolean[g.getVerticesCount()];
		preOrder = new int[g.getVerticesCount()];
		postOrder = new int[g.getVerticesCount()];
		preQ = new Queue(g.getVerticesCount());
		postQ = new Queue(g.getVerticesCount());
		for (int i = 0; i < g.getVerticesCount(); i++) {
			if (!visited[i]) {
				dfs(g, i);
			}
		}
	}

	private void dfs(Graph g, int src) {
		visited[src] = true;
		preOrder[src] = preCounter++;
		preQ.enqueue(src);
		for (Edge edge : g.getAdjList(src)) {
			Integer vertice = edge.to();
			if (!visited[vertice]) {
				dfs(g, vertice);
			}
		}
		postOrder[src] = postCounter++;
		postQ.enqueue(src);
	}

	/**
	 * Returns the reverse of the post-order (topological order)
	 * 
	 * @return
	 */
	public Iterable<Integer> reversePostOrder() {
		Stack<Integer> reverse = new Stack<>();
		while (!postQ.isEmpty()) {
			reverse.push(postQ.dequeue());
		}
		return reverse;
	}
}
