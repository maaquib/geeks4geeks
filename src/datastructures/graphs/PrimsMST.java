package datastructures.graphs;

import java.util.HashMap;

public class PrimsMST {
	private double[] dist;
	private boolean[] visited;
	private Edge[] mstEdge;
	private HashMap<Integer, Double> map = new HashMap<>();

	public PrimsMST(Graph g) {
		mstEdge = new Edge[g.getVerticesCount()];
		visited = new boolean[g.getVerticesCount()];

		dist = new double[g.getVerticesCount()];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Double.MAX_VALUE;
		}

		for (int i = 0; i < g.getVerticesCount(); i++) {
			if (!visited[i]) {
				prims(g, i);
			}
		}
	}

	private void prims(Graph g, int i) {
		dist[i] = 0;
		map.put(i, dist[i]);
		while (!map.isEmpty()) {
			int src = deleteMinKey();
			scan(g, src);
		}
	}

	private void scan(Graph g, int src) {
		visited[src] = true;
		for (Edge edge : g.getAdjList(src)) {
			Integer vertice = edge.to();
			if (!visited[vertice]) {
				if (edge.weight() < dist[vertice]) {
					dist[vertice] = edge.weight();
					mstEdge[vertice] = edge;

					if (map.containsKey(edge.to())) {
						map.replace(edge.to(), dist[edge.to()]);
					} else {
						map.put(edge.to(), dist[edge.to()]);
					}
				}
			}
		}
	}

	private int deleteMinKey() {
		int min = 0;
		double minValue = Double.MAX_VALUE;
		for (int key : map.keySet()) {
			if (map.get(key) < minValue) {
				min = key;
				minValue = map.get(key);
			}
		}
		map.remove(min);
		return min;
	}

	public double weight() {
		double weight = 0.0;
		for (Edge e : mstEdge) {
			if (e != null) {
				weight += e.weight();
			}
		}
		return weight;
	}
}
