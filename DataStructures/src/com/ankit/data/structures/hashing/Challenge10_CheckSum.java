package com.ankit.data.structures.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array and a number "n", find two numbers from the array that sums up
 * to "n".
 * 
 * Example : arr = {1, 21, 3, 14, 5, 60, 7, 6} value = 27
 * 
 * Output : arr = {21, 6} or {6, 21}
 * 
 * @author ankit
 *
 */
public class Challenge10_CheckSum {
	/*
	 * Time Complexity : O(n), where n is the size of input array.
	 * 
	 * Space Complexity : O(n) as we store the elements in a set.
	 * 
	 */
	public static int[] findSum(int[] arr, int n) {
		int[] result = new int[2];
		Set<Integer> set = new HashSet<>();
		for (int i : arr)
			set.add(i);
		for (int i : arr) {
			int diff = n - i;
			if (set.contains(diff)) {
				result[0] = i;
				result[1] = diff;
				break;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int n = 27;
		int[] arr1 = { 1, 21, 3, 14, 5, 60, 7, 6 };
		int[] arr2 = findSum(arr1, n);
		int num1 = arr2[0];
		int num2 = arr2[1];

		if ((num1 + num2) != n)
			System.out.println("Not Found");
		else {
			System.out.println("Number 1 = " + num1);
			System.out.println("Number 2 = " + num2);
			System.out.println("Sum = " + (n));
		}
	}

}
