package com.ankit.data.structures.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author ankit
 * 
 * Find the length of largest subArray, with a sum of zero.
 *
 */
public class LargestZeroSumSubArray {

	public static int getLargestZeroSumSubArray(int[] arr) {
		Map<Integer, Integer> sumsMap = new HashMap<>();

		int sum = arr[0];
		sumsMap.put(sum, 0);
		int maxLength = 1;

		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxLength = i + 1;
				continue;
			}

			if (sumsMap.containsKey(sum)) {
				int prevIndex = sumsMap.get(sum);
				maxLength = Math.max(maxLength, (i - prevIndex));
			} else {
				sumsMap.put(sum, i);
			}
		}

		return maxLength;
	}

	public static int getLargestZeroSumSubArray_NoExtraSpace(int[] arr) {

		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == 0)
					maxLength = Math.max(maxLength, (j - i) + 1);
			}
			sum = 0;
		}
		return maxLength;
	}

	public static void main(String args[]) {
		int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println(getLargestZeroSumSubArray(arr));
		System.out.println(getLargestZeroSumSubArray_NoExtraSpace(arr));
	}

}
