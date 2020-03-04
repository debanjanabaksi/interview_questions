package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NodesAtADistanceFromLeaf {

	public static void main(String[] args) {
		/* Construct below tree
        15
      /    \
     /      \
    10       20
   / \      /  \
  8   12   16  25
          /
         18
*/

Node root = new Node(15);
root.left = new Node(10);
root.right = new Node(20);
root.left.left = new Node(8);
root.left.right = new Node(12);
root.right.left = new Node(16);
root.right.right = new Node(25);
root.right.left.left = new Node(18);

int dist = 1;
distanceNodes(root, dist);
	}
	
	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
	
	private static void leafNodeDistance(Node root, Set<Node> set, List<Node> path, int dist) {
		if(root == null) {
			return;
		}
		if (isLeaf(root) && path.size() >=dist) {
			set.add(path.get(path.size()-dist));
			return;
		}
		path.add(root);
		leafNodeDistance(root.left, set, path, dist);
		leafNodeDistance(root.right, set, path, dist);
		// remove current node from path after its left and right sub tree have been added to the path
		path.remove(root);
	}

	private static boolean isLeaf(Node root) {
		return (root.left==null && root.right == null);
	}
	
	private static void distanceNodes(Node root, int dist) {
		Set<Node> set = new HashSet<>();
		 List<Node> path = new ArrayList<>();
		 leafNodeDistance(root, set, path, dist);
		 
		 for (Node n : set) {
			 System.out.print(" "+n.value);
		 }
	}
}
