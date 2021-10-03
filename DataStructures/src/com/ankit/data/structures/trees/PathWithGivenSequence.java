package com.ankit.data.structures.trees;

/**
 * Given a binary tree and a number sequence, find if the
 * sequence is present as a root-to-leaf path in the given tree.
 * 
 * Example :  1
 *           / \
 *          0   1
 *          |  / \
 *          1 6   5
 *          
 * Sequence - [1,0,7]
 * Output : false
 * 
 * Sequence - [1,1,6]
 * Output : true
 * 
 * @author ankit
 *
 */
public class PathWithGivenSequence {
	/*
	 * Runtime Complexity : O(n)
	 * 
	 * Space Complexity : O(n) - Space to store recursive call stack.
	 */
	public static boolean findPath(TreeNode root, int[] sequence) {
		String result = "";
		for (int i : sequence)
			result += i;
		return getPaths(root, "", result);
	}

	public static boolean getPaths(TreeNode node, String str, String result) {
		str += node.val;
		if (node.left == null && node.right == null)
			if (str.equals(result))
				return true;
		boolean left = false;
		boolean right = false;
		if (node.left != null)
			left = getPaths(node.left, str, result);
		if (node.right != null)
			right = getPaths(node.right, str, result);
		return left || right;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}
}