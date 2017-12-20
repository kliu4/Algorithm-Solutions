package leetcode;

public class T097InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}

		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();

		if (len1 + len2 != len3) {
			return false;
		}

		if (len1 == 0 || len2 == 0) {
			return (s1 + s2).equals(s3);
		}

		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		char[] chars3 = s3.toCharArray();

		boolean[][] dp = new boolean[len1 + 1][len2 + 1];

		// quick check first and last
		if (chars3[0] != chars1[0] && chars3[0] != chars2[0]) {
			return false;
		}

		if (chars3[len3 - 1] != chars1[len1 - 1] && chars3[len3 - 1] != chars2[len2 - 1]) {
			return false;
		}

		dp[0][0] = true;

		for (int i = 1; i <= len1; i++) {
			dp[i][0] = dp[i - 1][0] && chars1[i - 1] == chars3[i - 1];
		}

		for (int i = 1; i <= len2; i++) {
			dp[0][i] = dp[0][i - 1] && chars2[i - 1] == chars3[i - 1];
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				int m = i + j - 1;
				if (chars1[i - 1] == chars3[m]) {
					dp[i][j] = dp[i - 1][j];
				} 
				if (chars2[j - 1] == chars3[m]) {
					dp[i][j] = dp[i][j] || dp[i][j - 1];
				}
			}
		}

		return dp[len1][len2];
	}

	public static void main(String[] args) {
		System.out.println(new T097InterleavingString().isInterleave("aabc", "abad", "aabadabc"));
	}
}
