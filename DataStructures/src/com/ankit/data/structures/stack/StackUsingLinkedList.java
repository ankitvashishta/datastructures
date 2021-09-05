package com.ankit.data.structures.stack;

import com.ankit.data.structures.linkedlist.Node;

public class StackUsingLinkedList {

	private int stackLength;
	private Node top;


	public StackUsingLinkedList() {
		stackLength = 0;
	}

	public void push(int i) {
		Node node = new Node(i);
		if (stackLength == 0) {
			this.top = node;
		} else {
			node.setNext(top);
			top = node;
		}
	}
	
	/*public int pop(){
		if
	}*/

}
