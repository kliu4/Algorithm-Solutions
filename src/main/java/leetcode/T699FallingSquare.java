package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T699FallingSquare {
	private class Interval {
		int left, right, height;

		public Interval(int left, int right, int height) {
			this.left = left;
			this.right = right;
			this.height = height;
		}
	}

	public List<Integer> fallingSquares(int[][] positions) {
		List<Integer> result = new ArrayList<Integer>();
		List<Interval> intervals = new ArrayList<Interval>();

		int h = 0;
		for (int[] position : positions) {
			Interval cur = new Interval(position[0], position[0] + position[1], position[1]);
			int tempMax = position[1];
			for (Interval interval : intervals) {
				if (intersect(interval, cur))
					tempMax = Math.max(tempMax, position[1] + interval.height);
			}
			cur.height = tempMax;
			h = Math.max(h, tempMax);
			intervals.add(cur);
			result.add(h);
		}
		return result;
	}

	private boolean intersect(Interval i1, Interval i2) {
		return (i1.left <= i2.left && i2.left < i1.right) || (i1.left < i2.right && i2.right <= i1.right)
				|| (i2.left <= i1.left && i2.right >= i1.right);
	}
}
