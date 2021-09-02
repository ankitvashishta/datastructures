package com.ankit.data.structures.arrays;

/**
 * Given an unsorted array, find a triplet in the array whose sum is as close to
 * the target number as possible
 * 
 * @author ankit
 *
 */
public class TripletSumCloseToTarget {

	/*
	 * Runtime Complexity: O(N^2)
	 * 
	 * Sorting the array will take O(N* logN). Overall, the function will take
	 * O(N*logN + N^2), which is asymptotically equivalent to O(N^2).
	 * 
	 * Space Complexity: O(n) -> Space to sort the array
	 */
	public static int searchTriplet(int[] arr, int targetSum) {
		int diff = Integer.MAX_VALUE;
		int finalSum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int sum = pointerSearch(arr, targetSum - arr[i], i + 1, arr.length - 1);
			int totalSum = sum + arr[i];
			if (Math.abs(targetSum - totalSum) < Math.abs(diff)) {
				diff = targetSum - totalSum;
				finalSum = totalSum;
			}
		}
		return finalSum;
	}

	private static int pointerSearch(int[] arr, int targetSum, int start, int end) {
		int diff = Integer.MAX_VALUE;
		int finalSum = 0;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum == targetSum) {
				return sum;
			} else if (Math.abs(targetSum - sum) < Math.abs(diff)) {
				diff = targetSum - sum;
				finalSum = sum;
			}
			if (sum < targetSum)
				start++;
			else if (sum > targetSum)
				end--;
		}
		return finalSum;
	}

	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}
}
