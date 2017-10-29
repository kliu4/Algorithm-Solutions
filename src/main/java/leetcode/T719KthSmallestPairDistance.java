package leetcode;

public class T719KthSmallestPairDistance {
	public int smallestDistancePair(int[] nums, int k) {
		int[] abss = new int[1000000];
		for (int i = 0; i < nums.length - 1; i++)
			for (int j = i + 1; j < nums.length; j++) {
				int abs = Math.abs(nums[i] - nums[j]);
				abss[abs] = abss[abs] + 1;
			}
		int count = 0;
		for (int i = 0; i < 1000000; i++) {
			if (abss[i] != 0) {
				count += abss[i];
				if (count >= k)
					return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new T719KthSmallestPairDistance().smallestDistancePair(new int[] {1, 1000000, 2, 1}, 3)
				);
	}
}
