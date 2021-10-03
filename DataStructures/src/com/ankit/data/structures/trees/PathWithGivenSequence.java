package com.ankit.data.structures.trees;

import java.util.ArrayList;
import java.util.List;

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
	 * Space Complexity : O(n)
	 */
	public static boolean findPath(TreeNode root, int[] sequence) {
		String result = "";
		for (int i : sequence)
			result += i;
		List<String> paths = new ArrayList<String>();
		getPaths(root, "", result, paths);
		for (String str : paths)
			if (str.equals(result))
				return true;
		return false;
	}

	public static void getPaths(TreeNode node, String str, String result, List<String> paths) {
		str += node.val;
		if (node.left == null && node.right == null)
			paths.add(str);
		if (node.left != null)
			getPaths(node.left, str, result, paths);
		if (node.right != null)
			getPaths(node.right, str, result, paths);
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