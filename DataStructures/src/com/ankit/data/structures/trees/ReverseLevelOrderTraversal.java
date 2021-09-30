package com.ankit.data.structures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its level-by-level
 * traversal in reverse order, i.e., the lowest level comes first. You should
 * populate the values of all nodes in each level from left to right in separate
 * sub-arrays.
 * 
 * @author ankit
 *
 */
public class ReverseLevelOrderTraversal {

	/*
	 * Time Complexity : O(n) where n is the number of nodes, as we traverse each
	 * node once.
	 * 
	 * Space Complexity : O(n) as we return a list containing the traversed nodes.
	 * Also we need O(n) space for the queue.
	 */
	public static List<List<Integer>> traverse(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		TreeNode currNode;
		Queue<TreeNode> queue = new ArrayDeque<>();
		Queue<TreeNode> queue2 = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty() || !queue2.isEmpty()) {
			List<Integer> levelOrderList = new ArrayList<>();
			while (!queue.isEmpty()) {
				currNode = queue.poll();
				levelOrderList.add(currNode.val);
				if (currNode.left != null)
					queue2.offer(currNode.left);
				if (currNode.right != null)
					queue2.offer(currNode.right);
			}
			if (levelOrderList.size() != 0)
				result.addFirst(levelOrderList);
			levelOrderList = new ArrayList<>();
			while (!queue2.isEmpty()) {
				currNode = queue2.poll();
				levelOrderList.add(currNode.val);
				if (currNode.left != null)
					queue.offer(currNode.left);
				if (currNode.right != null)
					queue.offer(currNode.right);
			}
			if (levelOrderList.size() != 0)
				result.addFirst(levelOrderList);
		}
		// TODO: Write your code here
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
		System.out.println("Reverse level order traversal: " + result);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
