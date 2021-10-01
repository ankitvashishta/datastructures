package com.ankit.data.structures.trees;

class IsBST {
	static TreeNode prev = null;

	public static boolean isBst(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (!isBst(root.left)) {
			return false;
		}

		if (prev != null && prev.val >= root.val) {
			return false;
		}
		prev = root;

		if (!isBst(root.right)) {
			return false;
		}

		return true;
	}

	public static void main(String[] argv) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);

		System.out.println(Boolean.toString(isBst(root)));
	}
}
