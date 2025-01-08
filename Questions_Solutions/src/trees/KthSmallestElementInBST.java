package trees;



public class KthSmallestElementInBST {
	
    // Binary search tree
    //      20
    //    /   \
    //   8     22
    //  / \
    // 4   12
    //    /  \
    //   10   14

	public static void main(String[] args) {
		    Node root = new Node(20);
	        root.left = new Node(8);
	        root.right = new Node(22);
	        root.left.left = new Node(4);
	        root.left.right = new Node(12);
	        root.left.right.left = new Node(10);
	        root.left.right.right = new Node(14);
	        int k = 3;
	        
	        System.out.println(FindKthSmallest(root, k));

	}
	
	//Using Morris inorder traversal
	private static int FindKthSmallest(Node root, int k ) {
		Node curr = root;
		int cnt = 0;
		while (curr != null) {
			
			if (curr.left == null) {
				cnt++;
				System.out.println(curr.value + " cnt "+cnt);
				if (cnt == k) 
					return curr.value;
				curr = curr.right;
			} 
			else {
				Node pre = curr.left;
				while(pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre.right = null;
					cnt++;
					System.out.println(curr.value + " cnt "+cnt);
					if (cnt == k) {
						
						return curr.value;
					}
						
					curr = curr.right;
				}
			}
		}
		return -1;
	}
	private static class Node {
		public int value;
		public Node left, right;
		
		public Node(int val) {
			this.value = val;
			left = null;
			right = null;
		}
	}

}
