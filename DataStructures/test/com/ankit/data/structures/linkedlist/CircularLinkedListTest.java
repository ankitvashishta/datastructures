package com.ankit.data.structures.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircularLinkedListTest {
	
	private CircularLinkedList circularLinkedList;
	
	
	@Before
	public void setUp(){
		circularLinkedList = new CircularLinkedList();
	}

	@Test
	public void testAdd() {
		CLLNode newNode = new CLLNode(1);
		circularLinkedList.add(newNode);
		Assert.assertEquals(1, circularLinkedList.length());
		Assert.assertEquals(newNode, circularLinkedList.getTail());
		Assert.assertEquals(newNode, circularLinkedList.getTail().getNext());
	}

	@Test
	public void testAddToHead() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		CLLNode newNode = new CLLNode(99);
		circularLinkedList.addToHead(newNode);
		Assert.assertEquals(6, circularLinkedList.length());
		Assert.assertEquals(newNode, circularLinkedList.getTail().getNext());
	}

	@Test
	public void testAddToTail() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		CLLNode newNode = new CLLNode(99);
		circularLinkedList.addToTail(newNode);
		Assert.assertEquals(6, circularLinkedList.length());
		Assert.assertEquals(newNode, circularLinkedList.getTail());
	}

	@Test
	public void testRemoveFromHead() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		CLLNode nodeToBeRemoved = circularLinkedList.getTail().getNext();
		CLLNode nodeRemoved = circularLinkedList.removeFromHead();
		Assert.assertEquals(4, circularLinkedList.length());
		Assert.assertEquals(nodeToBeRemoved, nodeRemoved);
		Assert.assertEquals(5, nodeRemoved.getData());
	}

	@Test
	public void testRemoveFromTail() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		CLLNode nodeToBeRemoved = circularLinkedList.getTail();
		CLLNode nodeRemoved = circularLinkedList.removeFromTail();
		Assert.assertEquals(4, circularLinkedList.length());
		Assert.assertEquals(nodeToBeRemoved, nodeRemoved);
		Assert.assertEquals(1, nodeRemoved.getData());
	}

	@Test
	public void testContains() {
		int dataToBeVerified = 3;
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		boolean isContains = circularLinkedList.contains(dataToBeVerified);
		Assert.assertTrue(isContains);
	}

	@Test
	public void testRemove() {
		int dataToBeRemoved = 3;
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		CLLNode nodeRemoved = circularLinkedList.remove(dataToBeRemoved);
		Assert.assertEquals(4, circularLinkedList.length());
		Assert.assertEquals(dataToBeRemoved, nodeRemoved.getData());
	}

	@Test
	public void testLength() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
	}

	@Test
	public void testIsEmpty() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		Assert.assertFalse(circularLinkedList.isEmpty());
	}

	@Test
	public void testClear() {
		insertNodes(circularLinkedList);
		Assert.assertEquals(5, circularLinkedList.length());
		circularLinkedList.clear();
		Assert.assertEquals(0, circularLinkedList.length());
		Assert.assertNull(circularLinkedList.getTail());
	}
	
	private CircularLinkedList insertNodes(CircularLinkedList circularLinkedList){
		CLLNode node1 = new CLLNode(1);
		CLLNode node2 = new CLLNode(2);
		CLLNode node3 = new CLLNode(3);
		CLLNode node4 = new CLLNode(4);
		CLLNode node5 = new CLLNode(5);
		circularLinkedList.add(node1);
		circularLinkedList.add(node2);
		circularLinkedList.add(node3);
		circularLinkedList.add(node4);
		circularLinkedList.add(node5);
		return circularLinkedList;
	}

}
