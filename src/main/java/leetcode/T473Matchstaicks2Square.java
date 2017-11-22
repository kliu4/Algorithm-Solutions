package leetcode;

public class T473Matchstaicks2Square {
	public boolean makesquare(int[] nums) {
		if (nums.length < 4)
			return false;

		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 4 != 0)
			return false;

		int length = sum / 4;
		for (int num : nums)
			if (num > length)
				return false;

		int[] used = new int[nums.length];
		return makeSquare(nums, used, 0, 0, length, 0);
	}

	private boolean makeSquare(int[] nums, int[] used, int index, int sum, int length, int k) {
		if (k == 3)
			return true;

		if (sum > length)
			return false;

		if (sum == length)
			return makeSquare(nums, used, 0, 0, length, k + 1);

		for (int i = index + 1; i < used.length; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				sum += nums[i];
				if (makeSquare(nums, used, i, sum, length, k))
					return true;
				sum -= nums[i];
				used[i] = 0;
			}
		}
		return false;
	}
}
