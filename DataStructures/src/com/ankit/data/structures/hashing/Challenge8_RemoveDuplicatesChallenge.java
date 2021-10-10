package com.ankit.data.structures.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a SnglyLinkedList, remove the duplicate elements.
 * 
 * Example : linkedlist = 7->14->21->14->22->null
 * 
 * Output : linkedlist = 7->14->21->22->null
 * 
 * @author ankit
 * 
 * @param <V>
 * @param list
 */
public class Challenge8_RemoveDuplicatesChallenge {

	/*
	 * Time Complexity : O(n) as we traverse the whole list.
	 * 
	 * Space Complexity : O(n) as we store the data in a hash set.
	 */
	public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
		SinglyLinkedList<V>.Node head = list.getHeadNode();
		SinglyLinkedList<V>.Node prevNode = head;
		SinglyLinkedList<V>.Node currNode = head.nextNode;
		Set<V> set = new HashSet<>();
		set.add(prevNode.data);
		while (currNode != null) {
			if (set.add(currNode.data)) {
				prevNode.nextNode = currNode;
				prevNode = currNode;
				currNode = currNode.nextNode;
			} else {
				currNode = currNode.nextNode;
			}
		}
		prevNode.nextNode = null;
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

		for (int i = 1; i <= 8; i++) {
			list.insertAtHead(i); // inserting data in list
		}
		// inserting duplicates
		list.insertAtHead(2);
		list.insertAtHead(4);
		list.insertAtHead(1);

		System.out.println("List before deleting duplicates from list :");
		list.printList();
		removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
		System.out.println("List after deleting duplicates from list :");
		list.printList();
	}

}
