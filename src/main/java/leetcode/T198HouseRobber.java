package leetcode;

public class T198HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;

		int[] rob = new int[nums.length];
		int[] noRob = new int[nums.length];

		rob[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			rob[i] = noRob[i - 1] + nums[i];
			noRob[i] = Math.max(rob[i - 1], noRob[i - 1]);
		}

		return Math.max(rob[nums.length - 1], noRob[nums.length - 1]);
	}
}
