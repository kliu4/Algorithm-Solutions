package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class T145BinaryTreePostorder {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s1 = new Stack<>();
		if(root == null)
			return list;
		s1.push(root);
		while(!s1.isEmpty() && root != null) {
			TreeNode temp1 = s1.pop();
			if(temp1.left != null)
				s1.push(temp1.left);
			if(temp1.right != null)
				s1.push(temp1.right);
			
			list.add(0, temp1.val);
		}
		
		return list;
	}
}
