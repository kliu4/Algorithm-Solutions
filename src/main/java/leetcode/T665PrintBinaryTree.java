package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class T665PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<String>> left = printTree(root.left);
		List<List<String>> right = printTree(root.right);
		List<List<String>> list = new ArrayList<>();
		if (left.isEmpty() && right.isEmpty()) {
			List<String> subList = new ArrayList<String>();
			subList.add("" + root.val + "");
			list.add(subList);
		} else {
			int rows = 0;
			int cols = 0;
			if (left.isEmpty()) {
				rows = right.size();
				cols = right.get(0).size();
			} else {
				rows = left.size();
				cols = left.get(0).size();
			}
			addSubList(root, list, left, right, rows, cols);
		}

		return list;
	}

	private void addSubList(TreeNode root, List<List<String>> list, List<List<String>> left, List<List<String>> right,
			int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			List<String> subList = new ArrayList<>();
			for (int j = 0; j < cols; j++) {
				subList.add(left.isEmpty() ? "" : left.get(i).get(j));
			}
			list.add(subList);
		}

		for (int i = 0; i < rows; i++) {
			list.get(i).add("");
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				list.get(i).add(right.isEmpty() ? "" : right.get(i).get(j));
			}
		}

		List<String> firstLine = new ArrayList<>();
		for (int j = 0; j < cols; j++)
			firstLine.add("");
		firstLine.add("" + root.val + "");
		for (int j = 0; j < cols; j++)
			firstLine.add("");
		list.add(0, firstLine);
	}

	public static void main(String[] args) {
		new T665PrintBinaryTree().printTree(T297SerializeBinaryTree.deserialize("1,2,3,null,4"));
	}
}
