package leetcode;

import java.util.List;
import java.util.Stack;

public class T636ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		if (n == 0)
			return result;

		Stack<Integer> stack = new Stack<>();

		int cur = 0;
		for (String str : logs) {
			String[] strs = str.split(":");
			int id = Integer.parseInt(strs[0]);
			int time = Integer.parseInt(strs[2]);
			if (strs[1].equals("start")) {
				if (!stack.isEmpty()) {
					result[stack.peek()] += time - cur;
				}
				stack.push(id);
			} else {
				time++;
				result[stack.pop()] += time - cur;
			}
			cur = time;
		}

		return result;
	}
}
