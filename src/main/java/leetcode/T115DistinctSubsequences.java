package leetcode;

public class T115DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return 0;
		}

		if (s.equals(t)) {
			return 1;
		}

		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j];
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}

		return dp[m][n];
	}
}
