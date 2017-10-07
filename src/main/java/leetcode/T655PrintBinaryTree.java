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
			list = addSubList(root, left, right, rows, cols);
		}

		return list;
	}

	private void setValues(List<List<String>> list, List<List<String>> subList, int rows, int cols, int start) {
		for (int i = 0; i < subList.size(); i++) {
			int subCols = subList.get(0).size();
			List<String> row = list.get(i);
			int multi = (cols - subCols)/(subCols + 1);
			for(int j = 0; j < subCols; j++)
				row.set(start + (multi + 1) * (j + 1) - 1 , subList.get(i).get(j));
		}
	}

	private List<List<String>> addSubList(TreeNode root, List<List<String>> left, List<List<String>> right,
			int rows, int cols) {
		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			List<String> subList = new ArrayList<>();
			for(int j = 0; j < cols * 2 + 1; j++)
				subList.add("");
			list.add(subList);
		}
		setValues(list, left, rows, cols, 0);
		setValues(list, right, rows, cols, cols + 1);

		List<String> firstLine = new ArrayList<>();
		for (int j = 0; j < cols; j++)
			firstLine.add("");
		firstLine.add("" + root.val + "");
		for (int j = 0; j < cols; j++)
			firstLine.add("");
		list.add(0, firstLine);
		return list;
	}

	public static void main(String[] args) {
		new T655PrintBinaryTree().printTree(T297SerializeBinaryTree.deserialize("1,2,3,null,4"));
	}
}
