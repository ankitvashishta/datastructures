package com.ankit.data.structures.arrays;

import java.util.Arrays;

/**
 * Given a sorted array, return the array containing squares of all the numbers
 * of the input array in the sorted order.
 * 
 * @author ankit
 *
 */
public class SortedArraySquares {

	/*
	 * Case (if no numbers are negative) :
	 * Time Complexity: O(n) where n is the size of the array.
	 * Space Complexity: O(1)
	 * 
	 * Case (if array contains negative numbers) :
	 * Time Complexity: O(n)
	 * The array is iterated twice->O(2n) which is asymptotically equivalent to O(n).
	 * Space Complexity: O(k) where k is the number of negative numbers in the array.
	 * 
	 */
	public static int[] makeSquares(int[] arr) {
		if (arr[0] < 0) {
			int i = 0;
			while (arr[i] < 0)
				i++;
			int[] negativeNumbersArray = Arrays.copyOfRange(arr, 0, i);
			int k = 0;
			for (int j = i - 1; j >= 0; j--) {
				negativeNumbersArray[k] = (int) Math.pow(arr[j], 2);
				k++;
			}
			for (int j = i; j < arr.length; j++) {
				arr[j] = (int) Math.pow(arr[j], 2);
			}
			k = 0;
			for (int j = 0; j < arr.length; j++) {
				if (k < negativeNumbersArray.length && (i >= arr.length || negativeNumbersArray[k] < arr[i])) {
					arr[j] = negativeNumbersArray[k];
					k++;
				} else {
					arr[j] = arr[i];
					i++;
				}
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) Math.pow(arr[i], 2);
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();

		result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();
	}
}
