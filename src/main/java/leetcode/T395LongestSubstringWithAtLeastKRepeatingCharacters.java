package leetcode;

public class T395LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		int max = 0;
		int[] chars = new int[26];
		for (char c : s.toCharArray())
			chars[c - 'a']++;

		String regex = "";
		for (int i = 0; i < 26; i++)
			if (chars[i] > 0 && chars[i] < k)
				regex += (char) (i + 'a');

		if (regex.length() == 0)
			return s.length();

		String[] strs = s.split("[" + regex + "]");
		for (String str : strs)
			max = Math.max(max, longestSubstring(str, k));

		return max;
	}
}
