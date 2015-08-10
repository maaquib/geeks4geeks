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
		System.out.println("Distance to 4 from 0: " + d.getDIstanceTo(4));

		ConnectedComponents cc = new ConnectedComponents(g);
		System.out.println("0, 4 Connected? " + cc.checkConnected(0, 4));
		System.out.println("2, 1 Connected? " + cc.checkConnected(2, 1));

		BreadthFirstSearch bfs = new BreadthFirstSearch(g, 0);
		bfs.printPathTo(1);

		DepthFirstSearch dfs = new DepthFirstSearch(g, 2);
		dfs.printPathTo(4);
	}
}
