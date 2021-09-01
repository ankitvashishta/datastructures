package com.ankit.data.structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct numbers, find all of its permutations.
 * 
 * @author ankit
 *
 */
public class Permutations {

	/*
	 * brute-force method.
	 */
	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> numsList = new ArrayList<Integer>();
		for (int num : nums)
			numsList.add(num);
		for (int i = 0; i < nums.length; i++) {
			Integer targetNumber = nums[i];
			List<Integer> numsListCopy = new ArrayList<Integer>(numsList);
			numsListCopy.remove(targetNumber);
			for (int j = 0; j < nums.length; j++) {
				List<Integer> permutationList = new ArrayList<Integer>();
				if (j != 0)
					for (int k = 0; k < j; k++)
						permutationList.add(numsListCopy.get(k));
				permutationList.add(targetNumber);
				for (int k = j; k < numsListCopy.size(); k++)
					permutationList.add(numsListCopy.get(k));
				if (!result.contains(permutationList))
					result.add(permutationList);
			}
		}

		numsList = new ArrayList<Integer>();
		for (int l = nums.length - 1; l >= 0; l--)
			numsList.add(nums[l]);
		for (int i = 0; i < nums.length; i++) {
			Integer targetNumber = nums[i];
			List<Integer> numsListCopy = new ArrayList<Integer>(numsList);
			numsListCopy.remove(targetNumber);
			for (int j = 0; j < nums.length; j++) {
				List<Integer> permutationList = new ArrayList<Integer>();
				if (j != 0)
					for (int k = 0; k < j; k++)
						permutationList.add(numsListCopy.get(k));
				permutationList.add(targetNumber);
				for (int k = j; k < numsListCopy.size(); k++)
					permutationList.add(numsListCopy.get(k));
				if (!result.contains(permutationList))
					result.add(permutationList);
			}
		}

		return result;
	}

	/*
	 * Time complexity: O(N*N!) where N is the size of the array.
	 * 
	 * There are a total of N! permutations of a set with ‘N’ numbers. We are
	 * iterating through all of these permutations with the help inner ‘for’ loops.
	 * 
	 * Space complexity: O(N*N!)
	 * 
	 * All the additional space used by our algorithm is for the result list and the
	 * linkedlist to store the intermediate permutations. At any time, there are
	 * maximum N! permutations.
	 */
	public static List<List<Integer>> findPermutations_optimised(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			results.add(new LinkedList<Integer>(Arrays.asList(nums[i])));
		}
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> resultsIntermediate = new ArrayList<>();
			for (List<Integer> result : results) {
				if (!(result.size() == nums.length)) {
					for (int k = 0; k <= result.size(); k++) {
						LinkedList<Integer> resultCopy = new LinkedList<Integer>(result);
						if (!resultCopy.contains(nums[i])) {
							resultCopy.add(k, nums[i]);
							if (!resultsIntermediate.contains(resultCopy))
								resultsIntermediate.add(resultCopy);
						}
					}
				}
			}
			if (!resultsIntermediate.isEmpty())
				results = resultsIntermediate;
		}
		return results;
	}

	/*
	 * recursion method.
	 */
	public static List<List<Integer>> findPermutations_recursive(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			getPermutations_recursive(nums, 0, new LinkedList<Integer>(Arrays.asList(nums[i])), results);
		}
		return results;
	}

	public static void getPermutations_recursive(int[] nums, int index, LinkedList<Integer> permutation,
			List<List<Integer>> permutations) {
		for (int i = 0; i < nums.length; i++) {
			if (!permutation.contains(nums[i]) && permutation.size() != nums.length) {
				for (int j = 0; j <= permutation.size(); j++) {
					LinkedList<Integer> newPermutation = new LinkedList<Integer>(permutation);
					newPermutation.add(j, nums[i]);
					if (!permutations.contains(newPermutation) && newPermutation.size() == nums.length)
						permutations.add(newPermutation);
					else if (index < nums.length - 1)
						getPermutations_recursive(nums, index + 1, newPermutation, permutations);

				}
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
		System.out.println("Here are all the permutations: " + result);
		result = Permutations.findPermutations_optimised(new int[] { 1, 3, 5 });
		System.out.println("Here are all the permutations: " + result);
		result = Permutations.findPermutations_recursive(new int[] { 1, 3, 5 });
		System.out.println("Here are all the permutations: " + result);
	}
}
