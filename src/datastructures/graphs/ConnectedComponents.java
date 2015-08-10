package datastructures.graphs;

public class ConnectedComponents {
	private boolean[] visited;
	private int[] ccId;
	private int[] ccSize;
	private int count;

	public ConnectedComponents(Graph g) {
		visited = new boolean[g.getVerticesCount()];
		ccId = new int[g.getVerticesCount()];
		ccSize = new int[g.getVerticesCount()];
		count = 0;
		for (int i = 0; i < g.getVerticesCount(); i++) {
			if (!visited[i]) {
				dfs(g, i);
				count++;
			}
		}
	}

	private void dfs(Graph g, int i) {
		ccSize[count]++;
		ccId[i] = count;
		visited[i] = true;
		for (Edge e : g.getAdjList(i)) {
			Integer vertice = e.to();
			if (!visited[vertice]) {
				dfs(g, vertice);
			}
		}
	}

	public boolean checkConnected(int i, int j) {
		return ccId[i] == ccId[j];
	}
}
