package medium;
/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

	A region is captured by flipping all 'O's into 'X's in that surrounded region.
	Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
	Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
	Two cells are connected if they are adjacent cells connected horizontally or vertically.
	Variation of islands and flood fill problem
 */

public class SurroundedRegions {

	public static void main(String[] args) {
		
		char[][] mat = {{'X', 'O', 'X',  
            'O', 'X', 'X'}, 
           {'X', 'O', 'X',  
            'X', 'O', 'X'}, 
           {'X', 'X', 'X',  
            'O', 'X', 'X'}, 
           {'O', 'X', 'X', 
            'X', 'X', 'X'}, 
           {'X', 'X', 'X', 
            'O', 'X', 'O'}, 
           {'O', 'O', 'X', 
            'O', 'O', 'O'}};
		
		char[][] grid = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
		
		int m = mat.length;
		int n = mat[0].length;
		
		 System.out.println("Original matrix :");
		
		 for (int i = 0; i < m; i++) 
	        { 
	            for (int j = 0; j < n; j++) 
	                System.out.print(mat[i][j] + " ");  
	                  
	            System.out.println(""); 
	        }
		 SurroundedRegions sr = new SurroundedRegions();
		 sr.surroundedRegions(mat);
		 System.out.println("Modified matrix :");
		 for (int i = 0; i < m; i++) 
	        { 
	            for (int j = 0; j < n; j++) 
	                System.out.print(mat[i][j] + " ");  
	                  
	            System.out.println(""); 
	        } 
		 
		 System.out.println("Original matrix :");
		 
		 int m1 = grid.length;
			int n1 = grid[0].length;
			
		 for (int i = 0; i < m1; i++) 
	        { 
	            for (int j = 0; j < n1; j++) 
	                System.out.print(grid[i][j] + " ");  
	                  
	            System.out.println(""); 
	        }
		
		 sr.surroundedRegions(grid);
		 System.out.println("Modified matrix :");
		 for (int i = 0; i < m1; i++) 
	        { 
	            for (int j = 0; j < n1; j++) 
	                System.out.print(grid[i][j] + " ");  
	                  
	            System.out.println(""); 
	        } 



	}
	
	private void surroundedRegions(char[][] grid) {
		if(grid==null) {
			return;
		}
		int m = grid.length;
		int n = grid[0].length;
		
		for(int i =0; i<m;i++) {
			//left side
			if(grid[i][0]=='O') {
				
				merge(grid,i,0);
			}//right side
			if(grid[i][n-1]=='O') {
				
				merge(grid,i,n-1);
			}
		}
		
		for(int j=0; j<n; j++) {
			//top
			if(grid[0][j]=='O') {
				
				merge(grid,0,j);
			}
			//bottom
			if(grid[m-1][j]=='O') {
				merge(grid,m-1,j);
			}
		}
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]=='O') {
					grid[i][j]='X';
				} else if(grid[i][j]=='#') {
					grid[i][j]='O';
				}
			}
		}
	}
	
	private void merge(char[][] grid, int i, int j) {
		
		int m = grid.length;
		int n = grid[0].length;
		
		if(i<0||i>=m||j<0||j>=n||(grid[i][j]!='O')) {
			return;
		}
		grid[i][j]='#';
		
		merge(grid,i+1,j);
		merge(grid,i-1,j);
		merge(grid,i,j+1);
		merge(grid,i,j-1);
	}

}
