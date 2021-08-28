package com.ankit.data.structures.arrays;

import java.util.Arrays;

/**
 * Move all zeros to the left of an array while maintaining its order.
 * 
 * @author ankit
 *
 */
public class MoveZeros {
	/*
	 * Time Complexity : O(n^2) where n is the size of array.
	 */
	static void moveZerosToLeft(int[] arr) {
		int z = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				int j = i;
				while (j > z) {
					arr[j] = arr[j - 1];
					j--;
				}
				arr[z] = 0;
				z++;
			}

		}
	}

	/*
	 * Time Complexity: O(n) where n is the size of the array.
	 * Here, we start from the end of the array.
	 */
	static void moveZerosToLeft_Optimised(int[] arr) {
		int readIndex = arr.length - 1;
		int writeIndex = arr.length - 1;
		while (readIndex >= 0) {
			if (arr[readIndex] != 0) {
				arr[writeIndex] = arr[readIndex];
				writeIndex--;
			}
			readIndex--;
		}
		while (writeIndex >= 0) {
			arr[writeIndex] = 0;
			writeIndex--;
		}
	}

	public static void main(String args[]) {
		int[] v = new int[] { 1, 10, 20, 0, 59, 63, 0, 88, 0 };
		System.out.println("Original Array: " + Arrays.toString(v));
		moveZerosToLeft(v);
		System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
		v = new int[] { 1, 10, 20, 0, 59, 63, 0, 88, 0 };
		System.out.println("Original Array: " + Arrays.toString(v));
		moveZerosToLeft_Optimised(v);
		System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
	}
}
