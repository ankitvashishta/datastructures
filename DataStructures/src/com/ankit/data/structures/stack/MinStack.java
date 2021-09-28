package com.ankit.data.structures.stack;

/**
 * Create a stack where min() method gives minimum value in O(1) time. The whole
 * implementation relies on the existence of two stacks, minStack, and
 * mainStack.
 * 
 * mainStack holds the actual stack with all the elements, whereas minStack is a
 * stack whose top always contains the current minimum value in the stack.
 * 
 * @author ankit
 *
 */
public class MinStack {
	int maxSize;
	private Stack<Integer> mainStack;
	private Stack<Integer> minStack;

	public MinStack(int maxSize) {
		this.maxSize = maxSize;
		mainStack = new Stack<>(maxSize);
		minStack = new Stack<>(maxSize);
	}

	public Integer pop() {
		Integer element = mainStack.pop();
		if (element == minStack.top())
			minStack.pop();
		return element;
	}

	public void push(Integer value) {
		mainStack.push(value);
		if (minStack.isEmpty() || value <= minStack.top())
			minStack.push(value);
	}

	// returns minimum value in O(1)
	public int min() {
		return minStack.top();
	}

	public static void main(String args[]) {

		MinStack stack = new MinStack(6);
		stack.push(5);
		stack.push(2);
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(9);

		System.out.println(stack.min());

		stack.pop();
		stack.pop();
		stack.pop();

		System.out.println(stack.min());

	}
}