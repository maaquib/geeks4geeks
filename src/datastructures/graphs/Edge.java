package datastructures.graphs;

public class Edge implements Comparable<Edge> {
	private final int from;
	private final int to;
	private final double weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int otherVertice(int v) {
		if (v == from) {
			return to;
		}
		if (v == to) {
			return from;
		}
		return Integer.MIN_VALUE;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight)
			return -1;
		if (this.weight > that.weight)
			return 1;
		return 0;
	}

	public int getFromVertice() {
		return from;
	}

	public int getToVertice() {
		return to;
	}

	public double getWeight() {
		return weight;
	}
}
