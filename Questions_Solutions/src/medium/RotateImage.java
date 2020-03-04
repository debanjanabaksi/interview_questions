package medium;
/*
 * You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise) in place.
	
	Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
	
 */
public class RotateImage {

	public static void main(String[] args) {
		
		int matrix[][] = {{1,2,3},
				  {4,5,6},
				  {7,8,9}};
		print(matrix);
		System.out.println();
		rotate(matrix);
		print(matrix);
	}
	
	private static void rotate(int[][] a) {
		int n = a.length;
		//transpose
		for(int i = 0; i<n; i++) {
			for(int j = i; j<n; j++) {
				int temp = a[i][j];;
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		//exchange cols
		for(int i = 0; i<n;i++) {
			for(int j = 0; j<n/2; j++) {
				int temp = a[i][j];
				a[i][j] = a[i][n-1-j];
				a[i][n-1-j] = temp;
			}
		}
		
	}
	
	private static void print(int[][] a) {
		int n = a.length;
	
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
