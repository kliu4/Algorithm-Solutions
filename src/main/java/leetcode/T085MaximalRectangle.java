package leetcode;

import java.util.Stack;

public class T085MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int[] heights = new int[n];

		int max = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					heights[j] = 0;
				} else {
					heights[j] += 1;
				}
			}
			max = Math.max(max, getMaxRectangleFromHistogram(heights));
		}

		return max;
	}

	private int getMaxRectangleFromHistogram(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= heights.length; i++) {
			int curH = i == heights.length ? -1 : heights[i];
			while (!stack.isEmpty() && curH < heights[stack.peek()]) {
				int h = heights[stack.pop()];
				int l = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * l, max);
			}
			stack.push(i);
		}
		return max;
	}
}
