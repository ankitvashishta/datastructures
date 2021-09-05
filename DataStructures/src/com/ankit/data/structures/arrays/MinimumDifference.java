package com.ankit.data.structures.arrays;

/**
 * Given an array of numbers sorted in ascending order, find the element in the
 * array that has the minimum difference with the given ‘key’.
 * 
 * @author ankit
 *
 */
public class MinimumDifference {

	/*
	 * Runtime Complexity : O(logn)
	 * 
	 * Overall runtime : O(logn+logn+logn) = O(3logn), asymptotically equal to
	 * O(logn)
	 * 
	 * Space Complexity : O(1)
	 */
	public static int searchMinDiffElement(int[] arr, int key) {
		int targetNumber = binarySearch_Number(arr, key);
		if (key == targetNumber)
			return targetNumber;
		int smallerNumber = binarySearch_smaller(arr, key);
		int greaterNumber = binarySearch_greater(arr, key);
		if ((key - smallerNumber) > (greaterNumber - key))
			return greaterNumber;
		else
			return smallerNumber;
	}

	/*
	 * Runtime Complexity : O(logn)
	 */
	public static int binarySearch_Number(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] == key)
				return arr[mid];
			else if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}

	/*
	 * Runtime Complexity : O(logn)
	 */
	public static int binarySearch_smaller(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid;
		}
		return arr[start - 1];
	}

	/*
	 * Runtime Complexity : O(logn)
	 */
	public static int binarySearch_greater(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return arr[start];
	}

	public static void main(String[] args) {
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
	}
}
