package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

public class T297SerializeBinaryTree {
	public final static String NULL_STR = "null";

	public static String serialize(TreeNode root) {
		if (root == null)
			return "";

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			if (queue.peek() != null) {
				queue.offer(queue.peek().left);
				queue.offer(queue.peek().right);

			}
			stack.push(queue.poll());
		}

		while (stack.peek() == null)
			stack.pop();
		String res = "" + stack.pop().val;
		while (!stack.isEmpty()) {
			if (stack.peek() == null)
				res = NULL_STR + "," + res;
			else
				res = stack.peek().val + "," + res;
			stack.pop();
		}
		return res;
	}

	public static TreeNode getNode(String[] strs, int i) {
		if (i >= strs.length || strs[i].equals(NULL_STR))
			return null;
		return new TreeNode(Integer.parseInt(strs[i]));
	}

	public static TreeNode deserialize(String input) {
		if (input == null || input.equals(""))
			return null;

		String[] strs = input.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		int i = 1;
		while(!queue.isEmpty()) {
			if(i >= strs.length)
				break;
			TreeNode node = queue.poll();
			if(node != null) {
				TreeNode left = getNode(strs, i++);
				TreeNode right = getNode(strs, i++);
				node.left = left;
				node.right = right;
				queue.offer(left);
				queue.offer(right);
			}
		}
		return root;
	}
}
