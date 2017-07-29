package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	// To keep track of the nodes we check so we know if it connects to the
	// source.
	// If a node was checked, then there is a path to the node from a source

	private boolean[] checked;

	// To keep track of the parents that each child is connected to
	private int[] connectedTo;
	// Where we start our search from in the graph
	private int SOURCE;
	
	public BFS(Graph g, int rootVertex)
	{
    		//Initialize arrays with the size of the graph
    		checked = new boolean[g.getV()];
    		connectedTo = new int[g.getV()];
		
		    SOURCE = rootVertex;
		
    		bfs(g, rootVertex);		
	}
	
	// Go over the graph selecting the best parent-child connections
	private void bfs(Graph g, int source) {
		Queue<Integer> parentsQueue = new LinkedList<Integer>();

		// We check the source passed in as a parameter and mark it as checked
		checked[source] = true;
		parentsQueue.add(source); // We add our parent to the queue

		while (!parentsQueue.isEmpty()) {
			int parentVertex = parentsQueue.remove();

			// For every child connected to the parent
			for (int child : g.adj(parentVertex)) {

				if (!checked[child]) {
					// child is connected to the parent vertex
					connectedTo[child] = parentVertex;

					// So we don't check this node again
					checked[child] = true;
					// We add the next parent to the queue
					parentsQueue.add(child);
				}
			}
		}
		System.out.println();
	}
	
	// This method just allows us to check if a vertex is connected to the
	// source.
	// If a vertex has been checked then it is connected
	public boolean hasPathTo(int vertex) {
		return checked[vertex];
	}
	
	//This method returns the path from the SOURCE to a given vertex
	public List pathTo(int vertex) {
		if (!hasPathTo(vertex))
			return null;

		List path = new ArrayList();

		// First add the vertex passed in to the method
		path.add(vertex);

		// Since we are iterating through a queue,
		// we check form vertex(goal) to source
		while (connectedTo[vertex] != SOURCE) {
			vertex = connectedTo[vertex];
			path.add(vertex);
		}
		path.add(SOURCE); // Now we add the source at the very end

		return path; // We return a path from the vertex to the source
	}
	
	public static void main(String [] args)
	{
		Graph myGraph = new Graph(12);
		
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 2);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(1, 5);
		myGraph.addEdge(2, 6);
		myGraph.addEdge(3, 7);
		myGraph.addEdge(3, 8);
		myGraph.addEdge(5, 9);
		myGraph.addEdge(9, 10);
		myGraph.addEdge(9, 11);
		
		int source = 0;
		
		BFS search = new BFS(myGraph, source);
		
		
	}
	
	
}
