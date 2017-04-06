package com.ankit.data.structures.trees.bst;

import java.util.ArrayList;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] testArray = { 12, 5, 18, 2, 9, 15, 12, 19, 13, 17 };
		for (int i : testArray) {
			bst = bst.insert(bst, i);
		}
		System.out.println(bst);
		System.out.println(bst.inorderTraversal(new ArrayList<Integer>(),
				bst.root));
		//System.out.println(bst.treeSearch(11, bst.root).parent.key);
		
		System.out.println(bst.treeMinimum(bst.root).key);
		System.out.println(bst.treeMaximum(bst.root).key);
		
		System.out.println(bst.treeSuccessor(bst.treeSearch(2, bst.root)).key);
		
		System.out.println(bst.treePredecessor(bst.treeSearch(19, bst.root)).key);

	}

}
