package trees;

import java.util.LinkedList;
import java.util.Queue;


public class SinkZeroNodesToBottomOfTree {

	public static void main(String[] args) {
		/* Construct below tree
		  0
		/   \
	   /	 \
	  1	   0
			/   \
		   /	 \
		  0	   2
		/   \
	   /	 \
	  3	   4
*/

Node root = new Node(0);
root.left = new Node(1);
root.right = new Node(0);
root.right.left = new Node(0);
root.right.right = new Node(2);
root.right.left.left = new Node(3);
root.right.left.right  = new Node(4);

System.out.println("Level order traversal :");
levelOrderTraversal(root);
System.out.println("\nIn order traversal :");
inorder(root);
sinkNodes(root);
System.out.println("\nLevel order traversal :");
levelOrderTraversal(root);
System.out.println("\nInorder traversal :");
inorder(root);

	}
	
	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
	
	private static void sinkNodes(Node root) {
		if(root == null) {
			return;
		}
		
		sinkNodes(root.left);
		sinkNodes(root.right);
		if(root.value == 0) {
			sink(root);
		}
	}
	
	private static void sink(Node root) {
		if(root ==  null) {
			return;
		}
		if(root.left!=null && root.left.value!=0) {
			int temp = root.left.value;
			root.left.value = root.value;
			root.value = temp;
			sink(root.left);
		} else if(root.right!=null && root.right.value!=0) {
			int temp = root.right.value;
			root.right.value = root.value;
			root.value = temp;
			sink(root.right);
		}
	}
	
	private static void levelOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node current = q.poll();
			System.out.print(" "+current.value);
			if(current.left!=null) {
				q.add(current.left);
			}
			if(current.right!=null) {
				q.add(current.right);
			}
		}
	}

	private static void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
}
