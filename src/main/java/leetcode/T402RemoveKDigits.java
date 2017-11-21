package leetcode;

import java.util.Stack;

public class T402RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if (k == num.length())
			return "0";
		char[] chars = num.toCharArray();
		int len = num.length() - k;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < chars.length; i++) {
			while (stack.size() + (chars.length - 1 - i) >= len && !stack.isEmpty() && stack.peek() > chars[i]) {
				stack.pop();
			}
			if (stack.size() < len)
				stack.push(chars[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			if (sb.length() == 0 && c == '0')
				continue;
			sb.append(c);
		}

		String res = sb.toString();
		return res.equals("") ? "0" : res;
	}
}
