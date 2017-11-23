package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T496NextGreaterElement1 {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		int[] res = new int[findNums.length];
		if (findNums.length == 0)
			return findNums;
		Stack<Integer> stack = new Stack<>();
		// map of the index of next greater element in nums
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			while (!stack.isEmpty() && num > stack.peek())
				map.put(stack.pop(), num);
			stack.push(num);
		}

		for (int i = 0; i < findNums.length; i++)
			res[i] = map.getOrDefault(findNums[i], -1);

		return res;
	}
}
