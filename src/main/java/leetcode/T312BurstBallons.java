package leetcode;

public class T312BurstBallons {
    public int maxCoins(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[][] dp = new int[nums.length][nums.length];
        dp[0][0] = nums[0];
        for(int l = 1; l <= nums.length; l++){
            for(int i = 0; i <= nums.length - l; i++){
                int j = i + l - 1;
                int left = i - 1 < 0 ? 1 : nums[i - 1];
                int right = j + 1 >= nums.length ? 1 : nums[j + 1];
                for(int k = i; k < i + l; k++){
                    int value = left * nums[k] * right;
                    if(k > i)
                        value += dp[i][k - 1];
                    if(k < j)
                        value += dp[k+1][j];
                    dp[i][j] = Math.max(dp[i][j], value);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
