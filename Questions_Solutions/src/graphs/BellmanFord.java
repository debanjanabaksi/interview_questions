package graphs;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

	public static void main(String[] args) {
		
		BellmanFord bf = new BellmanFord();
		// List of graph edges as per above diagram
				List<Edge> edges = Arrays.asList(
						// (x, y, w) -> edge from x to y having weight w
						new Edge( 0, 1, -1 ), new Edge( 0, 2, 4 ),
						new Edge( 1, 2, 3 ), new Edge( 1, 3, 2 ),
						new Edge( 1, 4, 2 ), new Edge( 3, 2, 5 ),
						new Edge( 3, 1, 1 ), new Edge( 4, 3, -3 )
				);

				// Number of vertices in the graph
				final int N = 5;

				// let source be vertex 0
				int source = 0;

				// run Bellman Ford Algorithm from given source
				bf.bellmanFord(edges, N, source);

	}
	
	//Can create graph, pass it and fetch all values from adj list. that will give all edges.
	// using list of edges to save time and effort
	
	private void bellmanFord(List<Edge> edges, int N, int source) {
		int E = edges.size();
		int[] dist = new int[N];
		int [] parent = new int[N];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		parent[source] = -1;
		dist[source] = 0;
		// need to run N-1 times . 
		// a simple shortest path between two nodes without cycle should at most have N-1 edges
		for (int i = 0; i< N; i++) {
			// run over all edges
			for (Edge edge : edges) {
				int u = edge.getSource();
				int v = edge.getDestination();
				int wt = edge.getWeight();
				
				if (dist[u]!= Integer.MAX_VALUE && (dist[u]+ wt) < dist[v]) {
					dist[v]= dist[u]+ wt;
					parent[v] = u;
				}
			}
		}
		//Detect negative weighted cycles
		for(Edge edge : edges) {
			int u = edge.getSource();
			int v = edge.getDestination();
			int wt = edge.getWeight();
			
			if (dist[u]!= Integer.MAX_VALUE && (dist[u]+ wt) < dist[v]) {
				System.out.println("Negative weight cycle found");
				return;
			}
		}
		
		//Print path
		for (int i = 0; i < parent.length; i++) {
			System.out.println("Shortest path from source "+ source + " to "+i+" is ");
			printParent(parent, i);
			System.out.println("");
		}
	}
	
	private void printParent(int[] parent, int vertex) {
		if(vertex < 0) {
			return;
		}
		printParent(parent, parent[vertex]);
		System.out.print(" "+vertex);
	}
}
