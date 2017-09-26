package leetcode;

import util.TreeNode;

public class T099RecoverBST {
	private TreeNode first;
	private TreeNode second;
	
	private TreeNode smaller =  new TreeNode(Integer.MIN_VALUE);
	private TreeNode bigger =  new TreeNode(Integer.MAX_VALUE);
	
	
	public void recoverTree(TreeNode root) {
		helperTofindFirst(root);
		helperTofindSecond(root);
		swap(first, second);
	}
	
	private void swap(TreeNode first, TreeNode second) {
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
	
	private void helperTofindFirst(TreeNode root) {
		if(root == null)
			return;
		helperTofindFirst(root.left);
		
		if(first != null)
			return;
		if(smaller.val >= root.val)
			first = smaller;
		
		smaller = root;
		helperTofindFirst(root.right);
	}
	
	
	private void helperTofindSecond(TreeNode root) {
		if(root == null)
			return;
		helperTofindSecond(root.right);
		
		if(second != null)
			return;
		if(bigger.val <= root.val)
			second = bigger;
		
		bigger = root;
		helperTofindSecond(root.left);
	}
}
