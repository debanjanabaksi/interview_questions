package easy;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode inputHead1 = new ListNode(1);
		inputHead1.next = new ListNode(5);

		inputHead1.next.next = new ListNode(7);
		inputHead1.next.next.next = new ListNode(9);
		inputHead1.next.next.next.next = new ListNode(12);
		inputHead1.next.next.next.next.next = new ListNode(23);
		inputHead1.next.next.next.next.next.next = new ListNode(40);

		ListNode inputHead2 = new ListNode(8);
		inputHead2.next = new ListNode(15);
		inputHead2.next.next = new ListNode(22);
		inputHead2.next.next.next = new ListNode(23);
		inputHead2.next.next.next.next = new ListNode(33);
		
		printList(mergeExtraSpace(inputHead1, inputHead2));
		System.out.println();
		printList(mergeListInPlace(inputHead1, inputHead2));


	}
	
	private static class ListNode {
		int val ;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	private static void printList(ListNode n) {
		
		while(n!=null) {
			System.out.print(n.val);
			if(n.next!=null) {
				System.out.print("->");
			}
			n = n.next;
		}
	}
	
	private static ListNode mergeExtraSpace(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		} else if(l2 == null) {
			return l1;
		}
		 ListNode newHead = null;
		 ListNode previousNode = null;
		 
		 while(l1!=null && l2!=null) {
			 ListNode currentNode;
			 if(l1.val<=l2.val) {
				 currentNode = new ListNode(l1.val);
				 l1= l1.next;
			 } else {
				 currentNode = new ListNode(l2.val);
				 l2= l2.next;
			 }
			if(newHead == null) {
				newHead = currentNode;
			} 
			if(previousNode!=null) {
				previousNode.next = currentNode;
			}
			previousNode = currentNode;
		 }
		 
		 if(l1!=null) {
			 ListNode currentNode = new ListNode(l1.val);
			 l1= l1.next;
			 previousNode.next = currentNode;
			 previousNode = currentNode;
		 }
		 
		if(l2!=null) {
			ListNode currentNode = new ListNode(l2.val);
			 l2= l2.next;
			 previousNode.next = currentNode;
			 previousNode = currentNode;
		}
		previousNode.next = null;
		return newHead;
	}
	
	private static ListNode mergeListInPlace(ListNode h1, ListNode h2) {
		if(h1==null) {
			return h2;
		} else if(h2==null) {
			return h1;
		}
		
		if(h1.val<=h2.val) {
			h1.next = mergeListInPlace(h1.next, h2);
			return h1;
		} else {
			h2.next = mergeListInPlace(h1, h2.next);
			return h2;
		}
	}
	
	// an iterative method also exists check GFG https://www.geeksforgeeks.org/merge-two-sorted-lists-place/

}
