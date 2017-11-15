package leetcode;

import util.TreeNode;

public class T687LongestUnivaluePath {
	int max = 0;

	public int longestUnivaluePath(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;

		int l = helper(root.left);
		int r = helper(root.right);

		int pl = (root.left != null && root.val == root.left.val) ? l + 1 : 0;
		int pr = (root.right != null && root.val == root.right.val) ? r + 1 : 0;

		max = Math.max(max, pl + pr);
		return Math.max(pl, pr);
	}
}
