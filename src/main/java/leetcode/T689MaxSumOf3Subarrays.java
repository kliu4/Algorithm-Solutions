package leetcode;

public class T689MaxSumOf3Subarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int sum = 0;
		int[] sumArray = new int[nums.length];
		int l = nums.length;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sumArray[i] = sum;
		}

		int[][] leftMax = new int[nums.length][2];
        leftMax[k - 1] = new int[]{sumArray[k - 1], 0};
        
		for (int i = k; i < nums.length - k * 2; i++) {
			int temp = sumArray[i] - sumArray[i - k];
			if (temp > leftMax[i - 1][0])
				leftMax[i] = new int[] { temp, i };
			else
				leftMax[i] = leftMax[i - 1];
		}

		int[][] rightMax = new int[nums.length][2];
		rightMax[l - k] = new int[] { sumArray[l - 1] - sumArray[l - k - 1], l - k};

		for (int i = l - k - 1; i >= 0 + k * 2; i--) {
			int temp = sumArray[i + k - 1] - sumArray[i - 1];
			if (temp > rightMax[i + 1][0])
				rightMax[i] = new int[] { temp, i };
			else
				rightMax[i] = rightMax[i + 1];
		}

		int max = Integer.MIN_VALUE;
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;

		for (int i = k; i < l - k; i++) {
			int tempSum = leftMax[i - 1][0] + (sumArray[i + k - 1] - sumArray[i - 1]) + rightMax[i + k][0];
			if (tempSum > max || (tempSum == max && i1 + i2 + i3 > leftMax[i - 1][1] + i + rightMax[i + k][1])) {
				i1 = leftMax[i - 1][1];
				i2 = i;
				i3 = rightMax[i + k][1];
				max = tempSum;
			}
		}

		return new int[] { i1, i2, i3 };
	}
	
	public static void main(String[] args) {
		System.out
				.println(new T689MaxSumOf3Subarrays().maxSumOfThreeSubarrays(new int[] { 1,9,16,14,13,18,18,9,1,17,6,3,8,2,20,16,10,17,19,3,8,14,11,19,8,19,18,1,14,7,17,8,16,15,9,5,11,11,9,18 }, 12));
	}
}
