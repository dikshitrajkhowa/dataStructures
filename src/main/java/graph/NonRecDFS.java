package graph;

import java.util.Iterator;
import java.util.Stack;

public class NonRecDFS {
	
	private boolean [] marked;

	public NonRecDFS(Graph G, int source) {
		
		marked = new boolean[G.getV()];
		
		//Iterator to each list of neigbours for a vertex
		Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.getV()];
		for (int v = 0; v < G.getV(); v++)
			adj[v] = G.adj(v).iterator();
		
		 // depth-first search using an explicit stack
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        System.out.print(source +" ");
        marked[source] = true;
		
        while(!stack.isEmpty())
        {
        	int v = stack.peek();
        	
        	if(adj[v].hasNext())
        	{
        		int w = adj[v].next();
        		
        		if(!marked[w])
        		{
        			marked[w]= true;
        			stack.push(w);
        			System.out.print(w +" ");
        		}
        	}else
        	{
        		int s = stack.pop();
        		
        	}
        }
        
        
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
			NonRecDFS dfs = new NonRecDFS(g, 0);
		

		}

}
