package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class T542ZeroOneMatrix {
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return matrix;

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0)
					queue.offer(new int[] { i, j });
				else
					matrix[i][j] = -1;
			}
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				for (int[] dir : dirs) {
					int dx = cur[0] + dir[0];
					int dy = cur[1] + dir[1];
					if (dx < 0 || dx >= m || dy < 0 || dy >= n)
						continue;

					if (matrix[dx][dy] == -1) {
						matrix[dx][dy] = level;
						queue.offer(new int[] { dx, dy });
					}
				}
			}
			level++;
		}

		return matrix;
	}
}
