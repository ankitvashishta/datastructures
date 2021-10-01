package com.ankit.data.structures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, connect each node with its level order successor. The
 * last node of each level should point to a null node.
 * 
 * @author ankit
 *
 */
public class ConnectLevelOrderSiblings {

	/*
	 * Time Complexity : O(n) where n is the number of nodes, as we traverse each
	 * node once.
	 * 
	 * Space Complexity : O(n) as we return a list containing the traversed nodes.
	 * Also we need O(n) space for the queue.
	 */
	public static void connect(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> nextLevelQueue = new LinkedList<>();
		queue.offer(root);
		TreeNode currNode;
		while (!queue.isEmpty() || !nextLevelQueue.isEmpty()) {
			while (!queue.isEmpty()) {
				currNode = queue.poll();
				if (currNode.left != null)
					nextLevelQueue.offer(currNode.left);
				if (currNode.right != null)
					nextLevelQueue.offer(currNode.right);
				if (queue.peek() != null)
					currNode.next = queue.peek();
				else
					currNode.next = null;
			}
			while (!nextLevelQueue.isEmpty()) {
				currNode = nextLevelQueue.poll();
				if (currNode.left != null)
					queue.offer(currNode.left);
				if (currNode.right != null)
					queue.offer(currNode.right);
				if (nextLevelQueue.peek() != null)
					currNode.next = nextLevelQueue.peek();
				else
					currNode.next = null;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		ConnectLevelOrderSiblings.connect(root);
		System.out.println("Level order traversal using 'next' pointer: ");
		root.printLevelOrder();
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int x) {
			val = x;
			left = right = next = null;
		}

		// level order traversal using 'next' pointer
		void printLevelOrder() {
			TreeNode nextLevelRoot = this;
			while (nextLevelRoot != null) {
				TreeNode current = nextLevelRoot;
				nextLevelRoot = null;
				while (current != null) {
					System.out.print(current.val + " ");
					if (nextLevelRoot == null) {
						if (current.left != null)
							nextLevelRoot = current.left;
						else if (current.right != null)
							nextLevelRoot = current.right;
					}
					current = current.next;
				}
				System.out.println();
			}
		}
	}
}
