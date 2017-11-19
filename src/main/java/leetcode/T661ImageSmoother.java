package leetcode;

public class T661ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
		if (M.length == 0 || M[0].length == 0)
			return M;

		int m = M.length;
		int n = M[0].length;

		int[][] res = new int[m][n];

		int[][] d = new int[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, 0 }, { 0, -1 }, { -1, 1 }, { -1, 0 },
				{ -1, -1 } };

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				double sum = 0.0;
				int size = 0;
				for (int a = 0; a < 9; a++) {
					int newI = i + d[a][0];
					int newJ = j + d[a][1];
					if (newI < 0 || newI >= m || newJ < 0 || newJ >= n)
						continue;
					sum += M[newI][newJ];
					size++;
				}
				res[i][j] = (int) (Math.floor(sum / size));
			}

		return res;
	}
}
