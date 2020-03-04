package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Widest Path Problem is a problem of finding a path between two vertices of the graph maximizing the weight of the minimum-weight edge in the path. 
 */
public class WidestPathDijkstra {

	public static void main(String[] args) {
		WidestPathDijkstra wp = new WidestPathDijkstra();
		List<Edge> edges = Arrays.asList(new Edge(1,2,1), new Edge(2,3,3), new Edge(1,4,2), new Edge(4,3,5));
		Graph g = new Graph();
		g.addWeightedEdges(edges);
		wp.widestPath(g, 1, 4);
	}

	public void widestPath(Graph graph, int source, int N) { 
		PriorityQueue<Node> pq = new PriorityQueue<Node>(N+1, new Node());
		int[] parent = new int[N+1];
		int[] widest = new int[N+1];
		//boolean visited[] = new boolean[N+1];
		for(int i = 0; i < N+1; i++) {
			widest[i] = Integer.MIN_VALUE;
		}
		widest[source] =  Integer.MAX_VALUE;
		Node sourceNode = new Node(source, 0);
		pq.add(sourceNode);
		parent[source] = -1;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			Integer u = n.vertex;
			
			for (Edge edge : graph.adjacencyList.get(u)) {
				int v = edge.getDestination();
				int wt = edge.getWeight();
				
					int weight = Math.max(widest[v], Math.min(widest[u], wt));
					//System.out.println(widest[v] + " "+ widest[u]+" "+ wt+ " "+ weight);
					if(weight > widest[v]) {
						widest[v] = weight;
						Node vNode = new Node(v, weight);
						parent[v] = u;
						pq.add(vNode);
					
				}
			}
		}
		 for (int i = 1; i < N+1 ; i++) {
			 System.out.println("Widest path from "+ source + "to "+ i+" is ");
			 printPath(parent, i);
			 System.out.println("\n bottle neck width is "+ widest[i]);
			 
		 }
	}
	
	private void printPath(int[] parent, int vertex) {
		//System.out.print(" "+vertex);
		if(vertex < 0) {
			return;
		}
		printPath(parent, parent[vertex]);
		System.out.print(" "+vertex);
	}
	
}
