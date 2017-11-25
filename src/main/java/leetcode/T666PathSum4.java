package leetcode;

public class T666PathSum4 {
	private int sum;

	public int pathSum(int[] nums) {
		sum = 0;
		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strNums[i] = "" + nums[i];
		pathSum(strNums, 0, 0);
		return sum;
	}

	private void pathSum(String[] nums, int subSum, int index) {
		if (index < 0 || index >= nums.length)
			return;

		String cur = nums[index];
		int v = cur.charAt(2) - '0';
		int p = cur.charAt(1) - '0';
		int d = cur.charAt(0) - '0';

		subSum += v;

		// find left and right children
		String leftPrefix = "" + (d + 1) + (p * 2 - 1);
		String rightPrefix = "" + (d + 1) + (p * 2);

		int left = -1;
		int right = -1;
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i].startsWith(leftPrefix))
				left = i;
			else if (nums[i].startsWith(rightPrefix))
				right = i;
		}

		if (left == -1 && right == -1)
			sum += subSum;
		if (left != -1)
			pathSum(nums, subSum, left);
		if (right != -1)
			pathSum(nums, subSum, right);
	}
}
