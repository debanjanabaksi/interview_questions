package hard;

public class MedianOfSortedArraysOfUnequalSize {

	public static void main(String[] args) {
		int[] input1 = {1, 3, 8, 9, 15};
		int[] input2 = {7, 11, 18, 19, 21, 25};

		int[] input3 = {3, 5, 7, 9, 11, 16};
		int[] input4 = {23, 26, 31, 35};

		int[] input5 = {1,3};
		int[] input6 = {2};
		

		int[] input7 = {1,3};
		int[] input8 = {2,4};
		
		System.out.println(findMedian(input1, input2));
		System.out.println(findMedian(input3, input4));
		System.out.println(findMedian(input5, input6));
		System.out.println(findMedian(input7, input8));

	}
	
	private static  double findMedian(int[] ip1, int[] ip2) {
		if(ip1.length> ip2.length) {
			return findMedian(ip2, ip1);
		}
		int x = ip1.length;
		int y = ip2.length;
		
		int low = 0;
		int high = x;
		
		while(low <= high) {
			int partX = (low+high)/2;
			int partY = (x+y+1)/2 - partX;
			int maxLeftX = (partX ==0) ? Integer.MIN_VALUE: ip1[partX-1];
			int minRtX = (partX == x) ? Integer.MAX_VALUE: ip1[partX];
			
			int maxLeftY = (partY == 0) ? Integer.MIN_VALUE: ip2[partY-1];
			int minRtY = (partY == y) ? Integer.MAX_VALUE: ip2[partY];
			
			if(maxLeftX<=minRtY && maxLeftY <=minRtX ) {
				if((x+y)%2 == 0) {
					return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRtX, minRtY))/2.0;
				} else {
					return (double)(Math.max(maxLeftX, maxLeftY));
				}
			} else if (maxLeftX > minRtY) {
				high = partX-1;
			} else {
				low = partX +1;
			}
		}
		return Integer.MIN_VALUE;
	}

}
