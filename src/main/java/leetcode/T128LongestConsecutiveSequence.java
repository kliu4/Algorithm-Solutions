package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int max = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int num:nums) {
			if(map.containsKey(num))
				continue;
			int l = map.getOrDefault(num, 0);
			int r = map.getOrDefault(num, 0);
			
			int length = l + r + 1;
			max = Math.max(length, max);
			map.put(num - l, length);
			map.put(num + r, length);
		}
		return max;
	}
}
