package com.ankit.data.structures.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
	// Here we are using the Queue implementation from java.util package.
	Queue<Integer> queue1 = new ArrayDeque<Integer>();
	Queue<Integer> queue2 = new ArrayDeque<Integer>();

	void push(int data) {
		queue1.offer(data);
	}

	boolean isEmpty() {
		return queue1.size() + queue2.size() == 0;
	}

	int pop() {
		if (isEmpty())
			return -1;
		if (queue1.isEmpty()) {
			while (queue2.size() > 1)
				queue1.offer(queue2.poll());
			return queue2.poll();
		} else {
			while (queue1.size() > 1)
				queue2.offer(queue1.poll());
			return queue1.poll();
		}
	}

	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		System.out.println("Pop(): " + sq.pop());
		sq.push(3);
		sq.push(5);
		sq.push(9);
		System.out.println("Pop(): " + sq.pop());
		sq.push(10);
		sq.push(16);
		System.out.println("Pop(): " + sq.pop());
	}
}
