package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Find min throws needed to win snakes and ladder
 */

public class SnakesAndLadder {

	public static void main(String[] args) {

		SnakesAndLadder sl = new SnakesAndLadder();
		// snakes and ladders are represented using a map.
		Map<Integer, Integer> ladder = new HashMap();
		Map<Integer, Integer> snake = new HashMap();

		// insert ladders into the map
		ladder.put(1, 38);
		ladder.put(4, 14);
		ladder.put(9, 31);
		ladder.put(21, 42);
		ladder.put(28, 84);
		ladder.put(51, 67);
		ladder.put(72, 91);
		ladder.put(80, 99);

		// insert snakes into the map
		snake.put(17, 7);
		snake.put(54, 34);
		snake.put(62, 19);
		snake.put(64, 60);
		snake.put(87, 36);
		snake.put(93, 73);
		snake.put(95, 75);
		snake.put(98, 79);

		sl.findSolution(ladder, snake);

	}

	// N is also the destination we have 1 to 100 digits in a game.

	private void BFS(Graph graph, int source, int N) {
		Queue<Node> q = new ArrayDeque<>();
		// N is also the destination we have 1 to 100 digits in a game.
		// But array of 100 will go from 0 to 99, we need entry for 100 so, array size
		// should be till 100+1.
		// 0 will remain unused.
		boolean[] visited = new boolean[N + 1];
		visited[source] = true;
		Node n = new Node(source, 0);
		q.add(n);

		while (!q.isEmpty()) {
			Node node = q.poll();
			System.out.println("Dist is  "+node.minDist +" Position is "+node.vertex);
			if (node.vertex == N) {
				System.out.println("min number of throws is " + node.minDist);
				break;
			}
			List<Edge> edges = graph.adjacencyList.get(node.vertex);
			for (Edge e : edges) {
				Integer v = e.getDestination();
				if (!visited[v]) {
					visited[v] = true;
					q.add(new Node(v, node.minDist + 1));
				}
			}
		}
	}

	private void findSolution(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
		List<Edge> edges = new ArrayList<>();
		int N = 10 * 10;
		// we start from 0, roll for dice will add 1 and then you reach 1 ( seems to be
		// the logic here).
		// In the end its 99+1 to reach 100 or x+y= 100;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= 6 && (i + j <= N); j++) {
				int source = i;
				int dest;

				int _ladders = ladders.get(i + j) != null ? ladders.get(i + j) : 0;
				int _snakes = snakes.get(i + j) != null ? snakes.get(i + j) : 0;

				if (_ladders != 0 || _snakes != 0) {
					dest = _ladders + _snakes;
				} else {
					dest = i + j;
				}
				Edge e = new Edge(source, dest);
				edges.add(e);

			}
		}

		Graph graph = new Graph(edges);
		BFS(graph, 0, 100);
	}

}
