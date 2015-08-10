package datastructures.graphs;

import java.util.HashMap;

public class DijkstrasSP {
	private double dist[];
	private int parent[];

	/**
	 * TODO: Implement using priority queue
	 */
	private HashMap<Integer, Double> map = new HashMap<>();

	public DijkstrasSP(Graph graph, int src) {
		dist = new double[graph.getVerticesCount()];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Double.MAX_VALUE;
		}
		dist[src] = 0.0;
		map.put(src, 0.0);
		while (!map.isEmpty()) {
			int key = deleteMinKey();
			for (Edge edge : graph.getAdjList(key)) {
				relax(edge);
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

	private void relax(Edge edge) {
		if (dist[edge.to()] > dist[edge.from()] + edge.weight()) {
			dist[edge.to()] = dist[edge.from()] + edge.weight();
			parent[edge.to()] = edge.from();

			if (map.containsKey(edge.to())) {
				map.replace(edge.to(), dist[edge.to()]);
			} else {
				map.put(edge.to(), dist[edge.to()]);
			}
		}
	}

	public double getDIstanceTo(int dest) {
		return dist[dest];
	}
}
