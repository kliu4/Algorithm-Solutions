package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		int max = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num))
				continue;
			int l = map.getOrDefault(num - 1, 0);
			int r = map.getOrDefault(num + 1, 0);

			int length = l + r + 1;
			map.put(num, length);
			
			System.out.println(num + ":" + length);
			max = Math.max(length, max);
			map.put(num - l, length);
			map.put(num + r, length);
		}
		return max;
	}

	public static void main(String[] args) {
		new T128LongestConsecutiveSequence().longestConsecutive(
				new int[] { 4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3 });
	}
}
