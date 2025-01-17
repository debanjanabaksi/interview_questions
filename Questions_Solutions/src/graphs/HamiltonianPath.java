package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamiltonianPath {

	public static void main(String[] args) {
		
		
		HamiltonianPath hp = new HamiltonianPath();
		
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 2), new Edge(0, 3), new Edge(1, 2), new Edge(1, 3),
				new Edge(2, 3));

		// Set number of vertices in the graph
		final int N = 4;
		
		Graph graph = new Graph();
		graph.addUndirectedEdges(edges);
		
		Integer source = 0;
		boolean[] visited = new boolean[N];
		visited[source] = true;
		List<Integer> path = new ArrayList<>();
		path.add(source);
		
		hp.findHamiltonian(graph, source, visited, path, N);

	}
	
	private void findHamiltonian(Graph g, Integer source, boolean[] visited, List<Integer> path, int N) {
		 if (path.size() == N) {
			 System.out.println ("\nPath found");
			 for (int i : path) {
				 System.out.print(" "+i);
			 }
			return; 
		 }
		 
		List<Edge> edges =  g.adjacencyList.get(source);
		
		for ( Edge e : edges) {
			int w = e.getDestination();
			if(!visited[w]) {
				visited[w] = true;
				path.add(w);
				
				findHamiltonian(g, w, visited, path, N);
				
				visited[w] = false;
				path.remove(path.size() -1 );
				
			}
		}
	}

}
