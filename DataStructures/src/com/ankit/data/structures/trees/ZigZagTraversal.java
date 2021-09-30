package com.ankit.data.structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its zigzag level order
 * traversal. You should populate the values of all nodes of the first level
 * from left to right, then right to left for the next level and keep
 * alternating in the same manner for the following levels.
 * 
 * @author ankit
 *
 */
public class ZigZagTraversal {

	/*
	 * Time Complexity : O(n) where n is the number of nodes, as we traverse each
	 * node once.
	 * 
	 * Space Complexity : O(n) as we return a list containing the traversed nodes.
	 * Also we need O(n) space for the queue.
	 */
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> frontQueue = new LinkedList<>();
		Queue<TreeNode> backQueue = new LinkedList<>();
		frontQueue.offer(root);
		TreeNode currNode;
		while (!frontQueue.isEmpty() || !backQueue.isEmpty()) {
			LinkedList<Integer> rowResult = new LinkedList<>();
			while (!frontQueue.isEmpty()) {
				currNode = frontQueue.poll();
				rowResult.add(currNode.val);
				if (currNode.left != null)
					backQueue.offer(currNode.left);
				if (currNode.right != null)
					backQueue.offer(currNode.right);
			}
			result.add(rowResult);
			rowResult = new LinkedList<>();
			while (!backQueue.isEmpty()) {
				currNode = backQueue.poll();
				rowResult.addFirst(currNode.val);
				if (currNode.left != null)
					frontQueue.offer(currNode.left);
				if (currNode.right != null)
					frontQueue.offer(currNode.right);
			}
			result.add(rowResult);
			rowResult = new LinkedList<>();
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigZagTraversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);
	}
}
