package leetcode;

public class T678ValidParenthesisString {
	public boolean checkValidString(String s) {
		int low = 0;
		int high = 0;
		for (char c : s.toCharArray()) {
			if (c == '(')
				low++;
			else
				low--;

			if (c == ')')
				high--;
			else
				high++;

			if (high < 0)
				return false;

			low = Math.max(low, 0);
		}
		return low == 0;
	}
}
