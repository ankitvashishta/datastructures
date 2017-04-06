package com.ankit.data.structures.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {

	private DoubleLinkedList doubleLinkedList;

	@Before
	public void startUp() {
		doubleLinkedList = new DoubleLinkedList();
	}

	@Test
	public void testLength() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
	}

	@Test
	public void testGetHead() {
		insertNodes(doubleLinkedList);
		DLLNode node5 = new DLLNode(5);
		Assert.assertEquals(5, doubleLinkedList.length());
		Assert.assertEquals(node5, doubleLinkedList.getHead());
	}

	@Test
	public void testGetPosition() {
		int position = 3;
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		Assert.assertEquals(position, doubleLinkedList.getPosition(3));
	}

	@Test
	public void testInsertAtBegin() {
		DLLNode newNode = new DLLNode(1);
		doubleLinkedList.insertAtBegin(newNode);
		Assert.assertEquals(1, doubleLinkedList.length());
		Assert.assertEquals(newNode, doubleLinkedList.getHead());
	}

	@Test
	public void testInsertAtBegin_Already_Initiated() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode newNode = new DLLNode(99);
		doubleLinkedList.insertAtBegin(newNode);
		Assert.assertEquals(6, doubleLinkedList.length());
		Assert.assertEquals(99, doubleLinkedList.getHead().getData());
	}

	@Test
	public void testInsertAtEnd() {
		DLLNode newNode = new DLLNode(99);
		doubleLinkedList.insertAtEnd(newNode);
		Assert.assertEquals(1, doubleLinkedList.length());
		Assert.assertEquals(99, getLastNode(doubleLinkedList).getData());
	}

	@Test
	public void testInsertAtEnd_Already_Initiated() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode newNode = new DLLNode(99);
		doubleLinkedList.insertAtEnd(newNode);
		Assert.assertEquals(6, doubleLinkedList.length());
		Assert.assertEquals(99, getLastNode(doubleLinkedList).getData());
	}

	@Test
	public void testInsertAtPosition() {
		int position = 4;
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode newNode = new DLLNode(99);
		doubleLinkedList.insertAtPosition(newNode, position);
		Assert.assertEquals(6, doubleLinkedList.length());
		Assert.assertEquals(99, getNodeAtPosition(doubleLinkedList, position)
				.getData());
	}

	@Test
	public void testRemoveFromStart() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode nodeRemoved = doubleLinkedList.removeFromStart();
		Assert.assertEquals(5, nodeRemoved.getData());
	}

	@Test
	public void testRemoveFromEnd() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode lastNode = getLastNode(doubleLinkedList);
		DLLNode nodeRemoved = doubleLinkedList.removeFromEnd();
		Assert.assertEquals(lastNode, nodeRemoved);
	}

	@Test
	public void testRemoveFromPosition() {
		int position = 3;
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode nodeToBeRemoved = getNodeAtPosition(doubleLinkedList, position);
		DLLNode nodeRemoved = doubleLinkedList.removeFromPosition(position);
		Assert.assertEquals(4, doubleLinkedList.length());
		Assert.assertEquals(nodeToBeRemoved, nodeRemoved);
	}

	@Test
	public void testRemoveMatched() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		DLLNode nodeToBeRemoved = new DLLNode(3);
		DLLNode nodeRemoved = doubleLinkedList.removeMatched(nodeToBeRemoved);
		Assert.assertEquals(4, doubleLinkedList.length());
		Assert.assertEquals(nodeToBeRemoved, nodeRemoved);
	}

	@Test
	public void testClearList() {
		insertNodes(doubleLinkedList);
		Assert.assertEquals(5, doubleLinkedList.length());
		doubleLinkedList.clearList();
		Assert.assertEquals(0, doubleLinkedList.length());
		Assert.assertEquals(null, doubleLinkedList.getHead());
	}

	private void insertNodes(DoubleLinkedList doubleLinkedList) {
		DLLNode node1 = new DLLNode(1);
		DLLNode node2 = new DLLNode(2);
		DLLNode node3 = new DLLNode(3);
		DLLNode node4 = new DLLNode(4);
		DLLNode node5 = new DLLNode(5);
		doubleLinkedList.insertAtBegin(node1);
		doubleLinkedList.insertAtBegin(node2);
		doubleLinkedList.insertAtBegin(node3);
		doubleLinkedList.insertAtBegin(node4);
		doubleLinkedList.insertAtBegin(node5);
	}

	private DLLNode getLastNode(DoubleLinkedList doubleLinkedList) {
		DLLNode currentNode = doubleLinkedList.getHead();
		if (currentNode != null) {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			return currentNode;
		}
		return null;
	}

	private DLLNode getNodeAtPosition(DoubleLinkedList doubleLinkedList,
			int position) {
		DLLNode currentNode = doubleLinkedList.getHead();
		if (currentNode != null) {
			while (currentNode.getNext() != null && position > 1) {
				currentNode = currentNode.getNext();
				position--;
			}
			return currentNode;
		}
		return null;
	}

}
