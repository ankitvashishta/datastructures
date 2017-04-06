package com.ankit.data.structures.linkedlist;

public class DoubleLinkedList {

	private DLLNode head;
	private DLLNode tail;
	private int length;

	/**
	 * No - arg constructor. Initializes all the instance variables.
	 */
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		length = 0;
	}

	/**
	 * Returns the length of the list.
	 * 
	 * @return
	 */
	public int length() {
		return this.length;
	}

	/**
	 * Returns the starting node of the list.
	 * 
	 * @return
	 */
	public DLLNode getHead() {
		return head;
	}

	/**
	 * Retrieves the position of the node containing the data.
	 * 
	 * @param data
	 * @return
	 */
	public int getPosition(int data) {
		DLLNode temp = head;
		int position = 1;
		while (temp != null) {
			if (temp.getData() != data) {
				temp = temp.getNext();
				position++;
			} else {
				return position;
			}
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * Inserts a new node at the beginning of the list.
	 * 
	 * @param newNode
	 */
	public void insertAtBegin(DLLNode newNode) {
		if (head == null) {
			head = newNode;
		} else {
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
			if (tail == null) {
				tail = newNode.getNext();
			}
		}
		length++;
	}

	/**
	 * Inserts a new node at the end of the list.
	 * 
	 * @param newNode
	 */
	public void insertAtEnd(DLLNode newNode) {
		if (head == null) {
			head = newNode;
		} else if (tail == null) {
			head.setNext(newNode);
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}

		length++;
	}

	/**
	 * Inserts a new node at the given position of the list.
	 * 
	 * @param newNode
	 * @param position
	 */
	public void insertAtPosition(DLLNode newNode, int position) {
		DLLNode currentNode = head;
		if (position <= 1) {
			position = 1;
			insertAtBegin(newNode);
			return;
		} else if (position > length + 1) {
			position = length + 1;
			insertAtEnd(newNode);
			return;
		}
		if (head == null) {
			head = newNode;
		} else {
			while (currentNode.getNext() != null && --position > 1) {
				currentNode = currentNode.getNext();
			}
			newNode = new DLLNode(newNode.getData(), currentNode,
					currentNode.getNext());
			currentNode.setNext(newNode);
			if (newNode.getNext() != null) {
				newNode.getNext().setPrev(newNode);
			}
			if (tail == null) {
				tail = newNode.getNext();
			}
		}
		length++;
	}

	/**
	 * Removes and returns the starting node of the list.
	 * 
	 * @return
	 */
	public DLLNode removeFromStart() {
		if (head == null) {
			return null;
		}
		DLLNode currentNode = head;
		currentNode.getNext().setPrev(null);
		head = currentNode.getNext();
		currentNode.setNext(null);
		length--;
		return currentNode;
	}

	/**
	 * Removes and returns the last node of the list.
	 * 
	 * @return
	 */
	public DLLNode removeFromEnd() {
		if (head == null) {
			return null;
		} else if (tail == null) {
			length--;
			return head;
		}
		DLLNode temp = tail;
		tail = temp.getPrev();
		tail.setNext(null);
		length--;
		return temp;
	}

	/**
	 * Removes and returns the node at given position in the list.
	 * 
	 * @param position
	 * @return
	 */
	public DLLNode removeFromPosition(int position) {
		DLLNode currentNode = head;
		if (position <= 1) {
			position = 1;
			return removeFromStart();
		} else if (position >= length) {
			position = length;
			return removeFromEnd();
		}
		if (head == null) {
			return null;
		} else {
			while (currentNode.getNext() != null && position > 1) {
				currentNode = currentNode.getNext();
				position--;
			}
			currentNode.getPrev().setNext(currentNode.getNext());
			currentNode.getNext().setPrev(currentNode.getPrev());
			currentNode.setNext(null);
			currentNode.setPrev(null);
			length--;
			return currentNode;
		}
	}

	/**
	 * Removes and returns the matching node in the list.
	 * 
	 * @param node
	 * @return
	 */
	public DLLNode removeMatched(DLLNode node) {
		DLLNode currentNode = head;
		if (head == null) {
			return null;
		}
		if (head.equals(node)) {
			return removeFromStart();
		} else if (tail.equals(node)) {
			return removeFromEnd();
		}
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();

			if (currentNode.equals(node)) {
				currentNode.getPrev().setNext(currentNode.getNext());
				currentNode.getNext().setPrev(currentNode.getPrev());
				length--;
				return currentNode;
			}
		}
		return null;
	}

	/**
	 * Clears the list and re initializes all the parameters.
	 */
	public void clearList() {
		head = null;
		tail = null;
		length = 0;
	}

	public String toString() {
		StringBuffer strBuffer = new StringBuffer("[ ");
		DLLNode currentNode;
		if (head == null) {
			strBuffer.append("]");
			return strBuffer.toString();
		}
		strBuffer.append(head.getData());
		currentNode = head.getNext();
		while (currentNode != null) {
			strBuffer.append(", " + currentNode.getData());
			currentNode = currentNode.getNext();
		}
		strBuffer.append("]");
		return strBuffer.toString();
	}

}
