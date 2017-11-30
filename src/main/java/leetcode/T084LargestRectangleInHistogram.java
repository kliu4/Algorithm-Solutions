package leetcode;

import java.util.Stack;

public class T084LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			//System.out.println("" + i + "--" + h);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				//System.out.println("" + i + "==" + (s.isEmpty() ? 0 :s.peek()));
				maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		System.out.println(new T084LargestRectangleInHistogram().largestRectangleArea(new int[] {6, 2, 5, 4, 5, 1, 6}));
	}
}
