package com.ankit.data.structures.arrays;

import java.util.Arrays;

class TripletWithSmallerSum {

	/*
	 * Runtime Complexity: O(N^2)
	 * 
	 * Sorting the array will take O(N* logN). Overall, the function will take
	 * O(N*logN + N^2), which is asymptotically equivalent to O(N^2).
	 * 
	 * Space Complexity: O(n) -> Space to sort the array
	 */
	public static int searchTriplets(int[] arr, int targetSum) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			count += pointerSearch(arr, targetSum - arr[i], i + 1, arr.length - 1);

		}
		return count;
	}

	private static int pointerSearch(int[] arr, int targetSum, int start, int end) {
		int count = 0;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum < targetSum) {
				count += end - start;
				start++;
			} else {
				end--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

}
