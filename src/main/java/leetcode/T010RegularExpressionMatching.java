package leetcode;

public class T010RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return s == p;

		int m = s.length();
		int n = p.length();

		boolean[][] dp = new boolean[m + 1][n + 1];
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();

		dp[0][0] = true;
		for (int j = 2; j < n + 1; j++) {
			if (cp[j - 1] == '*') {
				dp[0][j] = dp[0][j - 2];
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (cp[j - 1] == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (cp[j - 1] == '*') {
					if (j == 1) {
						return false;
					} else if (cp[j - 2] == '*') {
						return false;
					} else if (cp[j - 2] == '.') {
						dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];
					} else {
						dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || (dp[i - 1][j] && cs[i - 1] == cp[j - 2]);
					}
				} else {
					dp[i][j] = dp[i - 1][j - 1] && cs[i - 1] == cp[j - 1];
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		System.out.println(
				new T010RegularExpressionMatching().isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
	}
}
