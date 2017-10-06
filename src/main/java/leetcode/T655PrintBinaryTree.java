package leetcode;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class T655PrintBinaryTree {
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
			int rows = Math.max(left.size(), right.size());
			int cols = left.size() == rows ? left.get(0).size() : right.get(0).size();
			addSubList(root, list, left, right, rows, cols);
		}

		return list;
	}

	private void addSubList(List<List<String>> list, List<List<String>> subList, int rows, int cols) {
		for (int i = 0; i < subList.size(); i++) {
			int subCols = subList.get(0).size();
			List<String> row = list.get(i);
			for (int j = 0; j < (cols - subCols) / 2; j++)
				row.add("");
			for (int j = 0; j < subCols; j++)
				row.add(subList.get(i).get(j));
			for (int j = 0; j < (cols - subCols) / 2; j++)
				row.add("");
		}
		for (int i = subList.size(); i < rows; i++) {
			List<String> row = list.get(i);
			for (int j = 0; j < cols; j++)
				row.add("");
		}
	}

	private void addSubList(TreeNode root, List<List<String>> list, List<List<String>> left, List<List<String>> right,
			int rows, int cols) {
		for (int i = 0; i < rows; i++)
			list.add(new ArrayList<String>());
		addSubList(list, left, rows, cols);

		for (int i = 0; i < rows; i++) {
			list.get(i).add("");
		}

		addSubList(list, right, rows, cols);

		List<String> firstLine = new ArrayList<>();
		for (int j = 0; j < cols; j++)
			firstLine.add("");
		firstLine.add("" + root.val + "");
		for (int j = 0; j < cols; j++)
			firstLine.add("");
		list.add(0, firstLine);
	}

	public static void main(String[] args) {
		new T655PrintBinaryTree().printTree(T297SerializeBinaryTree.deserialize("1,2,3,null,4"));
	}
}
