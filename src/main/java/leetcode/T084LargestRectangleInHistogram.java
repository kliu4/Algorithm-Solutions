package leetcode;

import java.util.Stack;

public class T084LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new T084LargestRectangleInHistogram().largestRectangleArea(new int[] {6, 2, 5, 4, 5, 1, 6}));
	}
}
