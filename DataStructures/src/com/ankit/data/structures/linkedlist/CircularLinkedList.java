package com.ankit.data.structures.linkedlist;

public class CircularLinkedList {

	private CLLNode tail;

	private int length;

	public CircularLinkedList() {
		tail = null;
		length = 0;
	}
	
	/**
	 * Retrieves the last node of the list.
	 * @return
	 */
	public CLLNode getTail() {
		return tail;
	}

	/**
	 * Adds a new node to the starting of the list.
	 * 
	 * @param newNode
	 */
	public void add(CLLNode newNode) {
		addToHead(newNode);
	}

	/**
	 * Adds a new node to the head of the the list.
	 * 
	 * @param newNode
	 */
	public void addToHead(CLLNode newNode) {
		if (tail == null) {
			newNode.setNext(newNode);
			tail = newNode;
		} else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		length++;
	}

	/**
	 * Adds a new node to the end of the list.
	 * 
	 * @param newNode
	 */
	public void addToTail(CLLNode newNode) {
		addToHead(newNode);
		tail = tail.getNext();
	}

	/**
	 * Removes the node from the starting of the list.
	 * 
	 * @return
	 */
	public CLLNode removeFromHead() {
		if (tail != null) {
			CLLNode temp = tail.getNext();
			if (tail == tail.getNext()) {
				tail = null;
			} else {
				tail.setNext(temp.getNext());
				temp.setNext(null);
			}
			length--;
			return temp;
		}
		return null;
	}

	/**
	 * Removes and returns the node from the end of the list.
	 * 
	 * @return
	 */
	public CLLNode removeFromTail() {
		CLLNode finger = null;
		if (tail != null) {
			finger = tail;
			CLLNode temp = tail.getNext();
			while (temp.getNext() != tail) {
				temp = temp.getNext();
			}
			if (temp == tail) {
				tail = null;
			} else {
				temp.setNext(tail.getNext());
				tail = temp;
			}
			length--;
			return finger;
		}
		return null;
	}

	/**
	 * Finds the node(if exists) in the list containing the same data.
	 * 
	 * @param data
	 * @return
	 */
	public boolean contains(int data) {
		if (tail != null) {
			CLLNode temp = tail;
			while (temp.getNext() != tail && temp.getData() != data) {
				temp = temp.getNext();
			}
			return temp.getData() == data;
		}
		return false;
	}

	/**
	 * Finds the node(if exists) in the list, removes and returns it.
	 * 
	 * @param data
	 * @return
	 */
	public CLLNode remove(int data) {
		if (tail != null) {
			CLLNode temp = tail.getNext();
			CLLNode finger = tail;
			while (temp.getNext() != tail && temp.getData() != data) {
				finger = finger.getNext();
				temp = temp.getNext();
			}
			if (temp.getData() == data) {
				length--;
				if (tail == tail.getNext()) {
					tail = null;
				} else if (temp == tail) {
					tail = finger;
				}
				finger.setNext(temp.getNext());
				temp.setNext(null);
				return temp;
			}
		}
		return null;
	}

	/**
	 * Returns the length of the list.
	 * 
	 * @return int.
	 */
	public int length() {
		return length;
	}

	/**
	 * Verifies if the list is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return tail == null;
	}

	/**
	 * Empties the list, and re - initializes the instance variables.
	 */
	public void clear() {
		length = 0;
		tail = null;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		if (tail == null) {
			result.append("]");
			return result.toString();
		}
		CLLNode startingNode = tail.getNext();
		result.append(startingNode.getData());
		CLLNode temp = startingNode.getNext();
		while (temp != null && temp != startingNode) {
			result.append(", " + temp.getData());
			temp = temp.getNext();
		}
		result.append("]");
		return result.toString();
	}

}
