package leetcode;

import java.util.Stack;

public class T150EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if(token.equals("+"))
				stack.push(stack.pop() + stack.pop());
			else if(token.equals("*"))
				stack.push(stack.pop() * stack.pop());
			else if(token.equals("-")) 
				stack.push(-stack.pop() + stack.pop());
			else if(token.equals("/")) {
				int num1 = stack.pop();
				stack.push(stack.pop() / num1);
			}else
				stack.push(Integer.parseInt(token));
		}
		return stack.isEmpty() ? 0 : stack.pop();
	}
}
