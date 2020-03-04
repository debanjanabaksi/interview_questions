package hard;

import java.util.PriorityQueue;

/*
 * There are given n ropes of different lengths, we need to connect these ropes into one rope. 
 * The cost to connect two ropes is equal to sum of their lengths. 
 * We need to connect the ropes with minimum cost.
 */
public class ConnectRopesWithMinCost {

	public static void main(String[] args) {
		int len[] = { 4, 3, 2, 6 }; 
        System.out.println("Total cost for connecting ropes is " + connectRopes(len));
	}
	
	private static int connectRopes(int arr[]) {
		PriorityQueue<Integer> pq = new PriorityQueue();
		for (int i = 0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		int sum = 0;
		while(pq.size()>1) {
			int cost = pq.poll()+pq.poll();
			pq.add(cost);
			sum+=cost;
		}
		return sum;
	}
}
