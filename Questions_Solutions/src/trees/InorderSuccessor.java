package trees;

// Construct a BST
//            20
//          /    \
//         8      22
//       /   \
//      4    12
//          /  \
//         10   14

public class InorderSuccessor {

	public static void main(String[] args) {
	    Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int target = 14;
        Node succ = findSuccessor(root, target);
        if (succ != null)
            System.out.println(succ.key);
        else
            System.out.println("null");

	}
	
	static class Node {
		int key;
		Node left;
		Node right;
		
		Node(int value) {
			key = value;
			left = null;
			right = null;
		}
	} 
	
	static Node findLeftmost(Node root) {
		if (root == null)	
			return null;
		Node curr = root;
		while (curr != null) {
			curr = curr.left;
		}
		return curr;
	}
	//Time Complexity: O(h), where h is the height of the tree. 
	//Auxiliary Space: O(1)
	static Node findSuccessor(Node root, int target) {
		if ( root == null)
				return null;
		if (root.key == target && root.right!= null)
			return findLeftmost(root.right); //In order successor is in the right. It is the left most node of the right subtree
		
		Node succ = null;
		Node curr = root;
		while(curr != null) {
			if (target < curr.key) { // If node is greater, the target will be if left subtree and hence curr node will be inorder successor
				succ = curr;
				curr = curr.left;
			}
			else if (target > curr.key) { // If target is greater, successor will be in right child since node will be in right subtree
				curr = curr.right;
			}
			else { // If node is not found, successor will be last visited node with greater value. In inorder traversal, greater values appeare later
				// i.e. ascending order search, hence this logic
				break;
			}
		}
		return succ;
	}
}
