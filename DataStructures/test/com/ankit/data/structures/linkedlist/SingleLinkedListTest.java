package com.ankit.data.structures.linkedlist;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

	private SingleLinkedList singleLinkedList;

	@Before
	public void startUp() {
		singleLinkedList = new SingleLinkedList();
	}

	@Test
	public void testGetLength() {
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
	}

	@Test
	public void testGetHead() {
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getHead().getData());
	}

	@Test
	public void testInsertNodeAtStart() {
		SingleLinkedListNode firstNode = new SingleLinkedListNode(1);
		singleLinkedList.insertNodeAtStart(firstNode);
		Assert.assertEquals(1, singleLinkedList.getLength());
		Assert.assertTrue(singleLinkedList.getHead().equals(firstNode));
	}

	@Test
	public void testInsertNodeAtStart_Already_Initiated() {
		SingleLinkedListNode firstNode = new SingleLinkedListNode(99);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		singleLinkedList.insertNodeAtStart(firstNode);
		Assert.assertEquals(6, singleLinkedList.getLength());
		Assert.assertTrue(singleLinkedList.getHead().equals(firstNode));
	}

	@Test
	public void testInsertLastNode() {
		SingleLinkedListNode lastNode = new SingleLinkedListNode(99);
		singleLinkedList.insertNodeAtEnd(lastNode);
		Assert.assertEquals(1, singleLinkedList.getLength());
		Assert.assertTrue(singleLinkedList.getHead().equals(lastNode));
	}

	@Test
	public void testInsertLastNode_Already_Initiated() {
		SingleLinkedListNode lastNode = new SingleLinkedListNode(99);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		singleLinkedList.insertNodeAtEnd(lastNode);
		Assert.assertEquals(6, singleLinkedList.getLength());
		Assert.assertTrue(getLastNode(singleLinkedList).equals(lastNode));
	}

	@Test
	public void testInsertNodeAtPosition() {
		int position = 3;
		SingleLinkedListNode newNode = new SingleLinkedListNode(99);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		singleLinkedList.insertNodeAtPosition(position, newNode);
		Assert.assertEquals(6, singleLinkedList.getLength());
		Assert.assertEquals(getNodeAtPosition(singleLinkedList, position),
				newNode);
	}

	@Test
	public void testRemoveFromStart() {
		insertNodes(singleLinkedList);
		SingleLinkedListNode head = singleLinkedList.getHead();
		Assert.assertEquals(5, singleLinkedList.getLength());
		SingleLinkedListNode headNode = singleLinkedList.removeFromStart();
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(head, headNode);
	}

	@Test
	public void testRemoveFromEnd() {
		insertNodes(singleLinkedList);
		SingleLinkedListNode tail = getLastNode(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		SingleLinkedListNode tailNode = singleLinkedList.removeFromEnd();
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(tail, tailNode);
	}

	@Test
	public void testRemoveMatched() {
		SingleLinkedListNode node = new SingleLinkedListNode(2);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		SingleLinkedListNode matchedNode = singleLinkedList.removeMatched(node);
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(node.getData(), matchedNode.getData());
	}

	@Test
	public void testRemoveFromPosition() {
		int position = 3;
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		SingleLinkedListNode nodeAtPosition = getNodeAtPosition(
				singleLinkedList, position);
		SingleLinkedListNode removedNode = singleLinkedList
				.removeFromPosition(position);
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(nodeAtPosition.getData(), removedNode.getData());
	}

	@Test
	public void testGetPosition() {
		insertNodes(singleLinkedList);
		int position = singleLinkedList.getPosition(5);
		Assert.assertEquals(1, position);
	}

	@Test
	public void testClearList() {
		insertNodes(singleLinkedList);
		singleLinkedList.clearList();
		Assert.assertEquals(0, singleLinkedList.getLength());
	}

	private void insertNodes(SingleLinkedList singleLinkedList) {
		SingleLinkedListNode node1 = new SingleLinkedListNode(1);
		SingleLinkedListNode node2 = new SingleLinkedListNode(2);
		SingleLinkedListNode node3 = new SingleLinkedListNode(3);
		SingleLinkedListNode node4 = new SingleLinkedListNode(4);
		SingleLinkedListNode node5 = new SingleLinkedListNode(5);
		singleLinkedList.insertNodeAtStart(node1);
		singleLinkedList.insertNodeAtStart(node2);
		singleLinkedList.insertNodeAtStart(node3);
		singleLinkedList.insertNodeAtStart(node4);
		singleLinkedList.insertNodeAtStart(node5);
	}

	private SingleLinkedListNode getLastNode(SingleLinkedList singleLinkedList) {
		SingleLinkedListNode currentListNode = singleLinkedList.getHead();
		if (currentListNode != null) {
			while (currentListNode.getNext() != null) {
				currentListNode = currentListNode.getNext();
			}
		}
		return currentListNode;
	}

	private SingleLinkedListNode getNodeAtPosition(
			SingleLinkedList singleLinkedList, int position) {
		SingleLinkedListNode currentListNode = singleLinkedList.getHead();
		if (currentListNode != null) {
			while (currentListNode.getNext() != null && position > 1) {
				currentListNode = currentListNode.getNext();
				position--;
			}
		}
		return currentListNode;
	}
}
