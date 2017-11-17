package leetcode;

public class T409LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] chars = new int[128];
		for (char c : s.toCharArray())
			chars[c]++;

		int sum = 0;
		for (int num : chars) {
			if (num <= 1)
				continue;
			if (num % 2 == 0)
				sum += num;
			else
				sum += (num - 1);
		}

		return sum == s.length() ? sum : sum + 1;
	}
}
