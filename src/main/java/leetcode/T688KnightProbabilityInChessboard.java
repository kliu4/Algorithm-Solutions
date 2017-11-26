package leetcode;

public class T688KnightProbabilityInChessboard {
	int[][] dir = new int[][] { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 },
			{ -1, -2 } };

	public double knightProbability(int N, int K, int r, int c) {
		double[][] dp0 = new double[N][N];
		dp0[r][c] = 1;
		for (int i = 1; i <= K; i++) {
			double[][] dp1 = new double[N][N];
			for (int a = 0; a < N; a++)
				for (int b = 0; b < N; b++) {
					if (dp0[a][b] != 0)
						for (int m = 0; m < 8; m++) {
							int newA = a + dir[m][0];
							int newB = b + dir[m][1];
							if (newA < 0 || newA >= N || newB < 0 || newB >= N)
								continue;
							dp1[newA][newB] += dp0[a][b];
						}
				}

			for (int a = 0; a < N; a++)
				for (int b = 0; b < N; b++)
					dp0[a][b] = dp1[a][b];
		}

		double total = 0;
		for (int a = 0; a < N; a++)
			for (int b = 0; b < N; b++)
				total += dp0[a][b];

		return total / Math.pow(8, K);
	}

	public static void main(String[] args) {
		System.out.println(new T688KnightProbabilityInChessboard().knightProbability(3, 2, 0, 0));
	}
}
