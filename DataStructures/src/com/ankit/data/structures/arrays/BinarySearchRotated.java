package com.ankit.data.structures.arrays;

public class BinarySearchRotated {

	static int binarySearchRotated(int[] arr, int key) {
		return binarySearch(arr, 0, arr.length - 1, key);
	}

	static int binarySearch(int[] arr, int start, int end, int key) {
		int mid = (start + end) / 2;
		if (key == arr[mid])
			return mid;
		if (arr[start] <= arr[mid] && key >= arr[start] && key <= arr[mid])
			return binarySearch(arr, start, mid, key);
		else if (arr[mid + 1] <= arr[end] && key >= arr[mid + 1] && key <= arr[end])
			return binarySearch(arr, mid + 1, end, key);
		else if (arr[start] >= arr[mid])
			return binarySearch(arr, start, mid, key);
		else if (arr[end] <= arr[mid])
			return binarySearch(arr, mid + 1, end, key);
		return -1;
	}

	static int binarySearch_loop(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == arr[mid])
				return mid;
			else if (arr[start] < arr[mid] && key >= arr[start] && key <= arr[mid])
				end = mid;
			else if (arr[mid + 1] < arr[end] && key >= arr[mid + 1] && key <= arr[end])
				start = mid + 1;
			else if (arr[start] >= arr[mid])
				end = mid;
			else if (arr[mid + 1] >= arr[end])
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] v1 = { 6, 7, 1, 2, 3, 4, 5 };
		System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
		System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));
		System.out.println("******************************");
		System.out.println("Key(3) found at: " + binarySearch_loop(v1, 3));
		System.out.println("Key(6) found at: " + binarySearch_loop(v1, 6));
		System.out.println("-------------------------------");
		int[] v2 = { 4, 5, 6, 1, 2, 3 };
		System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
		System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));
		System.out.println("******************************");
		System.out.println("Key(3) found at: " + binarySearch_loop(v2, 3));
		System.out.println("Key(6) found at: " + binarySearch_loop(v2, 6));
	}

}
