package leetcode;

import util.TreeNode;

public class T654MaxBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return helper(nums, 0, nums.length);
	}

	public TreeNode helper(int[] nums, int start, int end) {
		if (start >= end)
			return null;
		int max = nums[start];
		int maxIndex = start;

		for (int i = start + 1; i < end; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		TreeNode left = helper(nums, start, maxIndex);
		TreeNode right = helper(nums, maxIndex + 1, end);
		TreeNode root = new TreeNode(max);
		root.left = left;
		root.right = right;
		return root;
	}
}
