package com.ankit.data.structures.hashing;

import java.util.HashSet;

/**
 * Given two lists, find the union and intersections of the lists.
 * 
 * @author ankit
 *
 */
public class Challenge9_CheckUnionIntersection {

	/*
	 * Time Complexity : O(n + m) as we traverse both the lists.
	 */
	public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();
		HashSet<T> set = new HashSet<>();
		SinglyLinkedList<T>.Node currNode = list1.getHeadNode();
		while (currNode != null) {
			if (set.add(currNode.data))
				result.insertAtEnd(currNode.data);
			currNode = currNode.nextNode;
		}
		currNode = list2.getHeadNode();
		while (currNode != null) {
			if (set.add(currNode.data))
				result.insertAtEnd(currNode.data);
			currNode = currNode.nextNode;
		}
		return result;
	}

	/*
	 * Time Complexity : O(n + m) as we traverse both the lists.
	 */
	public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1,
			SinglyLinkedList<T> list2) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();
		if (list1.isEmpty() || list2.isEmpty())
			return result;
		HashSet<T> set = new HashSet<>();
		SinglyLinkedList<T>.Node currNode = list1.getHeadNode();
		while (currNode != null) {
			set.add(currNode.data);
			currNode = currNode.nextNode;
		}
		currNode = list2.getHeadNode();
		while (currNode != null) {
			if (!set.add(currNode.data))
				result.insertAtEnd(currNode.data);
			currNode = currNode.nextNode;
		}
		return result;
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		for (int i = 7; i > 3; i--) {
			list1.insertAtHead(i);
		}
		System.out.print("1st ");
		list1.printList();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			list2.insertAtHead(i);
		}
		System.out.print("2nd ");
		list2.printList();
		System.out.print("After Intersection ");
		intersectionWithHashing(list1, list2).printList();
		System.out.print("After Union ");
		unionWithHashing(list1, list2).printList();
	}
}
