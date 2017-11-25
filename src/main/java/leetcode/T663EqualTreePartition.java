package leetcode;

import java.util.HashSet;
import java.util.Set;

import util.TreeNode;

public class T663EqualTreePartition {
	public boolean checkEqualTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return false;

		TreeNode dummyRoot = root;
		Set<Integer> sums = new HashSet<>();
		int sum = getSum(dummyRoot, root, sums);

		if (sum % 2 != 0)
			return false;

		return sums.contains(sum / 2);
	}

	private int getSum(TreeNode dummyRoot, TreeNode root, Set<Integer> set) {
		if (dummyRoot == null)
			return 0;
		int sum = getSum(dummyRoot.left, root, set) + dummyRoot.val + getSum(dummyRoot.right, root, set);
		if (dummyRoot != root)
			set.add(sum);
		return sum;
	}
}
