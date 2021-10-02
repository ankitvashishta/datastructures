package com.ankit.data.structures.trees;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialize a binary tree to a file and then deserialize it back to a tree so
 * that the original and the deserialized trees are identical.
 * 
 * @author ankit
 *
 */
public class SerializeBT {

	public static void serialize(TreeNode node, ObjectOutputStream stream) throws java.io.IOException {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		String out = "";
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			out += currNode.val + " ";
			if (currNode.left != null)
				queue.offer(currNode.left);
			if (currNode.right != null)
				queue.offer(currNode.right);
		}
		stream.writeObject(out);
	}

	public static TreeNode deserialize(ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
		TreeNode root = null;
		String input = (String) stream.readObject();
		String[] arr = input.split(" ");
		for (String str : arr) {
			if (root == null) {
				root = new TreeNode(Integer.parseInt(str));
			} else {
				boolean foundPlace = false;
				TreeNode currNode = root;
				while (!foundPlace) {
					int x = Integer.parseInt(str);
					if (x < currNode.val)
						if (currNode.left == null) {
							currNode.left = new TreeNode(x);
							foundPlace = true;
						} else
							currNode = currNode.left;
					else if (x > currNode.val)
						if (currNode.right == null) {
							currNode.right = new TreeNode(x);
							foundPlace = true;
						} else
							currNode = currNode.right;
				}
			}

		}
		return root;
	}

	public static void main(String[] args) {
		try {
			TreeNode root = new TreeNode(100);
			root.left = new TreeNode(50);
			root.right = new TreeNode(200);
			root.left.left = new TreeNode(25);
			root.left.right = new TreeNode(75);
			root.right.right = new TreeNode(350);

			root.printLevelOrder();

			ByteArrayOutputStream baostream = new ByteArrayOutputStream();
			ObjectOutputStream stream = new ObjectOutputStream(baostream);
			serialize(root, stream);
			stream.close();

			ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
			ObjectInputStream istream = new ObjectInputStream(baistream);
			TreeNode rootDeserialized = deserialize(istream);

			System.out.println("\nResult:");
			rootDeserialized.printLevelOrder();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
