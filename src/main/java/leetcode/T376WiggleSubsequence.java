package leetcode;

public class T376WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        int[] positives = new int[nums.length];
        int[] num4Positives = new int[nums.length];
        int[] negatives = new int[nums.length];
        int[] nums4Negatives = new int[nums.length];
        
        positives[0] = 1;
        negatives[0] = 1;
        num4Positives[0] = nums[0];
        nums4Negatives[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums4Negatives[i - 1]){
                positives[i] = negatives[i - 1] + 1;
                num4Positives[i] = nums[i];
            }else{
                positives[i] = positives[i - 1];
                num4Positives[i] = Math.max(nums[i], num4Positives[i - 1]) ;
            }
            
            if(nums[i] < num4Positives[i - 1]){
                negatives[i] = positives[i - 1] + 1;
                nums4Negatives[i] = nums[i];
            }else{
                negatives[i] = negatives[i - 1];
                nums4Negatives[i] = Math.min(nums[i], nums4Negatives[i - 1]);
            }
        }
        
        return Math.max(positives[nums.length - 1], negatives[nums.length - 1]);
    }
}
