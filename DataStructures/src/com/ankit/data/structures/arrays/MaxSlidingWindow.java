package com.ankit.data.structures.arrays;

import java.util.ArrayDeque;

class MaxSlidingWindow {
	public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
		ArrayDeque<Integer> result = new ArrayDeque<>();
		for (int i = 0; i <= arr.length - windowSize; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < i + windowSize; j++) {
				if (arr[j] > max)
					max = arr[j];
			}
			result.add(max);
		}
		return result;
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
		int windowSize = 4;
		System.out.println(findMaxSlidingWindow(arr, windowSize));
	}
}
