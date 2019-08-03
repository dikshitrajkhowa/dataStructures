package graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Adjacency list representation of an Undirected Graph
 * 
 * @author dikshit.rajkhowa
 * 
 */

public class Graph {

	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V; // No of Vertices
	private int E; // No of edges
	private Map<Integer, List<Integer>> adjList; // Each map entry represent a
													// Vertex

	public Graph(int v) {

		this.V = v;
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices must be nonnegative");

		adjList = new LinkedHashMap<Integer, List<Integer>>();

		for (int i = 0; i < v; i++) {
			List<Integer> adjElement = new ArrayList<Integer>();
			adjList.put(i, adjElement);
		}

	}

	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adjList.get(v).add(w);
		adjList.get(w).add(v);
		E++;
	}

	public void removeEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adjList.get(v).remove(Integer.valueOf(w));
		adjList.get(w).remove(Integer.valueOf(v));
		E--;
	}

	//Gives the adjacent nodes for a node v
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adjList.get(v);
	}

	public int degree(int v) {
		return adjList.get(v).size();
	}
	
	public Iterable<String> edges(){
		List<String> edges = new ArrayList<>();
		for (Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			for (Integer i : entry.getValue()) {
				edges.add(entry.getKey()+"-"+i);
			}
		}
		return edges;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(NEWLINE);
		sb.append(V + " vertices , " + E + " edges" + NEWLINE);

		for (Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			sb.append(entry.getKey() + " : ");

			for (Integer i : entry.getValue()) {
				sb.append(i + " ");
			}
			sb.append(NEWLINE);
		}

		return "Graph " + sb.toString();
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IndexOutOfBoundsException("Vertex " + v + " should be within the range of 0 and " + (V - 1));

	}

	public int getE() {
		return E;
	}

	public int getV() {
		return V;
	}

	public int numVertices() {
		return V;
	}

	public int numEdges() {
		return E;
	}

	/**
	 * Test code, refer to Adjacency-list.png
	 * 
	 * Since it is an undirected graph we need to add either 0 - 1 or 1 - 0,
	 * both are same, we will follow the convention that i <= j, i.e. we will
	 * connect 0 and 1 not 1 and 0
	 */

	public static void main(String[] args) {
//		Graph g = new Graph(13);
//		g.addEdge(0, 1); //
//		g.addEdge(0, 2);
//		g.addEdge(0, 5);
//		g.addEdge(0, 6);
//		g.addEdge(3, 5);
//		g.addEdge(3, 4);
//		g.addEdge(4, 5);
//		g.addEdge(4, 6);
//		g.addEdge(7, 8);
//		g.addEdge(9, 10);
//		g.addEdge(9, 11);
//		g.addEdge(9, 12);
//		g.addEdge(11, 12);
//
//		System.out.println("Initial Graph\n");
//		System.out.println(g.toString());
//		g.removeEdge(9, 11);
//		System.out.println("\nAfter removal \n");
//		System.out.println(g.toString());
		
	}

}
