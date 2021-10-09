package com.ankit.data.structures.hashing;

import java.util.HashSet;

/**
 * Take two arrays as input and check whether an array is a subset of another
 * given array.
 * 
 * Example : arr1 = [9,4,7,1,-2,6,5] arr2 = [7,1,-2]
 * 
 * Output : true.
 * 
 * @author ankit
 *
 */
public class Challenge1_CheckSubset {

	/*
	 * Time Complexity : O(m+n) -> m & n are the size of two input arrays.
	 * 
	 * Space Complexity : O(m) -> HashSet contains the number of elements in the
	 * larger array. As soon as there is an addition to the hashset from the
	 * subarray, the program terminates. Worst-case, O(m+1) - ignoring the constant
	 * value -> O(m)
	 */
	public static boolean isSubset(int[] arr1, int[] arr2) {
		HashSet<Integer> nums = new HashSet<>();
		for (int i : arr1) {
			nums.add(i);
		}
		for (int i : arr2) {
			if (nums.add(i))
				return false;
		}
		return true;
	}

	public static void main(String args[]) {

		int[] arr1 = { 9, 4, 7, 1, -2, 6, 5 };
		int[] arr2 = { 7, 1, -2 };
		int[] arr3 = { 10, 12 };

		System.out.println(isSubset(arr1, arr2));
		System.out.println(isSubset(arr1, arr3));
	}
}
