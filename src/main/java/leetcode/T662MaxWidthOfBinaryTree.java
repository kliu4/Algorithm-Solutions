package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class T662MaxWidthOfBinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> iQueue = new LinkedList<Integer>();

		queue.offer(root);
		iQueue.offer(0);

		int maxWidth = 0;

		while (!queue.isEmpty()) {
			int nodes = queue.size();
			int min = iQueue.peek();
			int max = 0;
			for (int i = 0; i < nodes; i++) {
				TreeNode node = queue.poll();
				int pIndex = iQueue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					iQueue.offer(2 * pIndex - 2 * min);
				}
				if (node.right != null) {
					queue.offer(node.right);
					iQueue.offer(2 * pIndex + 1 - 2 * min);
				}
				max = Math.max(max, pIndex);
			}
			maxWidth = Math.max(maxWidth, max - min + 1);
		}

		return maxWidth;
	}
}
