package com.ankit.data.structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	/*
	 * Brute - Force approach.
	 * 
	 * Runtime Complexity: O(n^3) where n is the size of the array.
	 * 
	 * Space Complexity: O(n) -> Space to sort the array
	 * 
	 */
	public static List<List<Integer>> searchTriplets(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			int requiredSum = 0 - arr[i];
			for (int j = i + 1; j < arr.length - 1; j++) {
				int requiredNumber = requiredSum - arr[j];
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[k] == requiredNumber) {
						List<Integer> tripletSum = Arrays.asList(arr[i], arr[j], arr[k]);
						if (!triplets.contains(tripletSum))
							triplets.add(tripletSum);
					}
				}
			}
		}
		return triplets;
	}

	/*
	 * Using Binary Search
	 * 
	 * Runtime Complexity: O(n^2 * logn)
	 * 
	 * Space Complexity: O(n) -> Space to sort the array
	 */
	public static List<List<Integer>> searchTriplets_BinarySearch(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int requiredSum = 0 - arr[i];
			for (int j = i + 1; j < arr.length - 1; j++) {
				int requiredNumber = requiredSum - arr[j];
				int index = binarySearch(arr, requiredNumber, j + 1, arr.length - 1);
				if (index < arr.length && arr[index] == requiredNumber) {
					List<Integer> tripletSum = Arrays.asList(arr[i], arr[j], arr[index]);
					if (!triplets.contains(tripletSum))
						triplets.add(tripletSum);
				}
			}
		}
		return triplets;
	}

	private static int binarySearch(int[] arr, int number, int start, int end) {
		if (start == end && number != arr[start])
			return Integer.MAX_VALUE;
		int mid = (start + end) / 2;
		if (number == arr[mid])
			return mid;
		else if (number < arr[mid])
			return binarySearch(arr, number, start, mid);
		else
			return binarySearch(arr, number, mid + 1, end);

	}

	/*
	 * Using Pointer Search
	 * 
	 * Runtime Complexity: O(n^2)
	 * 
	 * Space Complexity: O(n) -> Space to sort the array
	 */
	public static List<List<Integer>> searchTriplets_PointerSearch(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int requiredSum = 0 - arr[i];
			pointerSearch(arr, requiredSum, i + 1, arr.length - 1, triplets);
		}
		return triplets;
	}

	private static void pointerSearch(int[] arr, int requiredSum, int start, int end, List<List<Integer>> triplets) {
		while (start < end) {
			if (arr[start] + arr[end] == requiredSum) {
				List<Integer> list = Arrays.asList(-requiredSum, arr[start], arr[end]);
				if (!triplets.contains(list))
					triplets.add(list);
				start++;
				end--;
			} else if (arr[start] + arr[end] < requiredSum)
				start++;
			else if (arr[start] + arr[end] > requiredSum)
				end--;
		}

	}

	public static void main(String[] args) {
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println(TripletSumToZero.searchTriplets_BinarySearch(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println(TripletSumToZero.searchTriplets_PointerSearch(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
		System.out.println(TripletSumToZero.searchTriplets_BinarySearch(new int[] { -5, 2, -1, -2, 3 }));
		System.out.println(TripletSumToZero.searchTriplets_PointerSearch(new int[] { -5, 2, -1, -2, 3 }));
	}
}
