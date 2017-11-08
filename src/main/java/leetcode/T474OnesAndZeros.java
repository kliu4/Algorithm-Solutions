package leetcode;

public class T474OnesAndZeros {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		for (String str : strs) {
			int n1 = 0;
			for (char c : str.toCharArray())
				if (c == '1')
					n1++;

			int n0 = str.length() - n1;

			for (int i = m; i >= n0; i--)
				for (int j = n; j >= n1; j--)
					dp[i][j] = Math.max(dp[i][j], 1 + dp[i - n0][j - n1]);
		}

		return dp[m][n];
	}
}
