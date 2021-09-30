package com.ankit.data.structures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent the averages of all of
 * its levels.
 * 
 * @author ankit
 *
 */
public class LevelAverage {

	/*
	 * Time Complexity : O(n) where n is the number of nodes, as we traverse each
	 * node once.
	 * 
	 * Space Complexity : O(n) which is required for the queue. We can have a
	 * maximum of n/2 nodes at any level, the space required will be hence O(n).
	 */
	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<>();
		TreeNode currNode;
		Queue<TreeNode> queue = new ArrayDeque<>();
		Queue<TreeNode> queue2 = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty() || !queue2.isEmpty()) {
			double sum = 0d;
			int counter = 0;
			while (!queue.isEmpty()) {
				currNode = queue.poll();
				sum += currNode.val;
				counter++;
				if (currNode.left != null)
					queue2.offer(currNode.left);
				if (currNode.right != null)
					queue2.offer(currNode.right);
			}
			if (sum != 0)
				result.add(sum / counter);
			sum = 0d;
			counter = 0;
			while (!queue2.isEmpty()) {
				currNode = queue2.poll();
				sum += currNode.val;
				counter++;
				if (currNode.left != null)
					queue.offer(currNode.left);
				if (currNode.right != null)
					queue.offer(currNode.right);
			}
			if (sum != 0)
				result.add(sum / counter);
			sum = 0d;
			counter = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> result = LevelAverage.findLevelAverages(root);
		System.out.print("Level averages are: " + result);
	}
}