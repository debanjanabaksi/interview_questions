package graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class TopologicalSort {

	public static void main(String[] args) {
		
		TopologicalSort ts = new TopologicalSort();
		
		Graph g = new Graph(); 
        g.addDirectedEdge(5, 2); 
        g.addDirectedEdge(5, 0); 
        g.addDirectedEdge(4, 0); 
        g.addDirectedEdge(4, 1); 
        g.addDirectedEdge(2, 3); 
        g.addDirectedEdge(3, 1); 
  
        System.out.println("Following is a Topological sort of the given graph based on DFS"); 
        ts.runTopologicalSort(g); 
        System.out.println("\nFollowing is a Topological sort of the given graph using Kahn Algorithm"); 
        ts.topologicalSort_KahnAlgo(g);

	}
	
	public void runTopologicalSort(Graph graph) {
		Stack<Integer> st = new Stack<>();
		int n = graph.adjacencyList.size();
		boolean visited[] = new boolean[n];
		for (int i= 0; i<n; i++) {
			if(!visited[i]) {
				topologicalSort(graph, visited, st, i);
			}
		}
		
		while(!st.isEmpty()) {
			System.out.print(" "+st.pop());
		}
	}
	
	private void topologicalSort(Graph graph, boolean[] visited, Stack<Integer> st, Integer source) {
		visited[source] = true;
		List<Edge> edgeList = graph.adjacencyList.get(source);
		for(Edge e : edgeList) {
			Integer v = e.getDestination();
			if(!visited[v]) {
				topologicalSort(graph, visited, st, v);
			}
		}
		st.add(source);
	}
	
	private void topologicalSort_KahnAlgo(Graph graph) {
		int nodeCount = graph.adjacencyList.size();
		Queue<Integer> q = new ArrayDeque<Integer>();
		Vector<Integer> topoSort = new Vector<>(); 
		int cntVisited = 0;
		Integer[] inDegree = new Integer[nodeCount]; 
		for (int i=0; i<nodeCount; i++) {
			inDegree[i] = 0;
		}
		//Find in degree of each node
		
		for(List<Edge> edges : graph.adjacencyList.values() ) {
			for (Edge e : edges) {
				Integer destination = e.getDestination();
				inDegree[destination] ++;
			}
		}
		
		for (int i = 0; i< nodeCount ; i++ ) {
			System.out.println("In degree of node "+i+" is "+inDegree[i]);
		}
		
		// Find node with indegree 0
		for (int i = 0; i< nodeCount ; i++ ) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		// Poll from queue Increase count of visited node, add node to sort, visited neighbours and reduce indegree, add to queue if in degree is 0
		while(!q.isEmpty()) {
			Integer u = q.poll();
			cntVisited++;
			topoSort.add(u);
			for (Edge e : graph.adjacencyList.get(u)) {
				Integer v = e.getDestination();
				inDegree[v] --;
				if(inDegree[v] == 0 ) {
					q.add(v);
				}
			}
		}
		//Check for sort
		if (cntVisited!=nodeCount) {
			System.out.println("Graph conrains cycle topological sort not possible");
			return;
		}
		//Print sorted order
		for (int i = 0; i< topoSort.size(); i++) {
			System.out.print(" "+topoSort.get(i));
		}
	}

}
