package leetcode;

//memorized dfs 
public class T486PredictTheWinner {
	public boolean PredictTheWinner(int[] nums) {
		int[] sums = new int[nums.length];
		int[][] mem = new int[nums.length][nums.length];
		int prev = 0;
		for (int i = 0; i < nums.length; i++) {
			prev += nums[i];
			sums[i] = prev;
		}

		int max = getMax(nums, 0, nums.length - 1, sums, mem);
		return max >= sums[nums.length - 1] - max;
	}

	private int getMax(int[] nums, int l, int r, int[] sums, int[][] mem) {
		if (l == r)
			return nums[l];

		if (mem[l][r] != 0)
			return mem[l][r];

		int max = Math.max(nums[l] + (sums[r] - sums[l]) - getMax(nums, l + 1, r, sums, mem),
				nums[r] + (sums[r - 1] - (sums[l] - nums[l])) - getMax(nums, l, r - 1, sums, mem));

		mem[l][r] = max;

		return max;
	}
}
