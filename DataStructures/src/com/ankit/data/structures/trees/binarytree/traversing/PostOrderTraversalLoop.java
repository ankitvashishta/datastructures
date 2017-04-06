package com.ankit.data.structures.trees.binarytree.traversing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ankit.data.structures.trees.binarytree.BinaryTreeNode;

public class PostOrderTraversalLoop {

	public void postOrderTraverse(BinaryTreeNode rootNode) {
		Stack<BinaryTreeNode> nodeStack = new Stack<>();
		List<Integer> dataList = new ArrayList<>();
		BinaryTreeNode currentNode = rootNode;
		BinaryTreeNode prev = null;
		boolean done = false;
		if (!isNodeNull(rootNode)) {
			while (!done) {
				if (currentNode != null) {
					nodeStack.push(currentNode);
					currentNode = currentNode.getLeft();
				} else {
					if (nodeStack.isEmpty()) {
						done = true;
					} else {
						boolean iterate = true;
						while (iterate) {
							currentNode = nodeStack.pop();
							dataList.add(currentNode.getData());
							if (nodeStack.isEmpty()) {
								done = true;
								break;
							}
							prev = nodeStack.peek();
							if (currentNode == prev.getLeft()) {
								currentNode = prev.getRight();
								iterate = false;
							} else if (currentNode == prev.getRight()) {
								continue;
							}
						}
					}
				}
			}

		}
		System.out.println(dataList);
	}

	private boolean isNodeNull(BinaryTreeNode node) {
		return node == null;
	}

	public static void main(String args[]) {
		PostOrderTraversalLoop postOrderTraversal = new PostOrderTraversalLoop();
		BinaryTreeNode rootNode = postOrderTraversal.constructTree();
		postOrderTraversal.postOrderTraverse(rootNode);

	}

	private BinaryTreeNode constructTree() {
		BinaryTreeNode rootNode = new BinaryTreeNode(10);
		rootNode.setLeft(new BinaryTreeNode(5));
		rootNode.setRight(new BinaryTreeNode(15));
		rootNode.getLeft().setLeft(new BinaryTreeNode(3));
		rootNode.getLeft().setRight(new BinaryTreeNode(7));
		rootNode.getRight().setLeft(new BinaryTreeNode(12));
		rootNode.getRight().setRight(new BinaryTreeNode(18));
		return rootNode;
	}

}
