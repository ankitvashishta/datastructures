package com.ankit.data.structures.arrays;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length
 * of the smallest contiguous subarray whose sum is greater than or equal to ‘S’
 * 
 * @author ankit
 *
 */
public class MinSizeSubArraySum {

	/*
	 * Runtime Complexity: O(n) where n is the size of array.
	 * The outer for loop runs for all elements, and the inner while loop processes
	 * each element only once; therefore, the time complexity of the algorithm will
	 * be O(N+N), which is asymptotically equivalent to O(N).
	 * 
	 * Space Complexity: O(1).
	 */
	public static int findMinSubArray(int S, int[] arr) {
		int sum = 0;
		int startIndex = 0;
		int length = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			while (sum >= S) {
				length = Math.min(length, i - startIndex + 1);
				sum = sum - arr[startIndex];
				startIndex++;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);
		result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);

	}
}
