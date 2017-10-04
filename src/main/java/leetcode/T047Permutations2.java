package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class T047Permutations2 {

	private List<List<Integer>> result;

	public List<List<Integer>> permuteUnique(int[] nums) {
		result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(nums, new ArrayList<Integer>(), new ArrayList<Integer>());
		return result;
	}

	private void backtrack(int[] nums, List<Integer> list, List<Integer> indexes) {
		// Base Case
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		// for all available choices
		for (int i = 0; i < nums.length; i++) {

			// try one choice C
			if (indexes.contains(i))
				continue;
			
			if(i > 0 && nums[i] == nums[i - 1] && !indexes.contains(i - 1))
				continue;
			list.add(nums[i]);
			indexes.add(i);

			// Continue to check if it solves the problem
			backtrack(nums, list, indexes);
			
			list.remove(list.size() - 1);
			indexes.remove(indexes.size() - 1);
		}
	}
}
