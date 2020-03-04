package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Diagonal {

	public static void main(String[] args) {
		/* Construct below tree
        1
      /   \
     /     \
    2       3
   /      /  \
  /      /    \
 4      5      6
       / \
      /   \
     7     8
*/

Node root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.right.left  = new Node(5);
root.right.right = new Node(6);
root.right.left.left = new Node(7);
root.right.left.right = new Node(8);

diagonalSum(root);
printDiagonal(root);

	}
	
	private static void diagonalSum(Node root, int diagonal, Map<Integer, Integer> diagMap ) {
		if(root == null) {
			return ;
		}
		diagMap.putIfAbsent(diagonal, 0);
		diagMap.put(diagonal, diagMap.get(diagonal)+root.value);
		diagonalSum(root.left, diagonal+1, diagMap);
		diagonalSum(root.right, diagonal, diagMap);
		
		
	}
	
	private static void diagonalSum(Node root ) {
		Map<Integer,Integer> diagMap = new HashMap<Integer,Integer>();
		diagonalSum(root,1,diagMap);
		for (Map.Entry<Integer, Integer> entry : diagMap.entrySet()) {
			System.out.println("sum of diagonal "+ entry.getKey()+ " is "+entry.getValue());
		}
	}
	
	private static class Node {
		public int value;
		public Node left, right;
		public Node(int value) {
			this.value = value;
		}
	}
	
	private static void printDiagonal(Node root, int diagonal, Map<Integer, List<Integer>> diagMap ) {
		if(root == null) {
			return ;
		}
		
		diagMap.putIfAbsent(diagonal, new ArrayList<>());
		diagMap.get(diagonal).add(root.value);
		printDiagonal(root.left, diagonal+1, diagMap);
		printDiagonal(root.right, diagonal, diagMap);
		
	}
	private static void printDiagonal(Node root ) {
		Map<Integer,List<Integer>> diagMap = new HashMap<Integer,List<Integer>>();
		printDiagonal(root,1,diagMap);
		for (Map.Entry<Integer, List<Integer>> entry : diagMap.entrySet()) {
			System.out.println("Elements of diagonal "+ entry.getKey()+ " are "+entry.getValue());
		}
	}
	

}
