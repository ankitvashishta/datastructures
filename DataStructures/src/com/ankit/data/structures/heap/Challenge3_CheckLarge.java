package com.ankit.data.structures.heap;

/**
 * Given an array and a number k, find the k largest numbers in the array.
 * 
 * Example : arr = [9,4,7,1,-2,6,5] k = 3
 * 
 * Output : [9,7,6]
 * 
 * @author ankit
 *
 */
public class Challenge3_CheckLarge {

	/*
	 * Time Complexity : O(n + klogn).
	 * 
	 * The time complexity of building a heap is O(n). Furthermore, removing the k
	 * smallest elements takes a time complexity of O(klogn).
	 */
	public static int[] findKLargest(int[] arr, int k) {
		int[] result = new int[k];
		for (int j = 0; j < k; j++) {
			int mid = (arr.length - (j + 1)) / 2;
			for (int i = mid; i >= 0; i--) {
				maxHeapify(i, arr, arr.length - j);
			}
			result[j] = arr[0];
			arr[0] = arr[arr.length - (j + 1)];
		}
		return result;
	}

	private static void maxHeapify(int index, int[] arr, int heapSize) {
		if (index < heapSize / 2) {
			int left = (2 * index) + 1;
			int right = (2 * index) + 2;
			int max = index;
			if (left < heapSize && arr[left] > arr[max])
				max = left;
			if (right < heapSize && arr[right] > arr[max])
				max = right;
			if (max != index) {
				int temp = arr[index];
				arr[index] = arr[max];
				arr[max] = temp;
				maxHeapify(max, arr, heapSize);
			}
		}
	}

	public static void main(String args[]) {
		int[] input = { 9, 4, 7, 1, -2, 6, 5 };
		int[] output = findKLargest(input, 7);

		for (int i = 0; i < output.length; i++)
			System.out.println(output[i]);
	}
}
