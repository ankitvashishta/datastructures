package com.ankit.data.structures.hashing;

import java.util.HashSet;

/**
 * check whether two given arrays are disjoint or not. Disjoint arrays mean that
 * their intersection returns nothing or there are no common elements in them.
 * The assumption is that there are no duplicate elements in each array. An
 * illustration is also provided for your understanding.
 * 
 * Example : arr1 = [9,4,3,1,-2,6,5] arr2 = [7,10,8]
 * 
 * Output : true
 * 
 * @author ankit
 *
 */
public class Challenge2_CheckDisjoint {

	/*
	 * Time Complexity : O(m+n) -> m & n are the size of two input arrays.
	 * 
	 * Space Complexity : O(m) -> HashSet contains all the elements of the first
	 * array, and then iterate over the second array, and if any of the element is
	 * found, we break the flow - as there is a common element.
	 * 
	 */
	public static Object isDisjoint(int[] arr1, int[] arr2) {
		HashSet<Integer> nums = new HashSet<>();
		for (int i : arr1) {
			nums.add(i);
		}
		for (int i : arr2) {
			if (nums.contains(i))
				return false;
		}
		return Boolean.TRUE;
	}

	public static void main(String args[]) {

		int[] arr1 = { 9, 4, 3, 1, -2, 6, 5 };
		int[] arr2 = { 7, 10, 8 };
		int[] arr3 = { 1, 12 };
		System.out.println(isDisjoint(arr1, arr2));
		System.out.println(isDisjoint(arr1, arr3));
	}

}
