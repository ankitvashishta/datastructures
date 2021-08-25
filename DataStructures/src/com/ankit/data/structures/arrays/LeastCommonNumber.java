package com.ankit.data.structures.arrays;

/**
 * 
 * @author ankit
 * 
 * Given three integer arrays sorted in ascending order, return
 * the smallest number that is common in all three arrays.
 *
 */
class LeastCommonNumber {
	
	static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0, j = 0, k = 0;
		for (; i < arr1.length && j < arr2.length && k < arr3.length;) {
			if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
				return arr1[i];
			} else {
				if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k])
					i++;
				else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k])
					j++;
				else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j])
					k++;
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int[] v1 = new int[] { 6, 7, 10, 25, 30, 63, 64 };
		int[] v2 = new int[] { 1, 4, 5, 6, 7, 8, 50 };
		int[] v3 = new int[] { 1, 6, 10, 14 };

		Integer result = findLeastCommonNumber(v1, v2, v3);
		System.out.println("Least Common Number: " + result);
	}
}
