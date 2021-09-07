package com.ankit.data.structures.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

	private SingleLinkedList<Integer> singleLinkedList;

	@Before
	public void startUp() {
		singleLinkedList = new SingleLinkedList<Integer>();
	}

	@Test
	public void testGetLength() {
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
	}

	@Test
	public void testGetHead() {
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getHead().getData().intValue());
	}
	
	@Test
	public void testGetElementAtPosition() {
		insertNodes(singleLinkedList);
		Integer data = singleLinkedList.getElementAtPosition(1);
		assertEquals(singleLinkedList.getHead().getData(), data);
	}
	
	@Test
	public void testGetElementAtPositionFromEnd() {
		insertNodes(singleLinkedList);
		Integer data = singleLinkedList.getElementAtPositionFromEnd(5);
		assertEquals(singleLinkedList.getHead().getData(), data);
	}
	

	@Test
	public void testInsertNodeAtStart() {
		Node<Integer> firstNode = new Node<Integer>(1);
		singleLinkedList.insertNodeAtStart(firstNode);
		Assert.assertEquals(1, singleLinkedList.getLength());
		Assert.assertTrue(singleLinkedList.getHead().equals(firstNode));
	}

	@Test
	public void testInsertNodeAtStart_Already_Initiated() {
		Node<Integer> firstNode = new Node<Integer>(99);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		singleLinkedList.insertNodeAtStart(firstNode);
		Assert.assertEquals(6, singleLinkedList.getLength());
		Assert.assertTrue(singleLinkedList.getHead().equals(firstNode));
	}

	@Test
	public void testInsertLastNode() {
		Node<Integer> lastNode = new Node<Integer>(99);
		singleLinkedList.insertNodeAtEnd(lastNode);
		Assert.assertEquals(1, singleLinkedList.getLength());
		Assert.assertTrue(singleLinkedList.getHead().equals(lastNode));
	}

	@Test
	public void testInsertLastNode_Already_Initiated() {
		Node<Integer> lastNode = new Node<Integer>(99);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		singleLinkedList.insertNodeAtEnd(lastNode);
		Assert.assertEquals(6, singleLinkedList.getLength());
		Assert.assertTrue(getLastNode(singleLinkedList).equals(lastNode));
	}

	@Test
	public void testInsertNodeAtPosition() {
		int position = 3;
		Node<Integer> newNode = new Node<Integer>(99);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		singleLinkedList.insertNodeAtPosition(position, newNode);
		Assert.assertEquals(6, singleLinkedList.getLength());
		Assert.assertEquals(getNodeAtPosition(singleLinkedList, position), newNode);
	}

	@Test
	public void testRemoveFromStart() {
		insertNodes(singleLinkedList);
		Node<Integer> head = singleLinkedList.getHead();
		Assert.assertEquals(5, singleLinkedList.getLength());
		Node<Integer> headNode = singleLinkedList.removeFromStart();
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(head, headNode);
	}

	@Test
	public void testRemoveFromEnd() {
		insertNodes(singleLinkedList);
		Node<Integer> tail = getLastNode(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		Node<Integer> tailNode = singleLinkedList.removeFromEnd();
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(tail, tailNode);
	}

	@Test
	public void testRemoveMatched() {
		Node<Integer> node = new Node<Integer>(2);
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		Node<Integer> matchedNode = singleLinkedList.removeMatched(node);
		Assert.assertEquals(4, singleLinkedList.getLength());
		Assert.assertEquals(node.getData(), matchedNode.getData());
	}

	@Test
	public void testDetectLoop() {
		insertNodes(singleLinkedList);
		Assert.assertEquals(false, singleLinkedList.detectLoop());
	}

	@Test
	public void testGetMidOfList() {
		insertNodes(singleLinkedList);
		Assert.assertEquals(3, singleLinkedList.getMidOfList().intValue());
	}

	@Test
	public void testRemoveDuplicates() {
		insertNodes_Duplicates(singleLinkedList);
		Assert.assertEquals(6, singleLinkedList.getLength());
		singleLinkedList.removeDuplicates();
		Assert.assertEquals(5, singleLinkedList.getLength());
	}

	@Test
	public void testRemoveFromPosition() {
		int position = 3;
		insertNodes(singleLinkedList);
		Assert.assertEquals(5, singleLinkedList.getLength());
		Node<Integer> nodeAtPosition = getNodeAtPosition(singleLinkedList, position);
		Node<Integer> removedNode = singleLinkedList.removeFromPosition(position);
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
	
	@Test
	public void testUnion() {
		SingleLinkedList<Integer> list1 = new SingleLinkedList<Integer>();
		list1.insertNodeAtStart(new Node<Integer>(8));
		list1.insertNodeAtStart(new Node<Integer>(7));
		list1.insertNodeAtStart(new Node<Integer>(6));
		list1.insertNodeAtStart(new Node<Integer>(4));
		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		list2.insertNodeAtStart(new Node<Integer>(1));
		list2.insertNodeAtStart(new Node<Integer>(2));
		list2.insertNodeAtStart(new Node<Integer>(3));
		list2.insertNodeAtStart(new Node<Integer>(4));
		SingleLinkedList<Integer> result = singleLinkedList.union(list1, list2);
		assertEquals(7, result.getLength());
	}
	
	@Test
	public void testCommonDataNodes() {
		SingleLinkedList<Integer> list1 = new SingleLinkedList<Integer>();
		list1.insertNodeAtStart(new Node<Integer>(8));
		list1.insertNodeAtStart(new Node<Integer>(7));
		list1.insertNodeAtStart(new Node<Integer>(6));
		list1.insertNodeAtStart(new Node<Integer>(4));
		SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
		list2.insertNodeAtStart(new Node<Integer>(1));
		list2.insertNodeAtStart(new Node<Integer>(2));
		list2.insertNodeAtStart(new Node<Integer>(3));
		list2.insertNodeAtStart(new Node<Integer>(4));
		SingleLinkedList<Integer> result = singleLinkedList.commonDataNodes(list1, list2);
		assertEquals(1, result.getLength());
	}
	
	@Test
	public void testIntersection() {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		Node<Integer> node7 = new Node<Integer>(7);
		Node<Integer> node8 = new Node<Integer>(8);
		Node<Integer> node9 = new Node<Integer>(9);
		node7.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node4);
		Node<Integer> intersectingNode = singleLinkedList.intersection(node1, node7);
		assertEquals(node4, intersectingNode);
	}
	
	@Test
	public void testRotateList() {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		Node<Integer> rotatedHeadNode = singleLinkedList.rotateList(node1, 2);
		assertEquals(node4, rotatedHeadNode);
	}

	private void insertNodes(SingleLinkedList<Integer> singleLinkedList) {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		singleLinkedList.insertNodeAtStart(node1);
		singleLinkedList.insertNodeAtStart(node2);
		singleLinkedList.insertNodeAtStart(node3);
		singleLinkedList.insertNodeAtStart(node4);
		singleLinkedList.insertNodeAtStart(node5);
	}

	private void insertNodes_Duplicates(SingleLinkedList<Integer> singleLinkedList) {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(3);
		singleLinkedList.insertNodeAtStart(node1);
		singleLinkedList.insertNodeAtStart(node2);
		singleLinkedList.insertNodeAtStart(node3);
		singleLinkedList.insertNodeAtStart(node4);
		singleLinkedList.insertNodeAtStart(node6);
		singleLinkedList.insertNodeAtStart(node5);
	}

	private Node<Integer> getLastNode(SingleLinkedList<Integer> singleLinkedList) {
		Node<Integer> currentListNode = singleLinkedList.getHead();
		if (currentListNode != null) {
			while (currentListNode.getNext() != null) {
				currentListNode = currentListNode.getNext();
			}
		}
		return currentListNode;
	}

	private Node<Integer> getNodeAtPosition(SingleLinkedList<Integer> singleLinkedList, int position) {
		Node<Integer> currentListNode = singleLinkedList.getHead();
		if (currentListNode != null) {
			while (currentListNode.getNext() != null && position > 1) {
				currentListNode = currentListNode.getNext();
				position--;
			}
		}
		return currentListNode;
	}
}
