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
		System.out.println();

		ConnectedComponents cc = new ConnectedComponents(g);
		System.out.println("0, 4 Connected? " + cc.checkConnected(0, 4));
		System.out.println("2, 1 Connected? " + cc.checkConnected(2, 1));
		System.out.println();

		BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
		System.out.print("Path from 0 to 1: ");
		bfs.printPathTo(1);
		System.out.println();

		DepthFirstSearch dfs = new DepthFirstSearch(g, 2);
		System.out.print("Path from 2 to 4: ");
		dfs.printPathTo(4);
		System.out.println();

		TopologicalSort ts = new TopologicalSort(g);
		ts.printRanks();
		System.out.println();

		PrimsMST prim = new PrimsMST(g);
		System.out.println("Weight of MST: " + prim.weight());
		System.out.println();

		Bipartite b = new Bipartite(g);
		System.out.println("Is bipartite: " + b.isBipartite());
		b.printCycle();
		System.out.println();

		GraphCycle gc = new GraphCycle(g);
		System.out.println("Has Cycle: " + gc.hasCycle());
		g.addDirectedEdge(4, 3, 1);
		gc = new GraphCycle(g);
		System.out.println("Has Cycle: " + gc.hasCycle());
		System.out.print("Cycle: ");
		gc.printCycle();
		System.out.println();
	}
}
