package leetcode;

public class T698Partition2KEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k == 1)
			return true;

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % k != 0)
			return false;

		return helper(nums, new boolean[nums.length], 0, 0, sum / k, k);

	}

	private boolean helper(int[] nums, boolean[] isUsed, int index, int sum, int equalSum, int k) {
		if (k == 1)
			return true;

		if (sum > equalSum)
			return false;

		if (equalSum == sum)
			return helper(nums, isUsed, 0, 0, equalSum, k - 1);

		for (int i = index; i < nums.length; i++) {
			if (!isUsed[i]) {
				sum += nums[i];
				isUsed[i] = true;
				if (helper(nums, isUsed, i + 1, sum, equalSum, k))
					return true;
				sum -= nums[i];
				isUsed[i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(
				new T698Partition2KEqualSumSubsets().canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
	}
}
