package leetcode;

public class T329LongestIncreasingPathInMatrix {
	private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] paths = new int[m][n];

		int max = 1;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				int len = dfs(matrix, paths, i, j);
				max = Math.max(max, len);
			}

		return max;
	}

	private int dfs(int[][] matrix, int[][] paths, int i, int j) {
		if (paths[i][j] != 0)
			return paths[i][j];

		paths[i][j] = 1;
		for (int[] dir : dirs) {
			int newI = i + dir[0];
			int newJ = j + dir[1];
			if (newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length)
				continue;
			if (matrix[i][j] > matrix[newI][newJ])
				paths[i][j] = Math.max(1 + dfs(matrix, paths, newI, newJ), paths[i][j]);
		}
		return paths[i][j];
	}
}
