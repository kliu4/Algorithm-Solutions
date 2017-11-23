package leetcode;

import java.util.Stack;

public class T071SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (String str : path.split("/")) {
			if (str.equals(""))
				continue;
			else if (str.equals("."))
				continue;
			else if (str.equals("..")) {
				if (stack.isEmpty())
					continue;
				else
					stack.pop();
			} else
				stack.push(str);
		}

		String res = "";
		while (!stack.isEmpty())
			res = "/" + stack.pop() + res;

		return res.equals("") ? "/" : res;
	}
}
