package graphs;

public class Edge {
	
	Integer source;
	Integer destination;
	Integer weight;
	
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Edge(int source, int destination) {
		this.source = source;
		this.destination = destination;
	}
	
	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if(object == null || object.getClass() != getClass()) {
			return false;
		}
		Edge edge = (Edge)object;
		return(this.source.equals(edge.source) && this.destination .equals(edge.destination));
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7*hash + this.source.hashCode()+this.destination.hashCode();
		return hash;
		
	}
	
	

}
