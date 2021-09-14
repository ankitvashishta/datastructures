package com.ankit.data.structures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character
 * sequence but changing case.
 * 
 * Example :
 * 
 * Input: "ad52"
 * 
 * Output: "ad52", "Ad52", "aD52", "AD52"
 * 
 * @author ankit
 *
 */
class LetterCaseStringPermutation {

	public static List<String> findLetterCaseStringPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		permutations.add(str);
		findPermutations(str, 0, permutations);
		return permutations;
	}

	public static void findPermutations(String str, int index, List<String> permutations) {
		if (index == str.length())
			return;
		List<String> permutationsCopy = new ArrayList<String>(permutations);
		for (String permutation : permutationsCopy) {
			String permutationCopy1 = null;
			String permutationCopy2 = null;
			if (index < str.length() - 1) {
				permutationCopy1 = permutation.substring(0, index)
						+ permutation.substring(index, index + 1).toLowerCase()
						+ permutation.substring(index + 1, str.length());
				permutationCopy2 = permutation.substring(0, index)
						+ permutation.substring(index, index + 1).toUpperCase()
						+ permutation.substring(index + 1, str.length());
			} else {
				permutationCopy1 = permutation.substring(0, index)
						+ permutation.substring(index, index + 1).toLowerCase();
				permutationCopy2 = permutation.substring(0, index)
						+ permutation.substring(index, index + 1).toUpperCase();
			}
			if (!permutationsCopy.contains(permutationCopy1))
				permutations.add(permutationCopy1);
			if (!permutationsCopy.contains(permutationCopy2))
				permutations.add(permutationCopy2);
		}
		findPermutations(str, index + 1, permutations);
	}

	public static void main(String[] args) {
		List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
		System.out.println(" String permutations are: " + result);

		result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
		System.out.println(" String permutations are: " + result);
	}
}
