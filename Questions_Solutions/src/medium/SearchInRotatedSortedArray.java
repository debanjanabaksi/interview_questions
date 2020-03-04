package medium;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key = 3;
		int index = findNumber(arr, key);
		if(index!=-1) {
			System.out.println(key+" found at "+ index);
		} else {
			System.out.println(key+" not found  ");
		}

	}
	
	private static int findNumber(int[] a , int num) {
		int pivot = findPivot(a);
		if(pivot>0 && num>=a[0] && num<=a[pivot-1]) {
			return binarySearch(a, 0, pivot-1, num);
		} else {
			return binarySearch(a, pivot, a.length-1, num);
		}
	}
	
	private static int findPivot(int[] a) {
		if(a[0] < a[a.length-1]) {
			return 0;
		}
		int start = 0, end = a.length-1;
		int mid;
		while(start<=end) {
			mid = (start+end)/2;
			if(a[mid]>a[mid+1]) {
				return mid+1;
			}
			if(a[start]<= a[mid]) {
				start = mid+1;
			} else {
				end = mid -1;
			}
		}
		return 0;
	}
	
	private static int binarySearch(int[]a, int low, int high, int num) {
		while(low<=high) {
			int mid = (high+low)/2;
			if(a[mid] == num) {
				return mid;
			} else if(num<a[mid]) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return -1;
	}

}
