package leetcode;

public class T447TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		if (nums.length < 2)
			return 0;

		int total = 0;
		for (int i = 0; i < 32; i++) {
			int oneCount = 0;
			for (int j = 0; j < nums.length; j++)
				oneCount += ((nums[j] >> i) & 1);
			total += oneCount * (nums.length - oneCount);
		}
		return total;
	}
}
