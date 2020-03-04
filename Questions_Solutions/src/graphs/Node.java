package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Node implements Comparator<Node>{
	
	Integer vertex;
	int minDist; // min dist from source or can also be called dist from source. not changing code again
	
	public Node(Integer vertex, int minDist) {
		this.vertex = vertex;
		this.minDist = minDist;
	}

	public Node() {
		
	}

	@Override
	public int compare(Node n1, Node n2) {
		if(n1.minDist < n2.minDist) {
			return -1;
		}
		if(n1.minDist > n2.minDist) {
			return 1;
		}
		
		return 0;
	}
	

}
