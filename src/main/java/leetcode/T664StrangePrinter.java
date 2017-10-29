package leetcode;

public class T664StrangePrinter {
	private int[][] dp;

	public int strangePrinter(String s) {
		if (s.length() <= 1)
			return s.length();

		dp = new int[s.length()][s.length()];
		char[] chars = s.toCharArray();

		return helper(chars, 0, s.length() - 1, dp);
	}

	private int helper(char[] chars, int i, int j, int[][] dp) {
		if (i == j)
			return 1;

		if (i > j)
			return 0;

		if (dp[i][j] > 0)
			return dp[i][j];

		int t = helper(chars, i, j - 1, dp) + 1;

		for (int m = i; m < j; m++)
			if (chars[m] == chars[j])
				t = Math.min(t, helper(chars, i, m, dp) + helper(chars, m + 1, j - 1, dp));

		dp[i][j] = t;
		return t;
	}
}
