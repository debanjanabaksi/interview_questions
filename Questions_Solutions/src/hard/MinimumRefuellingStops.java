package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  Given an integer target which represents the total distance to be covered by a car on a straight road.
 *  Given another array, station[] of size N representing petrol pumps where ith petrol pump is station[i][0] position away from the start and has station[i][1] amount of fuel. 
 *  The car has an infinite petrol capacity and starts with M amount of fuel. The task is to find the minimum number of times 
 *  the car has to stop for refueling to reach the end when it uses one unit of fuel for moving one unit distance.

    Note: If it reaches ith station with 0 fuel left, it can refuel from that petrol pump and all the fuel from a petrol pump can be transferred to the car.
    
 */
// Reference of impl from leet code : https://leetcode.com/problems/minimum-number-of-refueling-stops/solutions/294025/Java-Simple-Code-Greedy/
// GFG : https://www.geeksforgeeks.org/minimize-refills-to-reach-end-of-path/
public class MinimumRefuellingStops {

	public static void main(String[] args) {
		
		int target = 100, M = 10;
        int stations[][] = {
            { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 }
        };
        System.out.println("Min stops to refuel = "+ minStops(target, M, stations));
        System.out.println("Min stops to refuel = "+ minStops2(target, M, stations));

	}
	
	// O(nlogn) time ands O(n) space
	// Inner while executes only once per station.
	// the while loop runs at most N times (once for each refuel stop), 
	// and each poll operation takes O(log N) time, the total cost of all the poll operations across all iterations of the loop is O(N log N).
	private static int minStops(int target, int startFuel, int[][]stations) {
		if (startFuel >= target)
				return 0;
		int n = stations[0].length;
		int maxDistance = startFuel ; // Max dist that can be traversed using the available fuel
		int stops = 0;
		
		// Sorting array as per destination is not needed, can be assumed as sorted already. But doing here to practice Java code
		
		Arrays.sort(stations, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] a, int[]b) {
				return Integer.compare(a[0], b[0]);
			}
			
		});
		
		Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a); // Use PQ to implement max heap
		
		for (int i = 0; i <= n; i++) {
			
				int dist = i == n ? target : stations[i][0];
				while (maxDistance < dist) { // If we cant reach the next destination, we need to refuel. This has to be pre calculated so refill from previously visited station with max fuel
					if (pq.isEmpty()) { // If there are no stations, we cant reach
						return -1;
					}
					maxDistance += pq.poll(); // Add petrol from max capacity pump
					stops++;
				}
				if (i < n){
					pq.add(stations[i][1]);
					
				}
			
		}
		return stops;
	}
	
	// Same complexity and logic as above, just a  slightly different way of impl
	
	private static int minStops2(int target, int startFuel, int[][]stations) {
		if (startFuel >= target)
				return 0;
		int n = stations[0].length;
		int maxDistance = startFuel ; // Max dist that can be traversed using the available fuel
		int stops = 0;
		int i = 0;
		// Sorting array as per destination is not needed, can be assumed as sorted already. But doing here to practice Java code
		
		Arrays.sort(stations, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] a, int[]b) {
				return Integer.compare(a[0], b[0]);
			}
			
		});
		
		Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a); // Use PQ to implement max heap
		
		while(maxDistance < target) {
			while (i < n && maxDistance <= stations[i][0]) {
				pq.add(stations[i++][1]);
			}
			if (pq.isEmpty())
				return -1;
			maxDistance += pq.poll();
			stops++;
		}
		
		return stops;
	}
}
