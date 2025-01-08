package medium;

/**
 * Given information about N petrol pumps (say arr[]) that are present in a circular path. 
 * The information consists of the distance of the next petrol pump from the current one (in arr[i][1]) and the amount of petrol stored in that petrol pump (in arr[i][0]). 
 * Consider a truck with infinite capacity that consumes 1 unit of petrol to travel 1 unit distance. 
 * The task is to find the index of the first starting point such that the truck can visit all the petrol pumps and come back to that starting point.

  Note: Return -1 if no such tour exists.
 */
public class CircularTourPetrolPump {

	public static void main(String[] args) {
		
		PetrolPump[] arr = {
				new PetrolPump(6, 4),  
                new PetrolPump(3, 6),  
                new PetrolPump(7, 3)
               };
		int result = printTour(arr);
		if (result == -1) {
			System.out.println("Can't traverse");
			
		}
		else {
			System.out.println("Start = "+ result);
		}

	}
	
	static class PetrolPump {
		int petrol; // petrol in current pump
		int distance; // distance to next pump
		
		public PetrolPump(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
			
		}
		
	}
	// Petrol available at current pump - distance to next pump = petrol needed ( capacity)
	// We start from 0 but we tarverse and keep checking if there is sufficient petrol to reach the next one from each pump. If at any time, its not sufficient
	// i.e. petrol < 0, we track the deficit. we change the current starting point since we couldnt reach all from there.
	// The capacity is reset as we need to fill.The deficit is the amount of petrol needed to be refilled to reach from start till there.  after we visit each pump, if capacity - deficit >=0, i.e.
	// we had sufficient petrol to reach next pump and traverse all around, we have solution. The starting point is such that we had ample fuel to overcome any possible deficits
	
	// Time O(n) Space O(1)
	static int printTour(PetrolPump arr[]) {
		int start = 0; 
		int capacity = 0, deficit = 0;
		
		int n = arr.length;
		
		for ( int i = 0; i < n; i++) {
			capacity += arr[i].petrol - arr[i].distance;//since 1 unit of petrol per 1 unit of distance is spent so distance signifies amount of petrol spent
			if (capacity < 0) { // even if its 0 we can reach and refuel. ie, it will become 0 on reaching
				start = i+1; // Start from next station
				deficit += capacity; // this will be -ve. The amount of fuel which we didnt have but needed to reach the ith pump. We need this much surplus ultimately
				capacity = 0; // reset capacity for counting from new start point
			}
		}
		if (capacity + deficit >= 0 ) {
			return start;
		}
		return -1;
		
	}
}
