package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T697DegreeArray {
	public int findShortestSubArray(int[] nums) {
		int degree = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> firstIndex = new HashMap<>();
		Map<Integer, Integer> lastIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!firstIndex.containsKey(num))
				firstIndex.put(num, i);
			lastIndex.put(num, i);
			map.put(num, map.getOrDefault(num, 0) + 1);
			int frequency = map.get(num);
			if (frequency > degree)
				degree = frequency;
		}

		Set<Integer> set = new HashSet<>();
		int min = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
			if (pair.getValue() == degree) {
				int length = lastIndex.get(pair.getKey()) - firstIndex.get(pair.getKey()) + 1;
				if (length < min)
					min = length;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		System.out.println(new T697DegreeArray().findShortestSubArray(new int[] { 1,2,2,1,2,1,1,1,1,2,2,2}));
	}
}
