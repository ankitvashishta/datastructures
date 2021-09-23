package com.ankit.data.structures.queue;

import java.util.Stack;

public class QueueUsingStack {
	// Here we are using the stack implementation from java.util package.
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	void enqueue(int data) {
		stack1.push(data);
	}

	boolean isEmpty() {
		return stack1.size() + stack2.size() == 0;
	}

	int dequeue() {
		if (isEmpty())
			return -1;
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		  
		QueueUsingStack qs = new QueueUsingStack();

	    System.out.println("dequeue()" + " = " + qs.dequeue());
	    qs.enqueue(3);
	    qs.enqueue(6);
	    qs.enqueue(16);
	    System.out.println("dequeue()" + " = " + qs.dequeue());
	    qs.enqueue(8);
	    qs.enqueue(4);
	    System.out.println("dequeue()" + " = " + qs.dequeue());
	  } 
}