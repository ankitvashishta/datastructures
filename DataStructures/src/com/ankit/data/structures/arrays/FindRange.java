package com.ankit.data.structures.arrays;

/**
 * Given an array of numbers sorted in ascending order, find the range of a
 * given number ‘key’. The range of the ‘key’ will be the first and last
 * position of the ‘key’ in the array.
 * 
 * @author ankit
 *
 */
public class FindRange {

	/*
	 * Runtime Complexity: O(n)
	 * 
	 * Retrieving the index of key takes O(logn). Once index of key is retrieved. we
	 * travel in both directions to find the first and last occurrence. In worst
	 * case, it could take n steps - O(n). Hence asymptotic complexity is O(n).
	 * 
	 * Space Complexity: O(1)
	 */
	public static int[] findRange(int[] arr, int key) {
		int[] result = new int[] { -1, -1 };
		int index = getKeyIndex(arr, key);
		if (index != -1) {
			int start = index;
			int end = index;
			while (start > 0 && arr[start] == key)
				start--;
			while (end < arr.length - 1 && arr[end] == key)
				end++;
			result[0] = start + 1;
			result[1] = end - 1;
		}
		return result;
	}

	/*
	 * Runtime Complexity: O(logn)
	 * 
	 * Retrieving the index of key takes O(logn). Once index of key is retrieved.
	 * use binary search again to find the first and last occurrence. This takes
	 * another O(logn) + O(logn) thereby the final computation to be O(3logn).
	 * Hence, ignoring the constant time, asymptotic complexity is O(logn).
	 * 
	 * Space Complexity: O(1)
	 */
	public static int[] findRange_Optimised(int[] arr, int key) {
		int[] result = new int[] { -1, -1 };
		int index = getKeyIndex(arr, key);
		if (index != -1) {
			result[0] = getStartIndex(arr, key, index);
			result[1] = getEndIndex(arr, key, index);
		}
		return result;
	}

	public static int getKeyIndex(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (key == arr[mid])
				return mid;
			if (key < arr[mid])
				end = mid;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static int getStartIndex(int[] arr, int key, int index) {
		int start = 0;
		int end = index;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (key == arr[mid])
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}

	public static int getEndIndex(int[] arr, int key, int index) {
		int start = index;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (key == arr[mid])
				start = mid + 1;
			else
				end = mid;
		}
		return start - 1;
	}

	public static void main(String[] args) {
		int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = FindRange.findRange_Optimised(new int[] { 4, 6, 6, 6, 9 }, 6);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = FindRange.findRange_Optimised(new int[] { 1, 3, 8, 10, 15 }, 10);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		result = FindRange.findRange_Optimised(new int[] { 1, 3, 8, 10, 15 }, 12);
		System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
	}
}
