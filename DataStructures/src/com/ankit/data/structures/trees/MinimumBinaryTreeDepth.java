package com.ankit.data.structures.trees;

/**
 * Find the minimum depth of a binary tree. The minimum depth is the number of
 * nodes along the shortest path from the root node to the nearest leaf node.
 * 
 * Example :  12
 *           /  \
 *          7    1
 *              / \
 *             10  5
 *  Result : 2
 *  
 * Example :  12
 *           /  \
 *          7    1
 *          |   / \
 *          9  10  5
 *             |
 *             11
 *  Result : 3
 * 
 * @author ankit
 *
 */
public class MinimumBinaryTreeDepth {
	
	/*
	 * Time Complexity : O(n)
	 */
	public static int findDepth(TreeNode root) {
		return minDepth(root, 1);
	}

	public static int minDepth(TreeNode node, int depth) {
		if (node.left == null && node.right == null)
			return depth;
		int left = depth + 1;
		int right = depth + 1;
		if (node.left != null)
			left = minDepth(node.left, depth + 1);
		if (node.right != null)
			right = minDepth(node.right, depth + 1);
		return Math.min(left, right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	}
}