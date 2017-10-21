package leetcode;

public class T416PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 2 != 0)
			return false;

		int half = sum / 2;

		boolean[][] dp = new boolean[half + 1][nums.length + 1];

		for (int i = 0; i < nums.length + 1; i++)
			dp[0][i] = true;
		for (int i = 1; i < half + 1; i++)
			for (int j = 1; j < nums.length + 1; j++) {
				dp[i][j] = dp[i][j - 1];
				if (i - nums[j - 1] >= 0)
					dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
			}
		return dp[half][nums.length];
	}

	public static void main(String[] args) {
		new T416PartitionEqualSubsetSum().canPartition(new int[] { 1, 5, 11, 5 });
	}
}
