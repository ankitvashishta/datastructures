package com.ankit.data.structures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each
 * root-to-leaf path will represent a number. Find the total sum of all the
 * numbers represented by all paths.
 * 
 * Example :  1
 *           / \
 *          7   9
 *             / \
 *            2   9
 *            
 * Output : 408
 * Explanation : Sum of all path numbers - 17 + 192 + 199
 * 
 * @author ankit
 *
 */
public class SumOfPathNumbers {
	
	/*
	 * Runtime Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 */
	public static int findSumOfPathNumbers(TreeNode root) {
		List<String> paths = new ArrayList<>();
		getPaths(root, "", paths);
		int sum = 0;
		for (String str : paths)
			sum += Integer.parseInt(str);
		return sum;
	}

	public static void getPaths(TreeNode node, String str, List<String> paths) {
		str += node.val;
		if (node.left == null && node.right == null)
			paths.add(str);
		if (node.left != null)
			getPaths(node.left, str, paths);
		if (node.right != null)
			getPaths(node.right, str, paths);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}
}
