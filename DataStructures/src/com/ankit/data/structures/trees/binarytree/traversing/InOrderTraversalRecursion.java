package com.ankit.data.structures.trees.binarytree.traversing;

import com.ankit.data.structures.trees.binarytree.BinaryTreeNode;

public class InOrderTraversalRecursion {

	public void inorderTraverse(BinaryTreeNode rootNode) {
		if (!isNodeNull(rootNode)) {
			inorderTraverse(rootNode.getLeft());
			System.out.println(rootNode.getData());
			inorderTraverse(rootNode.getRight());
		}
	}

	private boolean isNodeNull(BinaryTreeNode node) {
		return node == null;
	}

	public static void main(String args[]) {
		InOrderTraversalRecursion inorderTraversal = new InOrderTraversalRecursion();
		BinaryTreeNode rootNode = inorderTraversal.constructTree();
		inorderTraversal.inorderTraverse(rootNode);

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
