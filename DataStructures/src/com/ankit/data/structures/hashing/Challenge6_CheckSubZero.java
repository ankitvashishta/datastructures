package com.ankit.data.structures.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array, check whether a given array has a contiguous subarray with a
 * sum equal to zero.
 * 
 * Example : arr = {6, 4, -7, 3, 12, 9}
 * 
 * Output : true
 * 
 * @author ankit
 *
 */
public class Challenge6_CheckSubZero {

	/*
	 * Runtime Complexity : O(n) as it linearly traverses the array.
	 * 
	 * Space Complexity : O(n) - as we save the sum of subarray at every iteration.
	 */
	public static boolean findSubZero(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] == 0 || sum == 0 || map.containsKey(sum))
				return true;
			else
				map.put(sum, i);
		}
		return false;
	}

	public static void main(String args[]) {
		int[] arr = { 6, 4, -7, 3, 12, 9 };
		System.out.println(findSubZero(arr));
	}

}
