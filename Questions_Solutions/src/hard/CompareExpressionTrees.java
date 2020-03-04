package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import graphs.Node;

/*Given 2 binary expression trees tree1 and tree2. The leaves of a binary expression tree are variable names and the other nodes contain operators. Find out if the expressions represented by these trees are equal or not.
There are only plus signs + and letters in the tree. Input is guaranteed to be valid.*/
public class CompareExpressionTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Node tree1 = new Node('+');
			tree1.left = new Node('a');
			tree1.right = new Node('b');
			
			Node tree2 = new Node('+');
			tree2.left = new Node('b');
			tree2.right = new Node('a');
			
			System.out.println("Trees are equal : "+evaluate(tree1, tree2) );
			
			
			Node root3 = new Node('+');
	        Node left = new Node('a');
	        Node right = new Node('+');
	        Node left3 = new Node('c');
	        Node right3 = new Node('d');

	        right.left = left3;
	        right.right = right3;

	        root3.left = left;
	        root3.right = right;

	        Node root4 = new Node('+');
	        Node left2 = new Node('-');
	        Node right2 = new Node('d');
	        Node left4 = new Node('a');
	        Node right4 = new Node('c');

	        left2.left = left4;
	        left2.right = right4;

	        root4.left = left2;
	        root4.right = right2;
	        
			System.out.println("Trees are equal : "+evaluate(root3, root4) );
	}
	
	 static class Node {
		public char value;
		public Node left, right;
		public Node(char value) {
			this.value = value;
		}
	}
	 
	private static boolean evaluate(Node r1,Node r2) {
		if(r1== null && r2 == null) {
			return true;
		}
		
		Queue<Node> q = new ArrayDeque<>();
		Map<Character, Integer> map = new HashMap<>();
		q.add(r1);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			map.put(temp.value, map.getOrDefault(temp.value, 0)+1);
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
		q.add(r2);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			map.put(temp.value, map.getOrDefault(temp.value, 0)-1);
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
		for(Integer val : map.values()) {
			if(val!=0) {
				return false;
			}
		}
		return true;
	}

}
