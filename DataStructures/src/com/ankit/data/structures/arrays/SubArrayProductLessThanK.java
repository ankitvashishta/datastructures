package com.ankit.data.structures.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array with positive numbers and a positive target number, find all
 * of its contiguous subarrays whose product is less than the target number.
 * 
 * @author ankit
 *
 */
public class SubArrayProductLessThanK {

	/*
	 * Runtime Complexity: O(n^3) -> O(n^2) for One outer loop and one nested loop.
	 * Additional O(n) for initializing the new Array List.
	 * 
	 * Space Complexity: O(n^2) -> Apart from the output list, For every counter of
	 * outer loop, there is an ArrayList of size O(n) which is auxiliary. Hence
	 * O(n*n).
	 */
	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> subArrays = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> subArray = new ArrayList<Integer>();
			int product = arr[i];
			if (product < target) {
				subArray.add(arr[i]);
				subArrays.add(subArray);
				subArray = new ArrayList<Integer>(subArray);
			}
			for (int j = i + 1; j < arr.length; j++) {
				product *= arr[j];
				if (product < target) {
					subArray.add(arr[j]);
					subArrays.add(subArray);
					subArray = new ArrayList<Integer>(subArray);
				}
			}
		}

		return subArrays;
	}

	public static void main(String[] args) {
		System.out.println(SubArrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(SubArrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
	}
}
