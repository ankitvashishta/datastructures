package com.ankit.data.structures.arrays;

/**
 * 
 * @author ankit
 * 
 * get the maximum contiguous sub array available in the given array.
 *
 */
public class MaximumSubArray {

	/*
	 * Brute-force method.
	 */
	public static int getMaximumSubArrayLength(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum > maxSum) {
					maxSum = sum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		System.out.println("Starting Index : " + startIndex);
		System.out.println("End Index : " + endIndex);
		System.out.println("Sum : " + maxSum);
		return endIndex - startIndex + 1;
	}

	/*
	 * Dynamic programming method.
	 */
	public static int getMaximumSubArray_DP(int[] arr) {
		int currSum = arr[0];
		int max = arr[0];
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (currSum < 0) {
				currSum = arr[i];
				startIndex = i;
			}else {
				currSum += arr[i];
			}
			if (max < currSum) {
				max = currSum;
				endIndex = i;
			}
		}
		System.out.println("Starting Index : " + startIndex);
		System.out.println("End Index : " + endIndex);
		System.out.println("Sum : " + max);
		return endIndex - startIndex + 1;
	}

	public static void main(String args[]) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Length : " + getMaximumSubArrayLength(arr));
		System.out.println("Length : " + getMaximumSubArray_DP(arr));
	}

}
