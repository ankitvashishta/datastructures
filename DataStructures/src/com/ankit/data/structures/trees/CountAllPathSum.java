package com.ankit.data.structures.trees;

/**
 * Given a binary tree and a number ‘S’, find all paths in the tree such that
 * the sum of all the node values of each path equals ‘S’. Please note that the
 * paths can start or end at any node but all paths must follow direction from
 * parent to child (top to bottom).
 * 
 * Example :  12
 *           /  \
 *          7    1
 *          |   / \
 *          4  10  5
 * S: 11
 * Output: 2
 * Explanation: Here are the two paths with sum '11':7 -> 4 and 1 -> 10.
 * 
 * @author ankit
 *
 */
public class CountAllPathSum {
	
	/*
	 * Runtime Complexity : O(n^2)
	 * 
	 * Space Complexity : O(n)
	 */
	public static int countPaths(TreeNode root, int S) {
		int count = 0;
		return checkForAllNodes(root, S, count);
	}

	public static int checkForAllNodes(TreeNode node, int s, int count) {
		count = getPaths(node, 0, s, count);
		if (node.left != null)
			count = checkForAllNodes(node.left, s, count);
		if (node.right != null)
			count = checkForAllNodes(node.right, s, count);
		return count;
	}

	public static int getPaths(TreeNode node, int sum, int s, int count) {
		sum += node.val;
		if (node.left == null && node.right == null)
			if (sum == s)
				count++;
		if (node.left != null)
			count = getPaths(node.left, sum, s, count);
		if (node.right != null)
			count = getPaths(node.right, sum, s, count);
		return count;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
	}
}