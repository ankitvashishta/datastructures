package com.ankit.data.structures.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ankit
 * 
 * Given a sorted array of integers, return the low and high index of
 * the given key.
 *
 */
class FindLowHigh {


	/* ************************************************************
	 * Runtime Complexity : O(logn) where n->size of array.
	 * This methody uses binary search to find the low index &
	 * the high index.
	 * ************************************************************
	 */
	
	static int findLowIndex_binarySearch(List<Integer> arr, int key) {
		int start = 0;
		int end = arr.size() - 1;
		int mid = (start + end) / 2;

		while (start <= end) {
			if (arr.get(mid) >= key) {
				end = mid - 1;
				mid = (start + end) / 2;
			} else {
				start = mid + 1;
				mid = (start + end) / 2;
			}
		}
		if (arr.get(start) == key)
			return start;
		return -1;
	}

	static int findHighIndex_binarySearch(List<Integer> arr, int key) {
		int start = 0;
		int end = arr.size() - 1;
		int mid = (start + end) / 2;
		while (end >= start) {
			if (arr.get(mid) <= key) {
				start = start + 1;
				mid = (start + end) / 2;
			} else {
				end = mid - 1;
				mid = (start + end) / 2;
			}
		}
		if (end == -1 || arr.get(end) == key)
			return end;
		return -1;
	}
	
	// **********************Method Ends***************************

	/* ************************************************************
	 * This method uses binary search to find the key in the array
	 * and then searches linearly towards left to find the low key
	 * and towards right to find the high key.
	 * ************************************************************
	 */
	static int findLowIndex(List<Integer> arr, int key) {
		int mid = binarySearch(arr, key);
		if (mid < 0)
			return -1;
		while (key == arr.get(mid))
			mid--;
		return mid + 1;
	}

	static int findHighIndex(List<Integer> arr, int key) {
		int mid = binarySearch(arr, key);
		if (mid < 0)
			return -1;
		while (key == arr.get(mid))
			mid++;
		return mid - 1;
	}

	static int binarySearch(List<Integer> arr, int key) {
		return binarySearch_recursion(arr, 0, arr.size() - 1, key);
	}

	static int binarySearch_recursion(List<Integer> arr, int start, int end, int key) {
		if (start == end) {
			if (arr.get(start) == key)
				return start;
			else
				return -1;
		}
		int mid = (start + end) / 2;
		if (key == arr.get(mid))
			return mid;

		if (key < arr.get(mid))
			return binarySearch_recursion(arr, start, mid, key);
		else
			return binarySearch_recursion(arr, mid + 1, end, key);
	}
	
	// **********************Method Ends***************************

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
		int key = 5;
		int low = findLowIndex(array, key);
		int high = findHighIndex(array, key);
		System.out.println("Low Index of " + key + ": " + low);
		System.out.println("Low Index of " + key + ": " + findLowIndex_binarySearch(array, key));
		System.out.println("High Index of " + key + ": " + high);
		System.out.println("High Index of " + key + ": " + findHighIndex_binarySearch(array, key));

		key = -2;
		low = findLowIndex(array, key);
		high = findHighIndex(array, key);
		System.out.println("Low Index of " + key + ": " + low);
		System.out.println("Low Index of " + key + ": " + findLowIndex_binarySearch(array, key));
		System.out.println("High Index of " + key + ": " + high);
		System.out.println("High Index of " + key + ": " + findHighIndex_binarySearch(array, key));
	}
}
