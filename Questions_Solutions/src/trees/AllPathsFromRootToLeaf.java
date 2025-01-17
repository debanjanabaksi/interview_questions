package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class AllPathsFromRootToLeaf {

	public static void main(String[] args) {
		
/* Construct below tree
        1
      /   \
     /     \
    2       3
   / \     / \
  4   5   6   7
         /     \
        8       9
*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.right.right = new Node(9);
		
		AllPathsFromRootToLeaf allPaths = new AllPathsFromRootToLeaf();

		// print all root to leaf paths
		allPaths.findPath(root);

}
	
	private void findPath(Node root) {
		Deque<Integer> path = new ArrayDeque<>();
		findAllPaths(root, path);
	}
	
	private void findAllPaths(Node root, Deque<Integer> path) {
		if (root == null) {
			return;
		}
		path.addLast(root.value);
		System.out.println("Current node :"+ root.value +" last in path : "+path.getLast());
		if(isLeaf(root)) {
			System.out.println(path);
		}
		findAllPaths(root.left, path);
		findAllPaths(root.right, path);
		System.out.println(" last in path after subtree: "+path.getLast());
		//remove the current node for which the function call was invoked i.e. Root of Root left right pre-order traversal
		path.removeLast();
	}

	private boolean isLeaf(Node node) {
		if(node == null) {
			return false;
		}
		return (node.left == null && node.right== null);		
	}
	
	private static class Node {
		public int value;
		public Node left, right;
		public Node(int value) {
			this.value = value;
		}
	}
}
