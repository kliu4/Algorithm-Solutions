package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TreeNode;

public class T297SerializeBinaryTreeTest {

	@Test
	public void testSerialize() {
		assertEquals("", T297SerializeBinaryTree.serialize(null));
	}

	@Test
	public void testSerializeSingleRoot() {
		assertEquals("1", T297SerializeBinaryTree.serialize(new TreeNode(1)));
	}

	@Test
	public void testSerializeRootWithLeft() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		assertEquals("1,2", T297SerializeBinaryTree.serialize(root));
	}

	@Test
	public void testSerializeRootWithRight() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		assertEquals("1,null,2", T297SerializeBinaryTree.serialize(root));
	}

	@Test
	public void testSerializeComplex() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		assertEquals("1,2,null,3,null,4", T297SerializeBinaryTree.serialize(root));
	}

	@Test
	public void testSerializeComplex2() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.left.left.left = new TreeNode(-1);
		root.right.left.left = new TreeNode(9);
		assertEquals("5,4,7,3,null,2,null,-1,null,9", T297SerializeBinaryTree.serialize(root));
	}

	@Test
	public void testDeSerialize() {
		assertEquals(null, T297SerializeBinaryTree.deserialize(""));
	}

	@Test
	public void testDeSerializeSingleRoot() {
		assertEquals("1", T297SerializeBinaryTree.serialize(T297SerializeBinaryTree.deserialize("1")));
	}

	@Test
	public void testDeSerializeRootWithLeft() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		assertEquals("1,2", T297SerializeBinaryTree.serialize(T297SerializeBinaryTree.deserialize("1,2")));
	}

	@Test
	public void testDeSerializeRootWithRight() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		assertEquals("1,null,2", T297SerializeBinaryTree.serialize(T297SerializeBinaryTree.deserialize("1,null,2")));
	}

	@Test
	public void testDeSerializeComplex() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		assertEquals("1,2,null,3,null,4",
				T297SerializeBinaryTree.serialize(T297SerializeBinaryTree.deserialize("1,2,null,3,null,4")));
	}

	@Test
	public void testDeSerializeComplex2() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.left.left.left = new TreeNode(-1);
		root.right.left.left = new TreeNode(9);
		assertEquals("5,4,7,3,null,2,null,-1,null,9", T297SerializeBinaryTree
				.serialize(T297SerializeBinaryTree.deserialize("5,4,7,3,null,2,null,-1,null,9")));
	}
}
