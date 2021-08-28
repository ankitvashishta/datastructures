package com.ankit.data.structures.arrays;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the
 * maximum sum of any contiguous subarray of size ‘k’.
 * 
 * @author ankit
 *
 */
public class MaxSumSubArrayOfSizeK {

	/*
	 * Runtime Complexity : O(n * k) where n is the size of the array & k is the
	 * size of the window. Memory complexity : O(1).
	 */
	public static int findMaxSumSubArray(int k, int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += arr[j];
			}
			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}

	/*
	 * Here, we subtract the element going out of the sliding window and add the new
	 * element getting included in the sliding window.
	 * Runtime complexity : O(n) where n is the size of array.
	 * Memory complexity : O(1)
	 */
	public static int findMaxSumSubArray_Optimized(int k, int[] arr) {
		int maxSum = 0;
		for (int j = 0; j < k; j++) {
			maxSum += arr[j];
		}
		int sum = maxSum;
		for (int i = k; i < arr.length; i++) {
			sum -= arr[i - k];
			sum += arr[i];

			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println("Maximum sum of a subarray of size K: "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		System.out.println("Maximum sum of a subarray of size K: "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	}
}
