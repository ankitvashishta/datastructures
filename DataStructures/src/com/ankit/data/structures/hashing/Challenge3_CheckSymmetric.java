package com.ankit.data.structures.hashing;

import java.util.HashMap;

/**
 * Find all the symmetric pairs in the given array. By definition, (a,b) and
 * (c,d) are symmetric pairs if a = d and b = c.
 * 
 * Example : arr[][] = [{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}]
 * 
 * Output : {3,4}{5,9}
 * 
 * Note: We will return {3, 4} and {5, 9} instead of {4, 3} and {9, 5} because
 * the former occurred first.
 * 
 * @author ankit
 *
 */
public class Challenge3_CheckSymmetric {

	/*
	 * Runtime Complexity : O(n), where n is the size of the array. Every row
	 * contains 2 elements, so we can ignore the constant value.
	 * 
	 * Space Complexity : O(n) as the HashMap stores all the pairs.
	 */
	public static String findSymmetric(int[][] arr) {
		String result = "";
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int[] rows : arr) {
			int key = rows[0];
			int value = rows[1];
			if (map.containsKey(value) && map.get(value) == key) {
				result += "{" + value + "," + key + "}";
			} else {
				map.put(key, value);
			}
		}
		return result;
	}

	public static void main(String args[]) {

		int[][] arr = { { 1, 2 }, { 3, 4 }, { 5, 9 }, { 4, 3 }, { 9, 5 } };
		String symmetric = findSymmetric(arr);
		System.out.println(symmetric);

	}

}
