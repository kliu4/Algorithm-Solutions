package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.TreeNode;

public class T652FindDuplicateSubTrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		if (root == null)
			return list;

		Set<String> set = new HashSet<>();
		Set<String> added = new HashSet<>();

		// dfs()
		dfs(root, set, added, list);
		return list;
	}

	private String dfs(TreeNode root, Set<String> set, Set<String> added, List<TreeNode> list) {
		if (root == null)
			return "#";
		String left = dfs(root.left, set, added, list);
		String right = dfs(root.right, set, added, list);
		String cur = root.val + "," + left + "," + right;
		if (!set.add(cur) && added.add(cur))
			list.add(root);
		return cur;
	}
}
