package com.ankit.data.structures.stack;

import java.util.Arrays;

class StackUsingArray {

	private int[] arr;
	private float loadFactor;
	private int stackLength;

	public StackUsingArray() {
		this.arr = new int[10];
		this.loadFactor = 1.6f;
		stackLength = 0;
	}

	public void push(int i) {
		if (stackLength == arr.length) {
			arr = Arrays.copyOf(arr, (int) (arr.length * loadFactor));
		}
		arr[stackLength] = i;
		stackLength++;

	}

	public int pop() {
		if (stackLength == 0) {
			System.out.println("Underflow");
			return -1;
		} else {
			int element = arr[stackLength];
			arr[stackLength] = 0;
			stackLength--;
			return element;
		}
	}

	/**
	 * Output the array to console.
	 * 
	 * @param arr
	 */
	private void printArray(StackUsingArray stack) {
		System.out.println();
		for (int i = 0; i < stackLength; i++) {
			System.out.print(arr[i] + " , ");
		}
	}

	public static void main(String args[]) {
		StackUsingArray stack = new StackUsingArray();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.printArray(stack);
		stack.pop();
		stack.pop();
		stack.printArray(stack);
		stack.pop();
		stack.pop();
		stack.printArray(stack);
		stack.pop();
		stack.pop();
		stack.printArray(stack);
		stack.pop();
		stack.pop();
	}

}
