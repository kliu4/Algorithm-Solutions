package leetcode;

public class T718MaxLengthOfRepeatedSubArray {
	public int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		int max = 0;
		for(int i = 1; i < A.length + 1; i++)
			for(int j = 1; j < B.length + 1; j++) {
				if(A[i - 1] == B[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}else
					dp[i][j] = 0;
			}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new T718MaxLengthOfRepeatedSubArray().findLength(new int[] { 1, 2, 3, 2, 1 },
				new int[] { 3, 2, 1, 4, 7 }));
	}
}
