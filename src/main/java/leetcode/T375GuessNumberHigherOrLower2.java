package leetcode;

public class T375GuessNumberHigherOrLower2 {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int j = 2; j <= n; j++) {
			for (int i = j - 1; i >= 1; i--) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = j - 1; k >= i; k--) {
					int max = k + Math.max(dp[k + 1][j], dp[i][k - 1]);
					dp[i][j] = Math.min(max, dp[i][j]);
				}
			}
		}
		return dp[1][n];
	}
}
