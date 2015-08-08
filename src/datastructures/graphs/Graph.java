package datastructures.graphs;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Graph: Adjacency List Representation
 * 
 * @author aaqib
 *
 */
public class Graph {
	private HashMap<Integer, LinkedList<Integer>> adjLists = new HashMap<>();

	private int nodes;
	private int edges;

	public Graph(int nodes) {
		this.nodes = nodes;
		this.edges = 0;
		for (int i = 0; i < nodes; i++) {
			this.adjLists.put(i, new LinkedList<>());
		}
	}

	public void addUndirectedEdge(int src, int dest, int wt) {
		LinkedList<Integer> adjList = this.adjLists.get(src);
		adjList.add(dest);
		adjLists.put(src, adjList);
		adjList = this.adjLists.get(dest);
		adjList.add(src);
		this.edges += 2;
	}

	public void addDirectedEdge(int src, int dest, int wt) {
		LinkedList<Integer> adjList = this.adjLists.get(src);
		adjList.add(dest);
		adjLists.put(src, adjList);
		this.edges++;
	}

	public int getEdgesCount() {
		return this.edges;
	}

	public int getVerticesCount() {
		return this.nodes;
	}

	/**
	 * returns the adjacency list of the given graph node
	 * 
	 * @param src
	 * @return
	 */
	public Iterable<Integer> getAdjList(int src) {
		if (src < 0 || src >= this.nodes) {
			return null;
		}
		return this.adjLists.get(src);
	}

	public void printGraph() {
		for (Integer vertice : adjLists.keySet()) {
			System.out.println("Adjacency List of" + vertice + ":");
			for (Integer neighbour : adjLists.get(vertice)) {
				System.out.print(neighbour + " ");
			}
			System.out.println();
		}
	}
}
