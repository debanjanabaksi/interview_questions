package graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TraversalBfsDfs {

	public static void main(String[] args) {
		// List of graph edges as per above diagram
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 3);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(5, 9);
		graph.addEdge(5, 10);
		graph.addEdge(4, 7);
		graph.addEdge(4, 8);
		graph.addEdge(7, 11);
		graph.addEdge(7, 12);
		graph.addVertex(0);
		graph.addVertex(13);
		graph.addVertex(14);

		// vertex 0, 13 and 14 are single nodes

		TraversalBfsDfs bfs = new TraversalBfsDfs();
		bfs.runBFS(graph);
		bfs.runDFS(graph);

	}

	public void runBFS(Graph graph) {
		int n = graph.adjacencyList.size();

		System.out.println("Number of nodes in graph is : " + n);
		System.out.println("Running BFS...");

		boolean[] visited = new boolean[n];

		// Do BFS traversal from all nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < 15; i++) {
			if (!visited[i]) {
				// start BFS traversal from vertex i
				// System.out.println("\nStarting BFS from "+i+" : ");
				BFS(graph, i, visited);
			}
		}

		System.out.println("\nNumber of nodes in graph is : " + n);
		System.out.println("Running BFS recusrsively...");
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited2 = new boolean[n];
		for (int i = 0; i < 15; i++) {
			if(!visited2[i]) {
				visited2[i] = true;
				queue.add(i);
				BFS_recursive(graph, visited, queue);
				
			}
		}
		
	}

	public void runDFS(Graph graph) {
		int n = graph.adjacencyList.size();

		System.out.println("\nNumber of nodes in graph is : " + n);
		System.out.println("Running DFS iteratively...");

		boolean[] visited = new boolean[n];
		for (int i = 0; i < 15; i++) {
			if (!visited[i]) {
				DFS_iterative(graph, i, visited);
			}
		}
		boolean[] visited2 = new boolean[n];
		System.out.println("\nRunning DFS recusrsively...");
		for (int i = 0; i < 15; i++) {
			if (!visited2[i]) {
				DFS_recursive(graph, i, visited2);
			}
		}
	}

	// adjacency list here is holding an edge since provision has been kept for the
	// weight of the edge else it may just hold a list of vertices
	public void BFS(Graph graph, Integer source, boolean[] visited) {

		Queue<Integer> q = new ArrayDeque<>();

		q.add(source);
		visited[source] = true;

		while (!q.isEmpty()) {
			Integer u = q.poll();
			System.out.print(" " + u);
			List<Edge> edgeList = graph.adjacencyList.get(u);
			for (Edge e : edgeList) {
				Integer v = e.getDestination();
				if (visited[v] == false) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}

	public void DFS_iterative(Graph graph, Integer source, boolean[] visited) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		while (!stack.isEmpty()) {
			Integer u = stack.pop();
			if (!visited[u]) {
				System.out.print(" " + u);
				visited[u] = true;
				List<Edge> edgeList = graph.adjacencyList.get(u);
				for (Edge e : edgeList) {
					Integer v = e.getDestination();
					if (!visited[v]) {
						stack.push(v);
					}
				}

			}
		}
	}

	public void DFS_recursive(Graph graph, Integer source, boolean[] visited) {
		// Control condition not needed since after all nodes are visited, no more nodes
		// will be processed
		// Also since only non visited nodes are passed for recursion, this condition
		// check is redundant
//		if (visited[source]) {
//			return;
//		}
		System.out.print(" " + source);
		visited[source] = true;
		List<Edge> edgeList = graph.adjacencyList.get(source);
		for (Edge e : edgeList) {
			Integer v = e.getDestination();
			if (!visited[v]) {
				DFS_recursive(graph, v, visited);
			}
		}
	}
	
	public void BFS_recursive(Graph graph, boolean[] visited, Queue<Integer> q) {
		if(q.isEmpty()) {
			return;
		}
		Integer u = q.poll();
		System.out.print(" "+u);
		List<Edge> edgeList = graph.adjacencyList.get(u);
		for (Edge e : edgeList) {
			Integer v = e.getDestination();
			if(!visited[v]) {
				visited[v] = true;
				q.add(v);	
			}
		}
		BFS_recursive(graph, visited, q);
		
	}

}
