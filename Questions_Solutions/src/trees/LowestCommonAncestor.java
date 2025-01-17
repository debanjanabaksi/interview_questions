package trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

	static boolean v1, v2;

	public static void main(String[] args) {
		// Binary Tree
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(4, 5) = " + findLcaBinaryTree(tree.root, 4, 5).value);
		System.out.println("LCA(4, 6) = " + findLcaBinaryTree(tree.root, 4, 6).value);
		System.out.println("LCA(3, 4) = " + findLcaBinaryTree(tree.root, 3, 4).value);
		System.out.println("LCA(2, 4) = " + findLcaBinaryTree(tree.root, 2, 4).value);

		System.out.println();

		System.out.println("LCA(4, 5) = " + findLcaBinaryTreeIterative(tree.root, 4, 5).value);
		System.out.println("LCA(4, 6) = " + findLcaBinaryTreeIterative(tree.root, 4, 6).value);
		System.out.println("LCA(3, 4) = " + findLcaBinaryTreeIterative(tree.root, 3, 4).value);
		System.out.println("LCA(2, 4) = " + findLcaBinaryTreeIterative(tree.root, 2, 4).value);

		System.out.println();

		BinaryTree tree2 = new BinaryTree();
		tree2.root = new Node(1);
		tree2.root.left = new Node(2);
		tree2.root.right = new Node(3);
		tree2.root.left.left = new Node(4);
		tree2.root.left.right = new Node(5);
		tree2.root.right.left = new Node(6);
		tree2.root.right.right = new Node(7);

		Node lca = findLcaBinaryTreeWarpper(tree2.root, 4, 5);

		if (lca != null)
			System.out.println("LCA(4, 5) = " + lca.value);
		else
			System.out.println("Keys are not present");

		lca = findLcaBinaryTreeWarpper(tree2.root, 4, 10);

		if (lca != null)
			System.out.println("LCA(4, 10) = " + lca.value);
		else
			System.out.println("Keys are not present");
		System.out.println();
		//BST 
		BinaryTree tree3 = new BinaryTree();
		tree3.root = new Node(20);
		tree3.root.left = new Node(8);
		tree3.root.right = new Node(22);
		tree3.root.left.left = new Node(4);
		tree3.root.left.right = new Node(12);
		tree3.root.left.right.left = new Node(10);
		tree3.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = findLcaBinarySearchTree(tree3.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.value);

		n1 = 14;
		n2 = 8;
		t = findLcaBinarySearchTree(tree3.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.value);

		n1 = 10;
		n2 = 22;
		t = findLcaBinarySearchTree(tree3.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.value);
		System.out.println();
		n1 = 10;
		n2 = 40;
		t = findLcaBinarySearchTreeWrapper(tree3.root, n1, n2);
		if (t == null) {
			System.out.println("LCA of " + n1 + " and " + n2 + " is not present. Key not present");
		} else {
			System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.value);
		}
		
		//Find distance between nodes
		System.out.println();
		Node root4 = new Node(1); 
        root4.left = new Node(2); 
        root4.right = new Node(3); 
        root4.left.left = new Node(4); 
        root4.left.right = new Node(5); 
        root4.right.left = new Node(6); 
        root4.right.right = new Node(7); 
        root4.right.left.right = new Node(8); 
        System.out.println("Dist(4, 5) = " 
                             + findDistance(root4, 4, 5)); 
                               
        System.out.println("Dist(4, 6) = " 
                             + findDistance(root4, 4, 6)); 
                               
        System.out.println("Dist(3, 4) = " 
                             + findDistance(root4, 3, 4)); 
                               
        System.out.println("Dist(2, 4) = " 
                             + findDistance(root4, 2, 4)); 
                               
        System.out.println("Dist(8, 5) = "
                             + findDistance(root4, 8, 5)); 
  

	}

	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}

	private static Node findLcaBinaryTreeWarpper(Node root, int x, int y) {
		v1 = v2 = false;
		Node lca = findLcaBinaryTree(root, x, y);
		if (v1 && v2) {
			return lca;
		}
		return null;
	}

	// BinaryTree recursive
	private static Node findLcaBinaryTree(Node root, int x, int y) {
		if (root == null) {
			return null;
		}
		if (root.value == x) {
			v1 = true;
			return root;
		}
		if (root.value == y) {
			v2 = true;
			return root;
		}
		Node left = findLcaBinaryTree(root.left, x, y);
		Node right = findLcaBinaryTree(root.right, x, y);

		if (left != null && right != null) {
			return root;
		}

		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

	// Binary Tree iterative
	private static Node findLcaBinaryTreeIterative(Node root, int x, int y) {
		List<Node> path1 = new ArrayList<>();
		List<Node> path2 = new ArrayList<>();
		if (!findPath(root, x, path1) || !findPath(root, y, path2)) {
			return null;
		}
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i) != path2.get(i)) {
				break;
			}
		}
		return path1.get(i - 1);

	}

	private static boolean findPath(Node root, int n, List<Node> path) {
		if (root == null) {
			return false;
		}
		path.add(root);
		if (root.value == n) {
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}
		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	// Ignoring assumption that values are already present in tree.Tree will be
	// traversed twice in this case
	private static Node findLcaBinarySearchTreeWrapper(Node root, int x, int y) {

		if (isNodePresentInBST(root, x) && isNodePresentInBST(root, y)) {
			return findLcaBinarySearchTree(root, x, y);
		}
		return null;
	}

	// BinarySearchTree recursive
	private static Node findLcaBinarySearchTree(Node root, int x, int y) {
		if (root == null) {
			return null;
		}

		if (root.value > x && root.value > y) {
			return findLcaBinarySearchTree(root.left, x, y);
		}
		if (root.value < x && root.value < y) {
			return findLcaBinarySearchTree(root.right, x, y);
		}
		return root;
	}

	private static boolean isNodePresentInBST(Node root, int val) {
		if (root == null) {
			return false;
		}
		if (root.value == val) {
			return true;
		}
		if (root.value > val) {
			return isNodePresentInBST(root.left, val);
		}
		if (root.value < val) {
			return isNodePresentInBST(root.right, val);
		}
		return false;
	}

	private static class BinaryTree {
		Node root;
	}
	
	//Find distance between two nodes
	private static int findDistance(Node root, int a, int b) {
		Node lca = findLcaBinaryTree(root, a, b);
		int d1 = findLevel(lca, a, 0);
		int d2 = findLevel(lca, b, 0);
		return d1+d2;
		
	}
	
	private static int findLevel(Node root, int n, int level) {
		if (root == null) {
			return -1;
		}
		if(root.value == n) {
			return level;
		}
		int left = findLevel(root.left, n, level+1);
		if(left!= -1) {
			return left;
		}
		return findLevel(root.right, n, level+1);
	}

}
