package com.ankit.data.structures.trees.binarytree.traversing;

import com.ankit.data.structures.trees.binarytree.BinaryTreeNode;

public class PostOrderTraversalRecursion {

	public void postOrderTraverse(BinaryTreeNode rootNode) {
		if (!isNodeNull(rootNode)) {
			postOrderTraverse(rootNode.getLeft());
			postOrderTraverse(rootNode.getRight());
			System.out.println(rootNode.getData());
		}
	}

	private boolean isNodeNull(BinaryTreeNode node) {
		return node == null;
	}

	public static void main(String args[]) {
		PostOrderTraversalRecursion postOrderTraversal = new PostOrderTraversalRecursion();
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
