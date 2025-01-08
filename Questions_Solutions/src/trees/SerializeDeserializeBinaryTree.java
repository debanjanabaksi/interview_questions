package trees;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeBinaryTree {
	private static final int MARKER = Integer.MIN_VALUE;
	static int index = -1;
	
	private static class Node {
		public int value;
		public Node left, right;
		
		public Node(int val) {
			this.value = val;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("In order traversal ");
        inorder(root);
        System.out.println();
        ArrayList<Integer> storage = new ArrayList<Integer>();
        serialize(root, storage);
        Node root2 = deserialize(storage);
        System.out.println("In order traversal after deserializing ");
        inorder(root2);
	}
	
	private static void serialize(Node root, ArrayList<Integer>storage) {
		
		if(root == null) {
			storage.add(MARKER);
			return;
		}
		storage.add(root.value);
		serialize(root.left, storage);
		serialize(root.right, storage);
	
	}
	
	private static Node deserialize(ArrayList<Integer>storage) {
		index++;
		if (index == storage.size())
			return null;
		if (storage.get(index) == MARKER) {
			return null;
		}
		Node root = new Node(storage.get(index));
		root.left = deserialize(storage);
		root.right = deserialize(storage);
		return root;
	}
	
	private static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
}
