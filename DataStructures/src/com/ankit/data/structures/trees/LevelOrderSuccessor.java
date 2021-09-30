package com.ankit.data.structures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given
 * node in the tree. The level order successor is the node that appears right
 * after the given node in the level order traversal.
 * 
 * @author ankit
 *
 */
public class LevelOrderSuccessor {

	/*
	 * Time Complexity : O(n) where n is the number of nodes, as we traverse each
	 * node once.
	 * 
	 * Space Complexity : O(n) as we return a list containing the traversed nodes.
	 * Also we need O(n) space for the queue.
	 */
	public static TreeNode findSuccessor(TreeNode root, int key) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode currNode = root;
		while (!queue.isEmpty()) {
			currNode = queue.poll();
			if (currNode.left != null)
				queue.offer(currNode.left);
			if (currNode.right != null)
				queue.offer(currNode.right);
			if (currNode.val == key)
				return queue.poll();
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = LevelOrderSuccessor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}
}