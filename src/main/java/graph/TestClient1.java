package graph;

public class TestClient1 {
	public static void main(String[] args) {
		Graph g = new Graph(13);
		g.addEdge(0, 1); //
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(3, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(7, 8);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(11, 12);

		System.out.println("Initial Graph\n");
		System.out.println(g.toString());
		g.removeEdge(9, 11);
		System.out.println("\nAfter removal \n");
		System.out.println(g.toString());
		
		System.out.println("Adjacent nodes of 9 :: "+g.adj(9));
		System.out.println("\nList of Edges :: "+g.edges());
	}
}
