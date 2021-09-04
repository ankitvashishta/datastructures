package com.ankit.data.structures.arrays;

/**
 * Given an array of numbers sorted in an ascending order, find the ceiling of a
 * given number ‘key’. The ceiling of the ‘key’ will be the smallest element in
 * the given array greater than or equal to the ‘key’.
 * 
 * Write a function to return the index of the ceiling of the ‘key’. If there
 * isn’t any ceiling return -1.
 * 
 * @author ankit
 *
 */
public class CeilingOfANumber {

	/*
	 * Runtime Complexity: O(logn)
	 * 
	 * We are using binary search for this problem, and thereby reducing the search
	 * range by half in each iteration.
	 * 
	 * Space Complexity: O(1)
	 */
	public static int searchCeilingOfANumber(int[] arr, int key) {
		if (key > arr[arr.length - 1])
			return -1;
		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] < key)
				start = mid + 1;
			else
				end = mid;
		}

		return start;
	}

	public static void main(String[] args) {
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
		System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	}
}
