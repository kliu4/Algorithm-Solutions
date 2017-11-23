package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class T103BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int a = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (a % 2 == 0)
					subList.add(node.val);
				else
					subList.add(0, node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			list.add(subList);
			a++;
		}

		return list;
	}
}
