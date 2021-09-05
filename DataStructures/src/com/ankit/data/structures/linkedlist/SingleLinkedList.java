package com.ankit.data.structures.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class SingleLinkedList<T> {

	private Node<T> head;
	private int length;

	public SingleLinkedList() {
		length = 0;
	}

	public int getLength() {
		return length;
	}

	public Node<T> getHead() {
		return head;
	}

	/**
	 * Inserts a new node at the starting of the list.
	 * 
	 * @param newNode
	 */
	public void insertNodeAtStart(Node<T> newNode) {
		newNode.setNext(head);
		head = newNode;
		length++;
	}

	/**
	 * Inserts new node at the end of the list.
	 * 
	 * @param newNode
	 */
	public void insertNodeAtEnd(Node<T> newNode) {
		Node<T> currentNode = head;
		if (head == null) {
			head = newNode;
		} else {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
		length++;
	}

	/**
	 * Inserts a new node at given position. The position is relative and does not
	 * starts indexing with zero.
	 * 
	 * @param position
	 * @param newNode
	 */
	public void insertNodeAtPosition(int position, Node<T> newNode) {
		Node<T> currentNode = head;
		if (position <= 1) {
			position = 1;
			insertNodeAtStart(newNode);
			return;
		} else if (position > length + 1) {
			position = length + 1;
		}
		if (head == null) {
			head = newNode;
		} else {
			while (currentNode.getNext() != null && --position > 1) {
				currentNode = currentNode.getNext();
			}
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		}
		length++;
	}

	/**
	 * Removes the starting node of the list.
	 * 
	 * @return
	 */
	public Node<T> removeFromStart() {
		Node<T> currentNode = head;
		if (head == null) {
			return null;
		}
		head = currentNode.getNext();
		length--;
		currentNode.setNext(null);
		return currentNode;
	}

	/**
	 * Removes the last node of the list.
	 */
	public Node<T> removeFromEnd() {
		Node<T> currentNode = head;
		if (head == null) {
			return null;
		}
		while (currentNode.getNext().getNext() != null) {
			currentNode = currentNode.getNext();
		}
		Node<T> temp = currentNode.getNext();
		currentNode.setNext(null);
		length--;
		return temp;
	}

	/**
	 * Removes the matching node.
	 * 
	 * @param node
	 */
	public Node<T> removeMatched(Node<T> node) {
		Node<T> currentNode = head;
		Node<T> temp = head;
		if (head == null) {
			return null;
		}
		if (head.getData() == node.getData()) {
			Node<T> matchedNode = removeFromStart();
			return matchedNode;
		}
		while (temp.getNext() != null) {
			currentNode = temp.getNext();

			if (currentNode.getData() == node.getData()) {
				temp.setNext(currentNode.getNext());
				length--;
				return currentNode;
			}
			temp = temp.getNext();
		}
		return null;

	}

	/**
	 * Checks if there exists a loop in the single linked list.
	 * 
	 * @return if loop exists : boolean.
	 */
	public boolean detectLoop() {
		Node<T> slowerNode = this.getHead();
		Node<T> fasterNode = this.getHead().getNext();

		while (fasterNode != null && fasterNode.getNext() != null) {
			if (fasterNode.getData() == slowerNode.getData())
				return true;
			slowerNode = slowerNode.getNext();
			fasterNode = fasterNode.getNext().getNext();
		}
		return false;
	}

	/**
	 * Finds the middle node of the list.
	 * 
	 * @return data of the middle node.
	 */
	public T getMidOfList() {
		Node<T> slowerNode = this.getHead();
		Node<T> fasterNode = this.getHead();

		while (fasterNode != null && fasterNode.getNext() != null) {
			fasterNode = fasterNode.getNext().getNext();
			if (fasterNode != null)
				slowerNode = slowerNode.getNext();
		}
		return slowerNode.getData();
	}

	/**
	 * Remove the duplicates from the Single Linked List.
	 * 
	 * Runtime Complexity: O(n)
	 * 
	 * Space Complexity: O(n) as we use a set to store data.
	 */
	public void removeDuplicates() {

		if (this.getHead() == null)
			return;

		Set<T> nodeSet = new HashSet<T>();
		Node<T> currNode = this.getHead();
		Node<T> nextNode = currNode.getNext();

		nodeSet.add(currNode.getData());

		while (nextNode != null) {
			boolean isUnique = nodeSet.add(nextNode.getData());
			if (!isUnique) {
				currNode.setNext(nextNode.getNext());
				nextNode = currNode.getNext();
				length--;
			} else {
				currNode = nextNode;
				nextNode = currNode.getNext();
			}
		}
	}

	/**
	 * Removes the node at given position.
	 * 
	 * @param position
	 * @return
	 */
	public Node<T> removeFromPosition(int position) {
		Node<T> currentNode = null;
		Node<T> temp = head;
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
			while (temp.getNext() != null && --position > 1) {
				temp = temp.getNext();
			}
			currentNode = temp.getNext();
			temp.setNext(currentNode.getNext());
			currentNode.setNext(null);
		}
		length--;
		return currentNode;
	}

	/**
	 * Retrieves the position of a given node.
	 * 
	 * @param data
	 * @return
	 */
	public int getPosition(T data) {
		Node<T> currentNode = head;
		int position = -1;
		if (head == null) {
			return position;
		}
		position = 1;
		while (currentNode != null) {
			if (currentNode.getData() == data) {
				return position;
			}
			currentNode = currentNode.getNext();
			position++;
		}
		position = -1;
		return position;
	}

	/**
	 * Clears the list. And Resets the fields.
	 */
	public void clearList() {
		head = null;
		length = 0;
	}

	/**
	 * Override the toString method of object class.
	 */
	@Override
	public String toString() {
		StringBuffer strBuffer = new StringBuffer("[ ");
		Node<T> currentNode;
		if (head == null) {
			strBuffer.append("]");
			return strBuffer.toString();
		}
		strBuffer.append(head.getData());
		currentNode = head.getNext();
		if (currentNode != null) {
			while (currentNode != null) {
				strBuffer.append(", " + currentNode.getData());
				currentNode = currentNode.getNext();
			}
		}

		strBuffer.append("]");
		return strBuffer.toString();
	}

}
