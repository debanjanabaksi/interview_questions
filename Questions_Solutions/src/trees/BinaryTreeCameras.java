package trees;

/*
 * Given a Binary Tree consisting of N nodes, the task is to find the minimum number of cameras required to monitor the entire tree such that every camera placed at any node can monitor the node itself, 
 * its parent, and its immediate children.
 */
public class BinaryTreeCameras {

	
	/*
	 * If a camera is placed at root,it can cover itself and its 2 children so total 3 nodes
	 * If camera is placed at leaf it can cover itself and its parent so total 2 nodes
	 * If a camera is placed in a middle node it can cover itself, its parent and its 2 children. So total 4 nodes
	 * So strategy is to place it in such a node.
	 * Cameras will be placed on nodes which are parents of leaf nodes. Nodes which are covered will be removed. This will be repeated till
	 * all nodes are covered
	 *  
	 */
	static int res = 0;
	private static class Node {
		public int value;
		public Node left, right;
		
		public Node(int val) {
			this.value = val;
			left = null;
			right = null;
		}
	}
	
	public static void main (String[] args) {
		 	Node root = new Node(0);
	        root.left = new Node(0);
	        root.left.left = new Node(0);
	        root.left.left.left = new Node(0);
	        root.left.left.left.right = new Node(0);
	        
	        findMinCameras(root);
	        System.out.println("Number of cameras needed is "+ res);
	        System.out.println("Number of cameras needed is "+ minCameraCover(root));
	        
	}
	
	private static enum Type{
		COVERED,
		PARENT,
		LEAF
		
	}
	// Time O(n) space O(h)
	private static void findMinCameras(Node root) {
		Type cover = dfs(root);
		if (cover == Type.LEAF) {
			res++;
		}
		
	}
	
	private static Type dfs(Node node) {
//		 if (root == null)
//			 return Type.COVERED;
//		 Type left = dfs(root.left);
//		 Type right = dfs(root.right);
//		 
//		 if (left == Type.LEAF && right == Type.LEAF) {
//			 res++;
//			 return Type.PARENT;
//		 }
//		 if (left == Type.PARENT || right == Type.PARENT) {
//			 return Type.COVERED;
//		 }
//		 return Type.LEAF;
		 if(node == null) {
	            return Type.COVERED;
	        }
	        
	        Type left = dfs(node.left);
	        Type right = dfs(node.right);
	        
	        if(left == Type.LEAF || right == Type.LEAF) {
	            res++;
	            return Type.PARENT;
	        }
	        
	        return left == Type.PARENT || right == Type.PARENT ? Type.COVERED: Type.LEAF;
	}
	
	// Code from net directly
	 enum State { CAMERA, MONITORED, NOT_MONITORED }
	    
	    public static int minCameraCover(Node root) {
	        Status status = getStatus(root);
	        if (status.state == State.NOT_MONITORED) {
	            status.cameras++;
	        }
	        return status.cameras;
	    }
	    
	    private static Status getStatus(Node node) {
	        if (node == null) 
	            return new Status(0, State.MONITORED);
	        
	        Status left = getStatus(node.left);
	        Status right = getStatus(node.right);
	        
	        Status curr = new Status(left.cameras + right.cameras, State.NOT_MONITORED);
	        
	        if (left.state == State.NOT_MONITORED || right.state == State.NOT_MONITORED) {
	            curr.cameras++;
	            curr.state = State.CAMERA;
	        } else if (left.state == State.CAMERA || right.state == State.CAMERA) {
	            curr.state = State.MONITORED;
	        }
	        
	        return curr;
	    }
	    
	    private static class Status {
	        int cameras;
	        State state;
	        Status(int cameras, State state) {
	            this.cameras = cameras;
	            this.state = state;
	        }
	    }
	
}

/**
 *class Solution {
    enum State { CAMERA, MONITORED, NOT_MONITORED }
    
    public int minCameraCover(TreeNode root) {
        Status status = getStatus(root);
        if (status.state == State.NOT_MONITORED) {
            status.cameras++;
        }
        return status.cameras;
    }
    
    private Status getStatus(TreeNode node) {
        if (node == null) 
            return new Status(0, State.MONITORED);
        
        Status left = getStatus(node.left);
        Status right = getStatus(node.right);
        
        Status curr = new Status(left.cameras + right.cameras, State.NOT_MONITORED);
        
        if (left.state == State.NOT_MONITORED || right.state == State.NOT_MONITORED) {
            curr.cameras++;
            curr.state = State.CAMERA;
        } else if (left.state == State.CAMERA || right.state == State.CAMERA) {
            curr.state = State.MONITORED;
        }
        
        return curr;
    }
    
    private static class Status {
        int cameras;
        State state;
        Status(int cameras, State state) {
            this.cameras = cameras;
            this.state = state;
        }
    }
}
 *
 */
