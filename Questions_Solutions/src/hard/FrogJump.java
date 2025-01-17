package hard;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 *  A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. 
 *  The frog can jump on a stone, but it must not jump into the water.

	Given a list of stones' positions (in units) in sorted ascending order, 
	determine if the frog is able to cross the river by landing on the last stone. 
	Initially, the frog is on the first stone and assume the first jump must be 1 unit.

	If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
 	Note that the frog can only jump in the forward direction.
 * 
 *
 */
public class FrogJump {

	public static void main(String[] args) {
		int stones[] = {0,1,3,5,6,8,12,17};
		int stones2[] = {0,1,2,3,4,8,9,11};
		System.out.println(canJump(stones));
		System.out.println(canJump(stones2));

	}
	
	private static boolean canJump(int[] arr) {
		if(arr[1]>arr[0]+1) {
			return false;
		}
		int last = arr[arr.length -1];
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i<arr.length-1; i++) {
			set.add(arr[i]);
		}
		Stack<Integer> position = new Stack<>();
		Stack<Integer> jumps = new Stack<>();
		position.add(0);
		jumps.add(0); // how much did frog jump to reach this position
		while(!position.isEmpty()) {
			int pos = position.pop();
			int jumpDist = jumps.pop();
			for(int i = jumpDist-1; i<=jumpDist+1; i++) {
				if(i<=0) {
					continue;
				}
				int curr = pos+i;
				if(curr == last) {
					return true;
				} else if(set.contains(curr)) {
					position.add(curr);
					jumps.add(i);
				}
				
			}
		}
		return false;
	}

}
