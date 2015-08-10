package datastructures.graphs;

public class GraphTest {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addDirectedEdge(0, 3, 1);
		g.addDirectedEdge(0, 4, 1);
		g.addDirectedEdge(1, 4, 1);
		g.addDirectedEdge(2, 3, 1);
		g.addDirectedEdge(2, 0, 1);
		g.addDirectedEdge(3, 1, 1);

		DijkstrasSP d = new DijkstrasSP(g, 0);
		System.out.println("Distance to 4 from 0: " + d.getDistanceTo(4));

		ConnectedComponents cc = new ConnectedComponents(g);
		System.out.println("0, 4 Connected? " + cc.checkConnected(0, 4));
		System.out.println("2, 1 Connected? " + cc.checkConnected(2, 1));

		BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
		bfs.printPathTo(1);

		DepthFirstSearch dfs = new DepthFirstSearch(g, 2);
		dfs.printPathTo(4);

		TopologicalSort ts = new TopologicalSort(g);
		ts.printRanks();

		GraphCycle gc = new GraphCycle(g);
		System.out.println("Has Cycle: " + gc.hasCycle());
		g.addDirectedEdge(4, 3, 1);
		gc = new GraphCycle(g);
		System.out.println("Has Cycle: " + gc.hasCycle());
		gc.printCycle();
	}
}
