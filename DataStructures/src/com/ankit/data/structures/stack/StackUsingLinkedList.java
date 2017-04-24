package com.ankit.data.structures.stack;

import com.ankit.data.structures.linkedlist.SingleLinkedListNode;

public class StackUsingLinkedList {

	private int stackLength;
	private SingleLinkedListNode top;


	public StackUsingLinkedList() {
		stackLength = 0;
	}

	public void push(int i) {
		SingleLinkedListNode node = new SingleLinkedListNode(i);
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
