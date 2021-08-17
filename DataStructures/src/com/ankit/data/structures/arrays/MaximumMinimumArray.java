package com.ankit.data.structures.arrays;

/**
 * 
 * @author ankit
 * 
 * Re-arrange the elements of a sorted array in such a way that the
 * first position will have the largest number, the second will have the
 * smallest, the third will have the second-largest, and so on.
 *
 */
public class MaximumMinimumArray {

	public static int[] maxMin(int[] arr) {
		int maxElement = arr[arr.length - 1] + 1;
		int minCounter = 0;
		int maxCounter = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] += (arr[maxCounter] % maxElement) * maxElement;
				maxCounter--;
			} else {
				arr[i] += (arr[minCounter] % maxElement) * maxElement;
				minCounter++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] / maxElement;
		}
		return arr;
	}

	public static void main(String args[]) {
		int[] arr = maxMin(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\s");
		}
	}

}
