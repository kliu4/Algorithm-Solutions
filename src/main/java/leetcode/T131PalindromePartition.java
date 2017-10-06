package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T131PalindromePartition {
	List<List<String>> result = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		helper(s, 0, new ArrayList<String>());
		return result;
	}

	public void helper(String s, int start, List<String> list) {
		int length = 0;
		for(String str:list)
			length += str.length();
		
		if (length == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}

		for (int i = start; i <= s.length(); i++) {
			if (isPalindrome(s, start, i))
				list.add(s.substring(start, i + 1));
			helper(s, i + 1, list);
			if (!list.isEmpty())
				list.remove(list.size() - 1);
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		if (end >= s.length() || end - start < 0)
			return false;
		while (end >= start) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new T131PalindromePartition().partition("aab");
	}
}
