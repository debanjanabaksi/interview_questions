package medium;

/**
 * Given a 2-d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically.
 * 
 * 
 *
 */
public class NumberOfIslands {
	int times = 0;

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		int mat[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		NumberOfIslands noi = new NumberOfIslands();
		int count1 = noi.countIslands(grid);
		System.out.println("Number of islands is :" + count1);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Number of islands is :" + noi.countIslands(mat));

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		int screen[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 }, };
		int x = 4, y = 4, newC = 3;
		
		System.out.println("\nUpdated screen before call to floodFill: \n");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
		
		
		noi.floodFillUtil(screen, x, y, newC);

		System.out.println("\nUpdated screen after call to floodFill: \n");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 4 neighbours considered not diagonals
	private int countIslands(int[][] grid) {
		if (grid == null) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int count = 0;

		if (m == 0 || n == 0) {
			return 0;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					count++;
					merge(grid, i, j);
				}
			}
		}
		return count;
	}

	private void merge(int[][] grid, int i, int j) {
		// System.out.println(times++);
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
			return;
		}
		grid[i][j] = '#'; // character to prevent it from being counted further

		merge(grid, i - 1, j);
		merge(grid, i + 1, j);
		merge(grid, i, j - 1);
		merge(grid, i, j + 1);
		// for diagonal elements recurse for i-1,j-1 and i+1,j+1 too

	}

	// variation flood fill.
	// In MS-Paint, when we take the brush to a pixel and click, the color of the
	// region of that pixel is replaced with a new selected color.
	// Following is the problem statement to do this task.
	// Given a 2D screen, location of a pixel in the screen and a color, replace
	// color of the given pixel
	// and all adjacent same colored pixels with the given color.

	private void floodFill(int[][] grid, int i, int j, int sourceColour, int targetColour) {
		if (grid == null) {
			return;
		}
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != sourceColour) {
			return;
		}
		grid[i][j] = targetColour;
		floodFill(grid, i + 1, j, sourceColour, targetColour);
		floodFill(grid, i, j + 1, sourceColour, targetColour);
		floodFill(grid, i - 1, j, sourceColour, targetColour);
		floodFill(grid, i, j - 1, sourceColour, targetColour);
	}
	
	private void floodFillUtil(int[][] grid, int i, int j, int targetColour) {
		int sourceColour = grid[i][j];
		floodFill(grid,i,j,sourceColour,targetColour);
	}
}
