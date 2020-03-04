package medium;

/*
 *  In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

	At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

	What is the maximum total sum that the height of the buildings can be increased?	

	Example:
Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
Explanation: 
The grid is:
[ [3, 0, 8, 4], 
  [2, 4, 5, 7],
  [9, 2, 6, 3],
  [0, 3, 1, 0] ]

The skyline viewed from top or bottom is: [9, 4, 8, 7]
The skyline viewed from left or right is: [8, 7, 9, 3]

The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]
 */

public class MaxIncreaseToKeepCitySkyline {

	public static void main(String[] args) {
		int grid[][] = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
		int sum = maxIncrease(grid);
		System.out.print("Max increase sum is " + sum);

	}

	// This is a mathematical problem. The row and column maxes need to remain the
	// same. Its a square array
	// If we want to increase an element a[i][j], it should not be greater than the
	// max in its row or max in its column
	// Also, if we consider the max of the row and col, its height may become
	// greater than either row or col max, so we
	// need to consider min of the maxes
	// Though we need only sum of all increases, creating new grid too
	// Time complexity O(n^2) space complexity O(n) where n is the size used by row and col array
	private static int maxIncrease(int[][] a) {
		int n = a.length;
		int[] row = new int[n];
		int[] col = new int[n];
		int ans = 0;
		int grid[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}

			System.out.println();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				row[i] = Math.max(row[i], a[i][j]);
				col[j] = Math.max(col[j], a[i][j]);
			}
		}
		System.out.println("Row maxes");
		for (int i = 0; i < n; i++) {
			System.out.print(row[i] + " ");
		}
		System.out.println();
		System.out.println("Col maxes");

		for (int i = 0; i < n; i++) {
			System.out.print(col[i] + " ");
		}

		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = ans + Math.min(row[i], col[j]) - a[i][j];
				grid[i][j] = a[i][j] + (Math.min(row[i], col[j]) - a[i][j]);
			}
		}
		System.out.println("New grid");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}

			System.out.println();
		}

		return ans;
	}
}
