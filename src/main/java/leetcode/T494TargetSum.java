package leetcode;

public class T494TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, nums.length);
    }
    
    private int helper(int[] nums, int S, int length){
        if(length == 0 )
            return S == 0 ? 1 : 0;
        
        return helper(nums, S + nums[length - 1], length - 1) 
            + helper(nums, S - nums[length - 1], length - 1);
    }
}
