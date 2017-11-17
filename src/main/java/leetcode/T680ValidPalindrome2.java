package leetcode;

public class T680ValidPalindrome2 {
	public boolean validPalindrome(String s) {
		char[] chars = s.toCharArray();
		for (int l = 0, r = s.length() - 1; l < r; l++, r--)
			if (chars[l] != chars[r])
				return isPalindrome(chars, l + 1, r) || isPalindrome(chars, l, r - 1);

		return true;
	}

	private boolean isPalindrome(char[] chars, int l, int r) {
		while (l < r) {
			if (chars[l] != chars[r])
				return false;
			l++;
			r--;
		}

		return true;
	}
}
