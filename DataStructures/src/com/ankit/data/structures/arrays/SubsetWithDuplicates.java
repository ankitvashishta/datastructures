package com.ankit.data.structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of numbers that might contain duplicates, find all of its
 * distinct subsets.
 * 
 * @author ankit
 *
 */
public class SubsetWithDuplicates {

	/*
	 * Time Complexity: O(N * 2^N) In each step, the number of subsets doubles (if
	 * not duplicate) as we clone the existing subsets and add each element to the
	 * clone of all the existing subsets. Finally, we will have a total of O(2^N)
	 * subsets, where ‘N’ is the total number of elements. And since we loop through
	 * the input array, therefore, the time complexity of the algorithm will be
	 * O(N*2^N)
	 * 
	 */
	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		subsets.add(new ArrayList<>()); // adding an empty subset.
		subsets.add(new ArrayList<Integer>(Arrays.asList(nums[0])));
		Integer lastNumber = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (lastNumber == nums[i]) {
				List<List<Integer>> clones = new ArrayList<List<Integer>>();
				for (List<Integer> subset : subsets) {
					if (subset.contains(nums[i])) {
						List<Integer> clone = (List<Integer>) ((ArrayList<Integer>) subset).clone();
						clone.add(nums[i]);
						clones.add(clone);
					}
				}
				subsets.addAll(clones);
			} else {
				List<List<Integer>> clones = new ArrayList<List<Integer>>();
				for (List<Integer> subset : subsets) {
					List<Integer> clone = (List<Integer>) ((ArrayList<Integer>) subset).clone();
					clone.add(nums[i]);
					clones.add(clone);
				}
				subsets.addAll(clones);
			}
			lastNumber = nums[i];
		}
		return subsets;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}
}