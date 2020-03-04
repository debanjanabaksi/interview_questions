package hard;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

	public static void main(String[] args) {
		LongestIncreasingPathInMatrix lp = new LongestIncreasingPathInMatrix();
		int mat[][] = { { 1, 2, 9 }, 
                { 5, 3, 8 }, 
                { 4, 6, 7 } }; 
		System.out.println("Length of the longest path is " +lp.findLongestIncreasingPath(mat));
		int a[][] = {{9,9,4},
				  {6,6,8},
				  {2,1,1}};
		System.out.println("Length of the longest path is " +lp.findLongestIncreasingPath(a));
		int arr[][] = {{3,4,5},
				  {3,2,6},
				  {2,2,1}};
		System.out.println("Length of the longest path is " +lp.findLongestIncreasingPath(arr));
	}
	
	private int findLongestIncreasingPath(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] dp = new int[n][m];
		int ans = 0;
		//Arrays.fill(dp, -1);
		for(int i = 0; i<n;i++) {
			for (int j=0; j<m; j++) {
				dp[i][j]= -1;
			}
		}
		for(int i = 0; i<n;i++) {
			for (int j=0; j<m; j++) {
				
					ans = Math.max(ans, findLongestPerCell(i,j,dp, arr, Integer.MIN_VALUE));
				
			}
		}
		for(int i = 0; i<n;i++) {
			for (int j=0; j<m; j++) {
				System.out.print(dp[i][j]+" ");
				
			}
			System.out.println();
		}
		return ans;
	}
	
	private int findLongestPerCell(int i, int j, int[][]dp, int[][] arr, int prev) {
		int n = arr.length;
		int m = arr[0].length;
		if(i<0 || i >=n || j<0 || j>=m || arr[i][j]<=prev) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int num = arr[i][j];
		int a = findLongestPerCell(i+1,j,dp,arr,num);
		int b = findLongestPerCell(i-1,j,dp,arr,num);
		int c = findLongestPerCell(i,j+1,dp,arr,num);
		int d = findLongestPerCell(i,j-1,dp,arr,num);
		
		return Math.max(a, Math.max(b, Math.max(c,d))) +1;
		
	}
	
	
	public int longestIncreasingPath(int[][] matrix) {
	    int result = 0;
	    int m = matrix.length;
	    int n = matrix[0].length;
	 
	    int[][] mem = new int[m][n];
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            int t = helper(matrix, mem, i, j);
	            result = Math.max(result, t);
	        }
	    }
	 
	    return result;
	}
	 
	private int helper(int[][] matrix, int[][] mem, int i, int j) {
	    if (mem[i][j] > 0) {
	        return mem[i][j];
	    }
	 
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	 
	    for (int k = 0; k < 4; k++) {
	        int x = i + dx[k];
	        int y = j + dy[k];
	 
	        if (x >= 0 && y >= 0
	                && x < matrix.length
	                && y < matrix[0].length
	                && matrix[x][y] > matrix[i][j]) {
	            mem[i][j] = Math.max(mem[i][j], helper(matrix, mem, x, y));
	        }
	    }
	 
	    return ++mem[i][j];
	}
}
