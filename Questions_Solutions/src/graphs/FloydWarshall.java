package graphs;

public class FloydWarshall {

	public static void main(String[] args) {

		int M = Integer.MAX_VALUE;
		
		// given adjacency representation of matrix
		int[][] adjMatrix = new int[][]
		{
			{ 0,  M, -2, M },
			{ 4,  0,  3, M },
			{ M,  M,  0, 2 },
			{ M, -1,  M, 0 }
		};
		
		FloydWarshall fw = new FloydWarshall();
		fw.floydWarshall(adjMatrix);
	}
	
	private void floydWarshall(int[][] adjMatrix) {
		int size = adjMatrix.length;
		System.out.println("Size is "+size);
		
		int[][] cost = new int[size][size];
		int[][] path = new int[size][size];
		
		for(int i = 0; i< size; i++) {
			for (int j = 0; j< size; j++) {
				cost[i][j] = adjMatrix[i][j];
				if(i==j) {
					path[i][j] = 0;
				} else if (cost[i][j]!= Integer.MAX_VALUE) {
					path[i][j] = i;
				} else {
					path[i][j] = -1;
				}
			}
		}
//		for(int i = 0; i< size; i++) {
//			for (int j = 0; j< size; j++) {
//				System.out.print("value "+path[i][j]);
//			}
//		}
		
//		for ( int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				for (int k = 0; k < size; k++) {
//					if (cost[i][k]!=Integer.MAX_VALUE && cost[j][i]!=Integer.MAX_VALUE) {
//						if (cost[i][k]+ cost[j][i] < cost[j][k]) {
//							cost[j][k] = cost[i][k]+ cost[j][i];
//							path[j][k] = path[i][k];
//						}
//					}
//				}
//				if(cost[j][j] < 0) {
//					System.out.println("Negative cycle found");
//				}
//			}
//		}
		for (int k = 0; k < size; k++)
		{
			for (int v = 0; v < size; v++)
			{
				for (int u = 0; u < size; u++)
				{
					// If vertex k is on the shortest path from v to u,
					// then update the value of cost[v][u], path[v][u]

					if (cost[v][k] != Integer.MAX_VALUE
							&& cost[k][u] != Integer.MAX_VALUE
							&& (cost[v][k] + cost[k][u] < cost[v][u]))
					{
						cost[v][u] = cost[v][k] + cost[k][u];
						path[v][u] = path[k][u];
					}
				}

				// if diagonal elements become negative, the
				// graph contains a negative weight cycle
				if (cost[v][v] < 0)
				{
					System.out.println("Negative Weight Cycle Found!!");
					return;
				}
			}
		}
		
		printSol(cost, path, size);
	}
	
	private void printSol(int[][] cost, int[][] path, int N ){
		System.out.println("N is "+N);
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i!=j && path[i][j]!=-1) {
					System.out.print("\nPath for "+i + " to "+j+ " is "+" "+i+" ");
					printPath(path, i, j);
					System.out.println(j);
				System.out.println("\nCost for path from "+i + " to "+j+ " is "+cost[i][j]);
					
				}
				System.out.println();
			}
		}
		
//		for (int v = 0; v < N; v++)
//		{
//			for (int u = 0; u < N; u++)
//			{
//				if (u != v && path[v][u] != -1)
//				{
//					System.out.print("Shortest Path from vertex " + v +
//							" to vertex " + u + " is (" + v + " ");
//					printPath(path, v, u);
//					System.out.println(u + ")");
//				}
//			}
//		}
	}
	private void printPath(int[][]path, int v, int u) {
		//when un-commenting, reverse v,u in method signature
		
//		if(path[u][v]== u) {
//			return;
//		}
//		printPath(path, u, path[u][v]);
//		System.out.print(" "+ path[u][v]);
		if (path[v][u] == v)
			return;

		printPath(path, v, path[v][u]);
		System.out.print(path[v][u] + " ");
	}
}
