package leetcode;

import java.util.Stack;

public class T394DecodeString {
	public String decodeString(String s) {
		return decodeString(s.toCharArray(), 0, s.length() - 1);
	}

	private String decodeString(char[] chars, int l, int r) {
		StringBuilder sb = new StringBuilder();
		int n = 0;
		boolean sub = false;
		for (int i = l; i <= r && !sub; i++) {
			if ('[' == chars[i]) {
				Stack<Character> stack = new Stack<Character>();
				stack.add('[');
				int j = i + 1;
				while (!stack.isEmpty()) {
					if (chars[j] == '[')
						stack.add('[');
					if (chars[j] == ']')
						stack.pop();
					j++;
				}
				String inner = decodeString(chars, i + 1, j - 2);

				for (int a = 0; a < n; a++)
					sb.append(inner);
				return sb.toString() + decodeString(chars, j, r);
			}
			if ('a' <= chars[i] && chars[i] <= 'z')
				sb.append(chars[i]);
			if ('0' <= chars[i] && chars[i] <= '9')
				n = n * 10 + chars[i] - '0';
		}
		return sb.toString();
	}
}
