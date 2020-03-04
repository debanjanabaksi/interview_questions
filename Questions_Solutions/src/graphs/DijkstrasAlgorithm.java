package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

	Map<Integer, Integer> parent = new HashMap<>();
	public static void main(String[] args) {
		
		// initialize edges as per above diagram
				// (u, v, w) triplet represent undirected edge from
				// vertex u to vertex v having weight w
				List<Edge> edges = Arrays.asList(
						new Edge(0, 1, 10), new Edge(0, 4, 3),
						new Edge(1, 2, 2), new Edge(1, 4, 4),
						new Edge(2, 3, 9), new Edge(3, 2, 7),
						new Edge(4, 1, 1), new Edge(4, 2, 8),
						new Edge(4, 3, 2)
				);

				// Set number of vertices in the graph
				final int N = 5;

				// construct graph
				Graph graph = new Graph();
				graph.addWeightedEdges(edges);
				
				DijkstrasAlgorithm dj = new DijkstrasAlgorithm();

				dj.shortestPath(graph, 0, N);
	}
	
	//This algo finds shortest path of all nodes from source, if dest is given can break once dest is reached.
		private void shortestPath(Graph g, int source, int N) {
			PriorityQueue<Node> pq = new PriorityQueue(N, new Node());
			List<Integer> dist = new ArrayList<Integer> (); // this can be map too in case of string nodes
			boolean visited[] = new boolean[N]; // can use map if nodes are names or strings
			Map<Integer, Integer> parent = new HashMap<>(); // could have used array to hold parent but since ths will be needed
															// if node is a string and manipulating this is tough. 
			int[]parentArray = new int[N];
			parentArray[source] = -1;
			//init dist to max
			for (int i = 0; i < N ; i++) {
				dist.add(Integer.MAX_VALUE);
			}
			
			dist.set(source, 0);
			Node sourceNode = new Node(source,0);
			parent.put(source, null);
			
			pq.add(sourceNode);
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				int u = n.vertex;
				
				List<Edge> edges = g.adjacencyList.get(u);
				for(Edge e : edges) {
					int v = e.getDestination();
					int w = e.getWeight();
					if(!visited[v]) {
						int distToV = dist.get(u)+w;
						//dist from source upto v through u is < current dist form source to v
						if(distToV < dist.get(v)) {
							dist.set(v, distToV);
							pq.add(new Node(v, distToV));
							parent.put(v, u);
							parentArray[v] = u;
						}
						
					}
				}
				visited[u] = true; // so after the node has been examined, we mark it as visited.
			}
			
			for (int i = 1; i<N; i++) {
				System.out.println("Path from vertex 0 to "+i+" and min cost "+ dist.get(i)+ " is ");
				printPath(parent, i);
				System.out.println("\n");
			}
			
			for (int i = 1; i<N; i++) {
				System.out.println("Path from vertex 0 to "+i+" and min cost "+ dist.get(i)+ " is ");
				printPath(parentArray, i);
				System.out.println();
			}
		}
		
		public void printPath(Map<Integer, Integer> parent, Integer vertex) {
			//System.out.println(" node is "+vertex+ " parent is "+parent.get(vertex));
			if(vertex == null) {
				//System.out.print(" "+vertex);
				return;
			} 
			printPath(parent, parent.get(vertex));
			System.out.print(" "+vertex );
		}
		
		public void printPath(int[] parent, int vertex) {
			//System.out.println(" node is "+vertex+ " parent is "+parent.get(vertex));
			if(vertex < 0 ) {
				//System.out.print(" "+vertex);
				return;
			} 
			printPath(parent, parent[vertex]);
			System.out.print(" "+vertex );
		}

}
