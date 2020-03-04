package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode arr[] = new ListNode[3];

		arr[0] = new ListNode(1);
		arr[0].next = new ListNode(3);
		arr[0].next.next = new ListNode(5);
		arr[0].next.next.next = new ListNode(7);

		arr[1] = new ListNode(2);
		arr[1].next = new ListNode(4);
		arr[1].next.next = new ListNode(6);
		arr[1].next.next.next = new ListNode(8);

		arr[2] = new ListNode(0);
		arr[2].next = new ListNode(9);
		arr[2].next.next = new ListNode(10);
		arr[2].next.next.next = new ListNode(11);

		//printList(mergeLists(arr));
		System.out.println();
		//printList(mergeListsHeapShorter(arr));
		System.out.println();
		printList(mergeListsNoHeap(arr));

	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	private static void printList(ListNode n) {

		while (n != null) {
			System.out.print(n.val);
			if (n.next != null) {
				System.out.print("->");
			}
			n = n.next;
		}
	}

	// O(nklog(nk)) time O(nk) space sol using heap where k is num of list & n is
	// max count of element is list
	private static ListNode mergeLists(ListNode[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (ListNode l : arr) {
			while (l != null) {
				pq.add(l.val);
				l = l.next;
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;

		while (!pq.isEmpty()) {
			head.next = new ListNode(pq.remove());
			head = head.next;
		}
		return dummy.next;
	}

	// O(nlogk) time O(k) space sol using heap where k is num of list & n is max
	// count of element is list
	private static ListNode mergeListsHeapShorter(ListNode[] arr) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=null) {
				pq.add(arr[i]);
			}
		}
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while(!pq.isEmpty()) {
			ListNode node = pq.remove();
			head.next = node;
			if(node.next!=null) {
				pq.add(node.next);
			}
			head = head.next;
		}
		return dummy.next;
	}

	// O(nk Log k) time and O(1) space
	
	private static ListNode mergeListsNoHeap(ListNode[] arr) {
		int n = arr.length-1;
		
		while (n!=0) {
			int i = 0; int j = n;
			
			while(i<j) {
				System.out.println("starting");
				arr[i] = mergeTwoLists(arr[i], arr[j]);
				i++;
				j--;
				if(i>=j) {
					System.out.println("Crossed "+j+ " i is "+ i );
					n = j;
				}
			}
			
			
		}
		return arr[0];
		  
	}
	
	private static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
		if( h1 == null) {
			return h2;
		} else if(h2 == null) {
			return h1;
		}
		
		if(h1.val <= h2.val) {
			h1.next = mergeTwoLists(h1.next, h2);
			return h1;
		} else {
			h2.next = mergeTwoLists(h1, h2.next);
			return h2;
		}
	}
}
