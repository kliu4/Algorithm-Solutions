package leetcode;

import util.TreeNode;

public class T124BinaryTreeMaxPathSum {
	public int max;
	
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		helper(root);
		return max;
	}
	
	private int helper(TreeNode root) {
		if(root == null) 
			return 0;
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		max = Math.max(max, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}
