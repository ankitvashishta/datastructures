package com.ankit.data.structures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, convert it to a doubly linked list so that the order of
 * the doubly linked list is the same as an in-order traversal of the binary
 * tree.
 * 
 * @author ankit
 *
 */
public class ToDLL {
	public static TreeNode convertToLinkedList(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		inOrderTraversal(root, queue);
		TreeNode newRoot = queue.poll();
		TreeNode prevNode = newRoot;
		TreeNode currNode = null;
		while (!queue.isEmpty()) {
			currNode = queue.poll();
			prevNode.right = currNode;
			currNode.left = prevNode;
			prevNode = currNode;
		}
		currNode.right = null;
		return newRoot;
	}

	public static void inOrderTraversal(TreeNode currNode, Queue<TreeNode> queue) {
		if (currNode != null) {
			inOrderTraversal(currNode.left, queue);
			queue.offer(currNode);
			inOrderTraversal(currNode.right, queue);
		}
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
		root = convertToLinkedList(root);
		while(root!=null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
		
	}
}
