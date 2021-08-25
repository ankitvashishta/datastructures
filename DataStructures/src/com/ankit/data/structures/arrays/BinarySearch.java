package com.ankit.data.structures.arrays;

/**
 * 
 * @author ankit 
 * 
 * Use binary search to retrieve an element in a sorted array.
 *
 */
public class BinarySearch {

	/*
	 * Using recursion.
	 */
	static int binSearch(int[] a, int key) {
		return search(a, 0, a.length, key);
	}

	static int search(int[] a, int start, int end, int key) {
		if (start == end) {
			if (a[start] == key)
				return start;
			else
				return -1;
		}
		int mid = (start + end) / 2;
		if (key == a[mid])
			return mid;
		else if (key < a[mid])
			return search(a, start, mid, key);
		else
			return search(a, mid + 1, end, key);
	}

	/*
	 * Using loop to binary search.
	 */
	public static int binarySearch(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		int mid = end / 2;
		while (start != end) {
			if (key == arr[mid])
				return mid;
			else if (key < arr[mid]) {
				end = mid;
				mid = (start + end) / 2;
			} else {
				start = mid + 1;
				mid = (start + end) / 2;
			}
		}
		if (key == arr[start])
			return start;
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222 };
		int[] inputs = { 10, 49, 99, 110, 176 };

		for (int i = 0; i < inputs.length; i++) {
			System.out.println("binarySearch(arr, " + inputs[i] + ") = " + binarySearch(arr, inputs[i]));
		}

		for (int i = 0; i < inputs.length; i++) {
			System.out.println("binSearch(arr, " + inputs[i] + ") = " + binSearch(arr, inputs[i]));
		}
	}

}
