package com.ankit.data.structures.trees.bst;

import java.util.List;

public class BinarySearchTree {

	Node root = null;

	class Node {
		int key;
		Node left;
		Node right;
		Node parent;

		Node(int key, Node parent) {
			this.key = key;
			this.parent = parent;
		}
	}

	public BinarySearchTree insert(BinarySearchTree bst, int value) {
		if (bst.root == null) {
			bst.root = new Node(value, null);
			return bst;
		}
		Node x = bst.root;
		Node parentNode = null;
		while (x != null) {
			parentNode = x;
			if (value < x.key) {
				x = x.left;
				continue;
			} else {
				x = x.right;
				continue;
			}
		}
		Node currentNode = new Node(value, parentNode);
		if (currentNode.key < parentNode.key) {
			parentNode.left = currentNode;
			return bst;
		} else {
			parentNode.right = currentNode;
			return bst;
		}
	}

	/**
	 * If root is the root of an n-node subtree, then the call
	 * INORDER-TREE-WALK. takes O(n) time. //'-' inside O and not simple O
	 * 
	 * @param list
	 * @param root
	 * @return list
	 */
	public List<Integer> inorderTraversal(List<Integer> list, Node root) {
		if (root != null) {
			inorderTraversal(list, root.left);
			list.add(root.key);
			inorderTraversal(list, root.right);
		}
		return list;
	}

	/**
	 * Running time of TREE-SEARCH is O(h), where h is the height of the tree.
	 * 
	 * @param key
	 * @param root
	 * @return
	 */
	public Node treeSearch(int key, Node root) {
		if (root == null || key == root.key) {
			return root;
		}
		if (key < root.key) {
			return treeSearch(key, root.left);
		} else {
			return treeSearch(key, root.right);
		}
	}

	/**
	 * Running time of TREE-MINIMUM is O(h), where h is the height of the tree.
	 * 
	 * @param root
	 * @return
	 */
	public Node treeMinimum(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	/**
	 * Running time of TREE-MAXIMUM is O(h), where h is the height of the tree.
	 * 
	 * @param root
	 * @return
	 */
	public Node treeMaximum(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	/**
	 * The structure of a binary search tree allows us to determine the
	 * successor of a node without ever comparing keys
	 * 
	 * @param root
	 * @return
	 */
	public Node treeSuccessor(Node root) {
		Node y = null;
		if (root.right != null) {
			return treeMinimum(root.right);
		}
		y = root.parent;
		while (y != null && root == y.right) {
			root = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * The structure of a binary search tree allows us to determine the
	 * predecessor of a node without ever comparing keys
	 * 
	 * @param root
	 * @return
	 */
	public Node treePredecessor(Node root) {
		Node y = null;
		if (root.left != null) {
			return treeMaximum(root.left);
		}
		y = root.parent;
		while (y != null && root == y.left) {
			root = y;
			y = y.parent;
		}
		return y;
	}
}
