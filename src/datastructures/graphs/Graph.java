package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Graph: Adjacency List Representation
 * 
 * @author aaqib
 *
 */
public class Graph {
	private HashMap<Integer, ArrayList<Edge>> adjLists = new HashMap<>();

	private int nodesCount;
	private int edgesCount;

	public Graph(int nodes) {
		this.nodesCount = nodes;
		this.edgesCount = 0;
		for (int i = 0; i < nodes; i++) {
			this.adjLists.put(i, new ArrayList<>());
		}
	}

	public void addUndirectedEdge(int src, int dest, int wt) {
		ArrayList<Edge> adjList = this.adjLists.get(src);
		adjList.add(new Edge(src, dest, wt));
		adjLists.put(src, adjList);

		adjList = this.adjLists.get(dest);
		adjList.add(new Edge(dest, src, wt));
		adjLists.put(dest, adjList);

		this.edgesCount += 2;
	}

	public void addDirectedEdge(int src, int dest, int wt) {
		ArrayList<Edge> adjList = this.adjLists.get(src);
		adjList.add(new Edge(src, dest, wt));
		adjLists.put(src, adjList);

		this.edgesCount++;
	}

	public int getEdgesCount() {
		return this.edgesCount;
	}

	public int getVerticesCount() {
		return this.nodesCount;
	}

	/**
	 * returns the adjacency list of the given graph node
	 * 
	 * @param src
	 * @return
	 */
	public ArrayList<Edge> getAdjList(int src) {
		if (src < 0 || src >= this.nodesCount) {
			return null;
		}
		return this.adjLists.get(src);
	}

	public void printGraph() {
		for (Integer vertice : adjLists.keySet()) {
			System.out.println("Adjacency List of" + vertice + ":");
			for (Edge neighbour : adjLists.get(vertice)) {
				System.out.print(neighbour.to() + " ");
			}
			System.out.println();
		}
	}
}
