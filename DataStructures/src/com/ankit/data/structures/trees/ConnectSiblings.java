package com.ankit.data.structures.trees;

/**
 * Connect the sibling pointer to the next node in the same level. The last node
 * in each level should point to the first node of the next level in the tree.
 * 
 * Example : The Tree is :
 * 
 *                 100
 *                /   \
 *               50   200
 *              /  \     \
 *             25  75    300
 *                         \
 *                         350
 * Output : 100 50 200 25 75 300 350
 * which is the level-order traversal of the tree.  
 * 
 * @author ankit
 *
 */
public class ConnectSiblings {

	/*
	 * Runtime Complexity : O(n)
	 * 
	 * Space Complexity: O(1)
	 */
	public static void populateSiblingPointers(TreeNode root) {
		TreeNode curr = root;
		TreeNode last = root;

		while (curr != null) {
			if (curr.left != null) {
				last.next = curr.left;
				last = last.next;
			}
			if (curr.right != null) {
				last.next = curr.right;
				last = last.next;
			}
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(200);
		root.left.left = new TreeNode(25);
		root.left.right = new TreeNode(75);
		root.right.right = new TreeNode(300);
		root.right.right.right = new TreeNode(350);
		ConnectSiblings.populateSiblingPointers(root);
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