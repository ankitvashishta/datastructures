package com.ankit.data.structures.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an array, find the first unique element.
 * 
 * Example : arr = {9, 2, 3, 2, 6, 6}
 * 
 * output : 9
 * 
 * @author ankit
 *
 */
public class Challenge7_CheckFirstUnique {

	/*
	 * Time Complexity : O(n)
	 */
	public static int findFirstUnique(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i : arr) {
			if (map.containsKey(i)) {
				int value = map.get(i);
				value++;
				map.put(i, value);
			} else
				map.put(i, 1);
		}
		for (int i : map.keySet()) {
			if (map.get(i) == 1)
				return i;
		}
		return Integer.MIN_VALUE;
	}

}
