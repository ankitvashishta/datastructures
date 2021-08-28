package com.ankit.data.structures.arrays;

/**
 * We are given an array containing ‘n’ objects. Each object, when created, was
 * assigned a unique number from 1 to ‘n’ based on their creation sequence. This
 * means that the object with sequence number ‘3’ was created just before the
 * object with sequence number ‘4’.
 * 
 * Write a function to sort the objects in-place on their creation sequence
 * number in O(n) and without any extra space.
 * 
 * @author ankit
 *
 */
public class CyclicSort {

	/*
	 * Runtime Complexity: O(n) where n is the size of the array.
	 * In the worst-case scenario, the while loop will swap a total of ‘n-1’ numbers
	 * and once a number is at its correct index, we will move on to the next number
	 * by incrementing i. So overall, our algorithm will take O(n) + O(n-1) which is
	 * asymptotically equivalent to O(n).
	 * 
	 * Memory Complexity: O(1).
	 */
	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i + 1) {
				continue;
			} else {
				while (nums[i] != i + 1) {
					int targetNumber = nums[i];
					int temp = nums[targetNumber - 1];
					nums[i] = temp;
					nums[targetNumber - 1] = targetNumber;
				}
			}
		}
		// TODO: Write your code here
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 1, 5, 4, 2 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 2, 6, 4, 3, 1, 5 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 1, 5, 6, 4, 3, 2 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}
}
