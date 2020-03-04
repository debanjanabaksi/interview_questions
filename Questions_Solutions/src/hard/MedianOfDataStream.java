package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfDataStream {

	public static void main(String[] args) {
		int[] arr = {2,3,4};
		getMedians(arr);
		System.out.println();
		int A[] = {5, 15, 1, 3,}; 
		getMedians(A);

	}
	
	public static void getMedians(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]+" ");
			addNum(arr[i], minHeap, maxHeap);
			rebalance(minHeap, maxHeap);
			System.out.println( getMedian(minHeap, maxHeap));
		}
		System.out.println("Min heap : ");
		printPQ(minHeap);
		System.out.println("\nMax heap : ");
		printPQ(maxHeap);
		
	}
	
	private static void addNum(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(maxHeap.size() == 0 || num < maxHeap.peek()) {
			System.out.print(" Before adding "+ maxHeap.peek()+" ");
			maxHeap.add(num);
			System.out.println("Adding to max heap "+maxHeap.peek());
		} else {
			System.out.print(" Before adding "+ minHeap.peek()+" ");
			
			minHeap.add(num);
			System.out.println("Adding to min heap "+ minHeap.peek()+" ");
		}
	}
	
	private static void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(Math.abs(minHeap.size() - maxHeap.size()) >=2) {
			System.out.println("Rebalancing needed");
			System.out.println(" min size "+ minHeap.size()+" min top "+ minHeap.peek()+" max size "+ maxHeap.size()+ " max top "+ maxHeap.peek());
			if(minHeap.size()>maxHeap.size()) {
				maxHeap.add(minHeap.poll());
				System.out.println("Adding to max heap "+maxHeap.peek());
			} else {
				minHeap.add(maxHeap.poll());
				System.out.println("Adding to min heap "+ minHeap.peek()+" ");
			}
		}
	}
	
	private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(minHeap.size() == maxHeap.size()) {
			System.out.println("balanced");
			return ((double)minHeap.peek()+maxHeap.peek())/2;
		} else {
			System.out.println("not balanced "+ " min size "+ minHeap.size()+" min top "+ minHeap.peek()+" max size "+ maxHeap.size()+ " max top "+ maxHeap.peek());
			return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
		}
			
	}
	
	private static void printPQ(PriorityQueue<Integer> heap) {
		for(Integer i : heap) {
			System.out.print(" "+i);
		}
	}
	
}
