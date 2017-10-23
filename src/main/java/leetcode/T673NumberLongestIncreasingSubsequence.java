package leetcode;

public class T673NumberLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;

		int[] len = new int[nums.length];
		int[] count = new int[nums.length];

		int max = 1;
		count[0] = 1;
		len[0] = 1;

		int total = 1;

		for (int i = 1; i < nums.length; i++) {
			len[i] = 1;
			count[i] = 1;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					if (len[j] + 1 > len[i]) {
						len[i] = len[j] + 1;
						count[i] = count[j];
					} else if (len[j] + 1 == len[i])
						count[i] += count[j];

					if (len[j] + 1 == max)
						total += count[j];
					else if (len[j] + 1 > max) {
						total = count[j];
						max = len[i];
					}
				}

			}
		}

		if (max == 1)
			return nums.length;

		return total;
	}

	public static void main(String[] args) {
		System.out.println(new T673NumberLongestIncreasingSubsequence().findNumberOfLIS(new int[] { 1,2,3,1,2,3,1,2,3}));
	}
}
