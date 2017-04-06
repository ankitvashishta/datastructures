package com.ankit.data.structures.linkedlist;

public class DLLNode {

	private int data;
	private DLLNode prev;
	private DLLNode next;

	public DLLNode(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public DLLNode(int data, DLLNode prev, DLLNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o != null && o instanceof DLLNode) {
			DLLNode node = (DLLNode) o;
			if (this.getData() == node.getData()) {
				isEqual = true;
			} else {
				isEqual = false;
			}
		}
		return isEqual;
	}

}
