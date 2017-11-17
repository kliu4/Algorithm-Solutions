package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class T218SkylineProblem {
	class Point implements Comparable<Point> {
		public int x;
		public int y;
		public boolean isStart;

		public Point(int x, int y, boolean isStart) {
			this.x = x;
			this.y = y;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(Point point) {
			if (this.x != point.x)
				return this.x - point.x;
			if (this.isStart && point.isStart)
				return point.y - this.y;
			if (!this.isStart && !point.isStart)
				return this.y - point.y;
			if (this.isStart && !point.isStart)
				return -1;
			if (!this.isStart && point.isStart)
				return 1;
			return 0;
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {
		Point[] points = new Point[2 * buildings.length];
		for (int i = 0; i < buildings.length; i++) {
			points[2 * i] = new Point(buildings[i][0], buildings[i][2], true);
			points[2 * i + 1] = new Point(buildings[i][1], buildings[i][2], false);
		}
		Arrays.sort(points);
		List<int[]> list = new ArrayList<>();
		TreeMap<Integer, Integer> treeMap = new TreeMap();
		treeMap.put(0, 0);
		for (Point point : points) {
			int max = treeMap.lastKey();
			if (point.isStart) {
				if (point.y > max)
					list.add(new int[] { point.x, point.y });
				treeMap.put(point.y, treeMap.getOrDefault(point.y, 0) + 1);
			} else {
				treeMap.put(point.y, treeMap.get(point.y) - 1);
				if (treeMap.get(point.y) == 0)
					treeMap.remove(point.y);
				int newMax = treeMap.lastKey();
				if (max > newMax)
					list.add(new int[] { point.x, newMax });
			}
		}
		return list;
	}
}
