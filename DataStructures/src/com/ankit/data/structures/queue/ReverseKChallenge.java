package com.ankit.data.structures.queue;

import com.ankit.data.structures.stack.Stack;

/**
 * Reverse the first "k" elements in a given queue
 * 
 * Example : Queue = {1,2,3,4,5,6,7,8,9,10}, k = 5
 * 
 * result = {5,4,3,2,1,6,7,8,9,10}
 * 
 * @author ankit
 *
 */
public class ReverseKChallenge {

	/*
	 * 1.Push first k elements in queue in a stack. 2.Pop Stack elements and enqueue
	 * them at the end of queue 3.Dequeue the 'queueSize - k' queue elements and
	 * append them at the end of queue
	 * 
	 * Time Complexity : O(n) where n is the size of the queue. Each push, pop,
	 * enqueue, or dequeue operation takes constant time; all n elements have to be
	 * processed with constant-time​ operations.
	 */
	public static <V> void reverseK(Queue<V> queue, int k) {
		int currSize = queue.getCurrentSize();
		int counter = k;
		Stack<V> tempStack = new Stack<V>(k);
		while (counter > 0) {
			tempStack.push(queue.dequeue());
			counter--;
		}
		while (!tempStack.isEmpty()) {
			queue.enqueue(tempStack.pop());
		}
		while (currSize > k) {
			queue.enqueue(queue.dequeue());
			currSize--;
		}
	}

	public static void main(String args[]) {

		Queue<Integer> queue = new Queue<Integer>(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);

		reverseK(queue, 5);

		System.out.print("Queue: ");
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
	}
}