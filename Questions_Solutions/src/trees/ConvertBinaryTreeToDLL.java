package trees;

public class ConvertBinaryTreeToDLL {

	public static void main(String[] args) {
		/* Construct below tree
        1
      /   \
     /     \
    2       3
   / \     / \
  4   5   6   7
*/

Node root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.right.left = new Node(6);
root.right.right = new Node(7);

//Node head = convertWithPrev(root,root,new NodeWrapper(null));
Node head = convertSinglePass(root, null);
printDLL(head);
//convert(root);

	}

	// Other approaches with single pass or no reversal listed in notebook. choosing this here to practice since it involves reversing LL too.
	
	private static Node convert(Node root, Node head) {
		if(root == null) {
			return head;
		}
		head = convert(root.left, head);
		
		Node right = root.right;
		if(head!=null) {
		
			head.left = root;
		}
		root.right = head;
		head = root;
		
		return convert(right, head);
	}
	
	private static class NodeWrapper {
		Node node;
		NodeWrapper(Node n) {
			node = n;
		}
	}
	
	private static Node reverseDLL(Node head) {
		Node prev = null;
		Node curr = head;
		
		while(curr!=null) {
			Node temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			
			prev = curr;
			curr = curr.left;
		}
		System.out.println("\nHead is now "+prev.value);
		return prev;
	}
	
	private static void printDLL(Node head) {
		Node curr = head;
		if(curr == null) {
			return;
		}
		while (curr!=null) {
			System.out.print(" "+curr.value);
			curr = curr.right;
		}
	}
	
	private static void convert(Node root) {
		Node head = null;
		 head = convert(root, head);
		 printDLL(head);
		head = reverseDLL(head);
		printDLL(head);
	}
	
	private static Node convertWithPrev(Node current, Node head, NodeWrapper prev) {
		if(current==null) {
			return head;
		} 
		head = convertWithPrev(current.left, head, prev);
		if(prev.node!=null) {
			prev.node.right = current;
			current.left = prev.node;
		} else {
			head = current;
		}
		prev.node = current;
		head = convertWithPrev(current.right, head, prev);
		return head;
		
	}
	
	private static Node convertSinglePass(Node root, Node head) {
		if(root == null) {
			return head;
		}
		head = convertSinglePass(root.right, head);
		root.right = head;
		if(head!=null) {
			head.left = root;
		}
		head = root;
		return convertSinglePass(root.left, head);
	}
	
	private static class Node {
		public int value;
		public Node left, right;
		public Node(int value) {
			this.value = value;
		}
	}
}
