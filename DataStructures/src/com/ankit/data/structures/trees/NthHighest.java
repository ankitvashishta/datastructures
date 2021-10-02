package com.ankit.data.structures.trees;

/**
 * Find the nth highest node in a Binary Search Tree(BST).
 * 
 * Example : The Tree is :
 * 
 *                 100
 *               /    \
 *              50     200
 *             / \    /   \
 *           25  75   125 350
 *           
 * For n = 1, output would be 350 
 * For n = 5, output would be 75
 * For n = 2, output would be 200
 * For n = 30, output would be null                          
 * 
 * @author ankit
 *
 */
public class NthHighest {
	public static int currentCount = 0;

	/*
	 * Runtime Complexity : O(n)
	 */
	public static TreeNode findNthHighestInBST(TreeNode node, int n) {
		return traverse(node, n);
	}

	public static TreeNode traverse(TreeNode currNode, int n) {
		if (currNode != null) {
			if (currNode.right != null) {
				TreeNode node = traverse(currNode.right, n);
				if (node != null)
					return node;
			}
			currNode.count = ++currentCount;
			if (currNode.left != null) {
				TreeNode node = traverse(currNode.left, n);
				if (node != null)
					return node;
			}
		}
		if (currNode.count == n)
			return currNode;
		else
			return null;
	}

	public static void main(String[] argv) {

		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(200);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(75);
		root.right.left = new TreeNode(125);
		root.right.right = new TreeNode(350);

		int n = 2;
		currentCount = 0;
		TreeNode nth_highest_node = findNthHighestInBST(root, n);
		System.out.println(nth_highest_node.data);

		n = 1;
		currentCount = 0;
		nth_highest_node = findNthHighestInBST(root, n);
		System.out.println(nth_highest_node.data);

		n = 5;
		currentCount = 0;
		nth_highest_node = findNthHighestInBST(root, n);
		System.out.println(nth_highest_node.data);

		n = 30;
		currentCount = 0;
		nth_highest_node = findNthHighestInBST(root, n);
		String val = nth_highest_node == null ? "null" : String.valueOf(nth_highest_node.data);
		System.out.println(val);
	}

	private static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		int count;

		TreeNode(int x) {
			data = x;
			left = right = null;
		}

	}

}