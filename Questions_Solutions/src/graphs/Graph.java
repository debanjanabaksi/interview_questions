package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//currently considering undirected graphs with nodes represented by integers

// Other graph implementations available using the easiest one
public class Graph {

	public Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
	public static void main(String[] args) {

	}
	
	public void addVertex(Integer x) {
		adjacencyList.putIfAbsent(x, new ArrayList<Edge>());
	}
	
	public void addEdge(Integer source, Integer destination) {
		Edge e1 = new Edge(source,destination);
		Edge e2 = new Edge(destination, source);
		if(!adjacencyList.containsKey(source)) {
			addVertex(source);
		}
		if(!adjacencyList.containsKey(destination)) {
			addVertex(destination);
		}
		adjacencyList.get(source).add(e1);
		adjacencyList.get(destination).add(e2);
	}
	
	public void addDirectedEdge(Integer source, Integer destination) {
		Edge e = new Edge(source,destination);
		if(!adjacencyList.containsKey(source)) {
			addVertex(source);
		}
		if(!adjacencyList.containsKey(destination)) {
			addVertex(destination);
		}
		adjacencyList.get(source).add(e);
	}
	
	public void addDirectedEdge(Integer source, Integer destination, Integer weight) {
		Edge e = new Edge(source, destination, weight);
		if(!adjacencyList.containsKey(source)) {
			addVertex(source);
		}
		if(!adjacencyList.containsKey(destination)) {
			addVertex(destination);
		}
		adjacencyList.get(source).add(e);
	}
	
	public void removeEdge(Integer source, Integer destination) {
		Edge e = new Edge(source, destination);
		adjacencyList.get(source).remove(e);
	}

	public void removeVertex(Integer vertex) {
		adjacencyList.remove(vertex);
	}
	
	public Graph(List<Edge> edges) {
		for(Edge e : edges) {
			addDirectedEdge(e.getSource(), e.getDestination());
		}
	}
	
	public Graph() {
		
	}
	
	public void addUndirectedEdges(List<Edge> edges) {
		for (Edge edge : edges) {
			addEdge(edge.source, edge.destination);
		}
	}
	
	public void addWeightedEdges(List<Edge> edges) {
		for(Edge e : edges) {
			addDirectedEdge(e.getSource(), e.getDestination(), e.getWeight());
		}
	}

}
