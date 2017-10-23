package leetcode;

public class T213HouseRobber2 {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		return Math.max(robFirst(nums), noRobFirst(nums));
	}

	public int robFirst(int[] nums) {
		int[] rob = new int[nums.length];
		int[] noRob = new int[nums.length];

		rob[0] = nums[0];
		rob[1] = 0;
		noRob[1] = rob[0];

		for (int i = 2; i < nums.length; i++) {
			rob[i] = noRob[i - 1] + nums[i];
			noRob[i] = Math.max(rob[i - 1], noRob[i - 1]);
		}

		return noRob[nums.length - 1];
	}

	public int noRobFirst(int[] nums) {
		int[] rob = new int[nums.length];
		int[] noRob = new int[nums.length];

		rob[0] = 0;
		rob[1] = nums[1];
		noRob[1] = 0;

		for (int i = 2; i < nums.length; i++) {
			rob[i] = noRob[i - 1] + nums[i];
			noRob[i] = Math.max(rob[i - 1], noRob[i - 1]);
		}

		return Math.max(rob[nums.length - 1] - rob[0], noRob[nums.length - 1]);
	}
}
