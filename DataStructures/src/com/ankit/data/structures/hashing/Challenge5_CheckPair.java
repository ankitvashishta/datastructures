package com.ankit.data.structures.hashing;

import java.util.HashMap;

/**
 * Given an array, find two pairs or 4 elements (a,b,c,d) in an array, such
 * that, a+b = c+d. You only have to find first two pairs in the array which
 * satisfies the above condition.
 * 
 * Example : arr = {3, 4, 7, 1, 12, 9}
 * 
 * Output : "{4,12}{7,9}"
 * 
 * @author ankit
 *
 */
public class Challenge5_CheckPair {

	/*
	 * Time Complexity : O(n ^ 2) where n is the number of elements in the array.
	 */
	public static String findPair(int[] arr) {
		String result = "";
		HashMap<Integer, String> map = new HashMap<>();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (map.containsKey(sum)) {
					result = map.get(sum) + "{" + arr[i] + "," + arr[j] + "}";
					return result;
				} else {
					map.put(sum, "{" + arr[i] + "," + arr[j] + "}");
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {

		int[] arr = { 3, 4, 7, 1, 12, 9 };
		System.out.println(findPair(arr));

	}

}
