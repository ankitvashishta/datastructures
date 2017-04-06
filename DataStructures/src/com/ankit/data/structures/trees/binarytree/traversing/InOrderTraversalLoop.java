package com.ankit.data.structures.trees.binarytree.traversing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ankit.data.structures.trees.binarytree.BinaryTreeNode;

public class InOrderTraversalLoop {
	public void inorderTraverse(BinaryTreeNode rootNode) {
		Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
		List<Integer> dataList = new ArrayList<Integer>();
		BinaryTreeNode temp = null;
		boolean done = true;
		if (!isNodeNull(rootNode)) {
			temp = rootNode;
			while (done) {
				if (temp != null) {
					nodeStack.push(temp);
					temp = temp.getLeft();
				} else {
					if (nodeStack.empty()) {
						done = false;
					} else {
						temp = nodeStack.pop();
						dataList.add(temp.getData());
						temp = temp.getRight();
					}
				}
			}
			System.out.println(dataList);
		}
	}

	private boolean isNodeNull(BinaryTreeNode node) {
		return node == null;
	}

	public static void main(String args[]) {
		InOrderTraversalLoop inorderTraversal = new InOrderTraversalLoop();
		BinaryTreeNode rootNode = inorderTraversal.constructTree();
		inorderTraversal.inorderTraverse(rootNode);
		System.out.println();
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
