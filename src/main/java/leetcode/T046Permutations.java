package leetcode;

import java.util.ArrayList;
import java.util.List;


//bool Solve(configuration conf)
//{
//	 if (no more choices) // BASE CASE
//		 return (conf is goal state);
//	 
//	 for (all available choices) {
//		 try one choice c;
//		 // solve from here, if works out, you're done
//		 if (Solve(conf with choice c made)) 
//			 return true;
//		 unmake choice c;
//	 }
//	 return false; // tried all choices, no soln found
//}
public class T046Permutations {
	
	private List<List<Integer>> result;
	
	public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> list){
    		//Base Case
        if(list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        //for all available choices
        for(int i = 0; i < nums.length; i++){
        	
        		//try one choice C
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            
            //Continue to check if it solves the problem
            backtrack(nums, list);
            
            //unmake choice 
            list.remove(list.size() - 1);
        }
    }
}
