package leetcode;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class T742ClosestLeafInABinaryTree {
	class ClosestLeaf {
		int leafValue;
		int length;

		public ClosestLeaf(int leafValue, int length) {
			this.leafValue = leafValue;
			this.length = length;
		}
	}

	Map<Integer, ClosestLeaf> closestLeafInChildrenMap = new HashMap<>();

	public int findClosestLeaf(TreeNode root, int k) {
		if (root == null)
			return -1;

		findClosestLeafInChildren(root);
		secondPass(root);
		return closestLeafInChildrenMap.get(k).leafValue;
	}

	private ClosestLeaf findClosestLeafInChildren(TreeNode root) {
		if (root == null)
			return null;

		ClosestLeaf left = findClosestLeafInChildren(root.left);
		ClosestLeaf right = findClosestLeafInChildren(root.right);

		if (left == null && right == null) {
			ClosestLeaf mid = new ClosestLeaf(root.val, 0);
			closestLeafInChildrenMap.put(root.val, mid);
			return mid;
		}

		ClosestLeaf mid = null;
		if (left == null)
			mid = new ClosestLeaf(right.leafValue, right.length + 1);
		else if (right == null)
			mid = new ClosestLeaf(left.leafValue, left.length + 1);
		else {
			boolean leftIsSmaller = left.length < right.length;
			mid = new ClosestLeaf(leftIsSmaller ? left.leafValue : right.leafValue,
					leftIsSmaller ? left.length + 1 : right.length + 1);
		}
		closestLeafInChildrenMap.put(root.val, mid);
		return mid;
	}

	private void secondPass(TreeNode root) {
		if (root == null)
			return;

		ClosestLeaf rootClosest = closestLeafInChildrenMap.get(root.val);

		if (root.left != null) {
			ClosestLeaf left = closestLeafInChildrenMap.get(root.left.val);
			if (left.length > rootClosest.length + 1) {
				closestLeafInChildrenMap.put(root.left.val,
						new ClosestLeaf(rootClosest.leafValue, rootClosest.length + 1));
			}
		}

		if (root.right != null) {
			ClosestLeaf right = closestLeafInChildrenMap.get(root.right.val);
			if (right.length > rootClosest.length + 1) {
				closestLeafInChildrenMap.put(root.right.val,
						new ClosestLeaf(rootClosest.leafValue, rootClosest.length + 1));
			}
		}
		
		secondPass(root.left);
		secondPass(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.left.left.left = new TreeNode(12);
		root.left.left.left.left.left = new TreeNode(13);
		root.left.left.left.left.left.left = new TreeNode(14);
		
		System.out.println(new T742ClosestLeafInABinaryTree().findClosestLeaf(root, 8));
	}
}
