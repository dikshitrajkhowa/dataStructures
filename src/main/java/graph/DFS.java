package graph;

/**
 * Implementation of Depth First Search
 * using recursion
 * 
 * @author dikshit.rajkhowa
 *
 */
public class DFS {

	private boolean[] marked; // marked[v] = is there an s-v path?
	private int count; // number of vertices connected to s
	
	/**
     * Computes the vertices in graph <tt>G</tt> that are
     * connected to the source vertex <tt>s</tt>.
     * @param G the graph
     * @param s the source vertex
     */
	
	public DFS(Graph G, int s) {
		 marked = new boolean[G.getV()];
		 dfs(G,s);
	}

	 // depth first search from v
	private void dfs(Graph g, int v) {
		count++;
		marked[v] = true;
		System.out.print(v+" ");
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
		
	}
	
	 /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
	
	public boolean marked(int v) {
		return marked[v];
	}
	
	 /**
     * Returns the number of vertices connected to the source vertex <tt>s</tt>.
     * @return the number of vertices connected to the source vertex <tt>s</tt>
     */
    public int count() {
        return count;
    }


    //Test code
	public static void main(String[] args) {

		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 5);
		g.addEdge(1, 6);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(6, 4);
		
		System.out.println(g.toString());
		DFS dfs = new DFS(g, 0);
		
//		for(int v=0; v <g.getV();v++)
//		{
//			if(dfs.marked(v))
//			{
//				System.out.println(v +" ");
//			}
//		}
	}
}
