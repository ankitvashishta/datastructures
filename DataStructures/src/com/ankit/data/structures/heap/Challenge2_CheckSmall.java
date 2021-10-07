package com.ankit.data.structures.heap;

/**
 * Given an arry and a given number k, find the k smallest numbers from array.
 * 
 * Example : arr = [9,4,7,1,-2,6,5] k = 3
 * 
 * Output : [-2,1,4]
 * 
 * @author ankit
 *
 */
public class Challenge2_CheckSmall {

	/*
	 * Time Complexity : O(n + klogn).
	 * 
	 * The time complexity of building a heap is O(n). Furthermore, removing the k
	 * smallest elements takes a time complexity of O(klogn).
	 */
	public static int[] findKSmallest(int[] arr, int k) {

		int[] result = new int[k];
		for (int j = 0; j < k; j++) {
			int heapSize = arr.length - j;
			int mid = (heapSize - 1) / 2;
			for (int i = mid; i >= 0; i--) {
				minHeapify(i, arr, heapSize);
			}
			result[j] = arr[0];
			arr[0] = arr[arr.length - (j + 1)];
		}
		return result;
	}

	private static void minHeapify(int index, int[] arr, int heapSize) {
		if (index < arr.length / 2) {
			int min = index;
			int left = (2 * index) + 1;
			int right = (2 * index) + 2;
			if (left < heapSize && arr[left] < arr[min])
				min = left;
			if (right < heapSize && arr[right] < arr[min])
				min = right;
			if (min != index) {
				int temp = arr[index];
				arr[index] = arr[min];
				arr[min] = temp;
				minHeapify(min, arr, heapSize);
			}
		}
	}

	public static void main(String args[]) {
		int[] input = { 9, 4, 7, 1, -2, 6, 5 };
		int[] output = findKSmallest(input, 7);

		for (int i = 0; i < output.length; i++)
			System.out.println(output[i]);
	}
}
