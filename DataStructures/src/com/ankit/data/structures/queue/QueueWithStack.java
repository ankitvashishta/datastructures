package com.ankit.data.structures.queue;

import com.ankit.data.structures.stack.Stack;

/**
 * Implement a queue using a built-in stack - here, we use our stack
 * implementation and not the one provided by Java.
 * 
 * In this approach, we use two stacks. The stack1 stores the queue elements
 * while the stack2 acts as a temporary buffer to provide queue functionality.
 * 
 * Time Complexity : enqueue operation takes constant time - O(1)
 * 
 * For dequeue, if stack2 is not empty, it takes O(1) time, but if ie empty, the
 * loading of elements from stack1 to stack2 takes O(n) time.
 * 
 * @author ankit
 *
 * @param <V>
 */
public class QueueWithStack<V> {

	private Stack<V> stack1;
	private Stack<V> stack2;

	public QueueWithStack(int maxSize) {
		stack1 = new Stack<V>(maxSize);
		stack2 = new Stack<V>(maxSize);
	}

	public void enqueue(V value) {
		if (!stack1.isFull())
			stack1.push(value);
	}

	public V dequeue() {
		if (!isEmpty()) {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
		return null;
	}

	public boolean isEmpty() {
		return stack1.getCurrentSize() + stack2.getCurrentSize() == 0;
	}

	public static void main(String args[]) {

		QueueWithStack<Integer> queue = new QueueWithStack<Integer>(5);

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue()); // this will output null because queue will be empty
	}
}