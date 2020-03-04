package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaxPointsInLine {

	public static void main(String[] args) {
		int[][] a1 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
		int[][] a2 = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		MaxPointsInLine mp = new MaxPointsInLine();
		System.out.println(" max pts in line in a1 " + mp.line(a1));
		System.out.println("\n");
		System.out.println(" max pts in line in a2 " + mp.line(a2));

	}

	public int line(int[][] points) {
		int n = points.length;
		int maximum = 0;
		int duplicate = 0;
		int vertical = 0;
		//Map<Double, Integer> slopeMap = new HashMap<>();
		Map<Double, Set<Point>> pointMap = new HashMap<>();
	
		if (n <= 2) {
			return n;
		}

		// taking 2 rows at a time
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				// we know pts defined as tuples, x is 0th index and y is 1th index
				if (points[i][0] == points[j][0]) {
					if (points[i][1] == points[j][1]) {
						System.out.println("duplicate (" + points[i][0] + "," + points[i][1] + ")" + " (" + points[j][0]
								+ "," + points[j][1] + ")");
						duplicate += 2;// when we find a duplicate, no. of dup pts should be 2 since they are dup of
										// each other
					} else {
						System.out.println("vertical (" + points[i][0] + "," + points[i][1] + ")" + " (" + points[j][0]
								+ "," + points[j][1] + ")");
						vertical++;
					}
				} else {
					double diffY = (points[i][1] - points[j][1]);
					double diffX = (points[i][0] - points[j][0]);
					double slope = 1.0 * (diffY / diffX);
					// System.out.println("diff of (" + points[i][1] + ","+points[j][1]+")"+"
					// "+diffY+ " ("+points[i][0]+ ","+points[j][1]+")"+" "+diffX);
					System.out.println("slope of  (" + points[i][0] + "," + points[i][1] + ")" + " (" + points[j][0]
							+ "," + points[j][1] + ")" + " " + slope);
					Point a = new Point(points[i][0], points[i][1]);
					Point b = new Point(points[j][0], points[j][1]);
//					if (slopeMap.get(slope) != null) {
//						slopeMap.put(slope, slopeMap.get(slope) + 1);
//					} else {
//						slopeMap.put(slope, 1);
//					}
					Set<Point> p = pointMap.get(slope);
					if (p == null) {
						p = new HashSet<Point>();
					}
					p.add(a);
					p.add(b);
					pointMap.put(slope, p);
				}
			}
		}

		for (Entry<Double, Set<Point>> entry : pointMap.entrySet()) {
			Set<Point> p= entry.getValue();
			int count = p.size();
			
			if ((count + duplicate) > maximum) {
				maximum = count + duplicate;
				System.out.println(" slope " + entry.getKey() + " value " + p);
				
			}
		}
		
//		for (int count: slopeMap.values()) {
//			
//			if ((count + duplicate) > maximum) {
//				maximum = count + duplicate;
//			}
//		}
//		for (Entry<Double, Set<Point>> entry : pointMap.entrySet()) {
//			System.out.println(" slope " + entry.getKey() + " value " + entry.getValue());
//
//		}

		return Math.max(vertical + duplicate, maximum);

	}

	private static class Point {
		Integer x;
		Integer y;

		Point(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object object) {
			if (object == null || object.getClass() != getClass()) {
				return false;
			}
			Point point = (Point) object;
			return (this.x == point.x) && this.y == (point.y);
		}

		@Override
		public int hashCode() {
			//return super.hashCode();
			int hash = 3;
			hash = 7 * hash + this.x.hashCode() + this.y.hashCode();
			return hash;

		}
		@Override
		public String toString() {
			return (" "+x+" "+y);
		}
	}

}
