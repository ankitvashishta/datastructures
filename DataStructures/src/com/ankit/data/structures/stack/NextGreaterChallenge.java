package com.ankit.data.structures.stack;

import java.util.Arrays;

/**
 * Implement a method to find the next greater element after any given element
 * from the stack.
 * 
 * Input : [4, 6, 3, 2, 8, 1, 11]
 * 
 * Output : [6, 8, 8, 8, 11, 11, -1]
 * 
 * @author ankit
 *
 */
public class NextGreaterChallenge {

	/*
	 * Time Complexity: O(n) -> every element is pushed on the stack exactly once.
	 * Furthermore, since once an element is removed from the stack, it is never
	 * re-inserted, every element is removed exactly once, too. That means we
	 * perform one push and one pop operation per element, exactly. Therefore, the
	 * time complexity of this algorithm will be O(n).
	 */
	public static int[] nextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>(arr.length);
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.top() <= arr[i])
				stack.pop();
			if (stack.isEmpty())
				result[i] = -1;
			else
				result[i] = stack.top();
			stack.push(arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 6, 3, 2, 8, 1, 11 };
		System.out.println(Arrays.toString(arr));
		int result[] = nextGreaterElement(arr);
		System.out.println(Arrays.toString(result));
	}
}