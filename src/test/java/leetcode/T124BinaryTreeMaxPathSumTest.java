package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TreeNode;

public class T124BinaryTreeMaxPathSumTest {

	@Test
	public void maxPathSum() {
		TreeNode root = T297SerializeBinaryTree.deserialize("1,2,3");
		assertEquals(6, new T124BinaryTreeMaxPathSum().maxPathSum(root));
	}
	
	@Test
	public void maxPathSumWithNegative() {
		TreeNode root = T297SerializeBinaryTree.deserialize("-1,2,3");
		assertEquals(4, new T124BinaryTreeMaxPathSum().maxPathSum(root));
	}
	
	@Test
	public void maxPathSumComplex() {
		TreeNode root = T297SerializeBinaryTree.deserialize("1,2,3,4,5,6,7");
		assertEquals(18, new T124BinaryTreeMaxPathSum().maxPathSum(root));
	}

}
