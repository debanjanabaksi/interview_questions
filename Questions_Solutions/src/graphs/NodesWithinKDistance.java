package graphs;

import java.util.Arrays;
import java.util.List;

public class NodesWithinKDistance {

	public static void main(String[] args) {
		NodesWithinKDistance nk = new NodesWithinKDistance();
		List<Edge> edges = Arrays.asList(new Edge(2,1), new Edge(2,5), new Edge(5,4), new Edge(5,7), new Edge(4,3), new Edge(7,6) );
		Graph graph = new Graph();
		graph.addUndirectedEdges(edges);
		int n = graph.adjacencyList.size();
		boolean [] visited = new boolean [n+1];
		int source = 4;
		int k = 2;
		
		nk.Dfs(k,visited,source,graph);
		

	}
	
	private void Dfs(int k, boolean[] visited, int source, Graph g ) {
		if (k < 0) {
			return;
		}
		visited[source] = true;
		System.out.print(" "+source);
		List<Edge> edges = g.adjacencyList.get(source);
		
		for (Edge e : edges) {
			int v = e.getDestination();
			if(!visited[v]) {
				Dfs(k-1,visited,v,g);
			}
		}
	}
	
	

}
