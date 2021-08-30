package com.ankit.data.structures.arrays;

public class MaxInBitonicArray {

	/*
	 * Time Complexity: O(n). Where n is the size of the array.
	 * 
	 * Space Complexity: O(1)
	 */
	public static int findMax(int[] arr) {
		int i = 0;
		while (arr[i] < arr[i + 1] && i < arr.length - 2)
			i++;
		if (i == arr.length - 2)
			return arr[i + 1];
		return arr[i];
	}

	/*
	 * Time Complexity: O(logn). Where n is the size of the array.
	 * 
	 * Space Complexity: O(1)
	 */
	public static int findMax_binarySearch(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] > arr[mid + 1])
				end = mid;
			else
				start = mid + 1;
		}
		return arr[start];
	}

	public static void main(String[] args) {
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
		System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
		System.out.println(MaxInBitonicArray.findMax_binarySearch(new int[] { 1, 3, 8, 12, 4, 2 }));
		System.out.println(MaxInBitonicArray.findMax_binarySearch(new int[] { 3, 8, 3, 1 }));
		System.out.println(MaxInBitonicArray.findMax_binarySearch(new int[] { 1, 3, 8, 12 }));
		System.out.println(MaxInBitonicArray.findMax_binarySearch(new int[] { 10, 9, 8 }));
	}
}
