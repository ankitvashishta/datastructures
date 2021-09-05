package com.ankit.data.structures.linkedlist;


public class SingleLinkedListNode {

	private int data;
	private SingleLinkedListNode next;

	public SingleLinkedListNode(int data){
		this.data = data;
	}
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SingleLinkedListNode getNext() {
		return next;
	}

	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}

}
