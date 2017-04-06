package com.ankit.data.structures.trees.binarytree.traversing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ankit.data.structures.trees.binarytree.BinaryTreeNode;

public class PreOrderTraversalLoop {

	public void preOrderTraverse(BinaryTreeNode rootNode) {
		Stack<BinaryTreeNode> nodeStack = new Stack<>();
		List<Integer> dataList = new ArrayList<>();
		BinaryTreeNode temp = rootNode;
		boolean done = true;
		if (!isNodeNull(rootNode)) {
			while (done) {
				if (temp != null) {
					dataList.add(temp.getData());
					nodeStack.push(temp.getRight());
					nodeStack.push(temp.getLeft());
				}
				if (nodeStack.isEmpty()) {
					done = false;
				} else {
					temp = nodeStack.pop();
				}
			}
		}
		System.out.println(dataList);
	}

	private boolean isNodeNull(BinaryTreeNode node) {
		return node == null;
	}

	public static void main(String args[]) {
		PreOrderTraversalLoop preOrderTraversal = new PreOrderTraversalLoop();
		BinaryTreeNode rootNode = preOrderTraversal.constructTree();
		preOrderTraversal.preOrderTraverse(rootNode);

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
