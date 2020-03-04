package medium;

public class SearchIn2DArray {
	
	public static void main(String[] args) {
		int[][] matrix = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
		int x = 33;
		System.out.println(x+" present in matrix : "+ searchInSortedMatrix(matrix, x));
		
		int matrix2[][] = { { 1, 3, 5, 7 }, 
                { 10, 11, 16, 20 }, 
                { 23, 30, 34, 50 } }; 
		int K = 3; 
		System.out.println(K+" present in matrix : "+ searchInRowOrderMatrix(matrix2, K));
	}
	
	//1. Search in a row wise and column wise sorted matrix
	
	private static boolean searchInSortedMatrix(int[][] arr, int x) {
		boolean result = false ;
		int m = arr.length;
		int n = arr[0].length;
		
		//start searching from lower leftmost corner
		int i = m-1;
		int j = 0;
		
		while(i > 0 && j < n) {
			if(x < arr[i][j]) {
				i--;
			} else if(x>arr[i][j]) {
				j++;
			} else {
				System.out.println ("Location is "+ i + " "+j);
				result = true;
				break;
			}
		}
		return result;
	}
	
	// 2. Search in a sorted 2D matrix (Stored in row major order)
	//    the matrix has the following properties:
	//    Integers in each row are sorted from left to right.
	//    The first integer of each row is greater than the last integer of the previous row.
	
	private static boolean searchInRowOrderMatrix(int[][] arr, int x) {
		int m = arr.length;
		int n = arr[0].length;
		
		int low = 0;
		int high = m;
		while ( low<=high) {
			int mid = low+(high -low)/2;
			if(arr[mid][0]<=x && x<=arr[mid][n-1]) {
				return binarySearch1D(arr[mid], x);
			}
			if(arr[low][0] > x) {
				high = mid-1;
			} else if(arr[low][0]<x) {
				low = mid+1;
			}
		}
		return false;
	}

	private static boolean binarySearch1D(int[]arr, int x) {
		int n = arr.length;
		int start = 0;
		int end = n-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if (arr[mid] == x) {
				return true;
			}else if(arr[mid] < x) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		return false;
	}
}
