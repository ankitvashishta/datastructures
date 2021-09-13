package com.ankit.data.structures.strings;

/**
 * Given a string, find all substrings that are palindromes.
 * 
 * @author ankit
 *
 */
public class PalindromeSubstrings {

	/*
	 * Runtime Complexity: O(n^3)
	 * 
	 * Space Complexity: O(1)
	 */
	public static int findAllPalindromeSubstrings(String input) {
		int counter = 0;
		if (input.length() >= 2) {
			for (int i = 0; i < input.length() - 1; i++) {
				for (int j = i + 1; j < input.length(); j++) {
					if (isPallindrome(input, i, j))
						counter++;
				}
			}
		}
		return counter;
	}

	private static boolean isPallindrome(String str, int i, int j) {
		while (j > i) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	/*
	 * Runtime Complexity: O(n^2)
	 * 
	 * Space Complexity: O(1)
	 */
	public static int findAllPalindromeSubstrings_optimised(String input) {
		int counter = 0;
		if (input.length() >= 2) {
			for (int i = 0; i < input.length(); i++) {
				// This checks for odd size palindrome. Ex aba. Where i is pointing at b.
				counter += findPallindrome(input, i - 1, i + 1);
				// This checks for even size palindrome. Ex aa. Where i is pointing at first a.
				counter += findPallindrome(input, i, i + 1);
			}
		}
		return counter;
	}

	private static int findPallindrome(String input, int i, int j) {
		int count = 0;
		for (; i >= 0 && j < input.length(); i--, j++) {
			if (input.charAt(i) != input.charAt(j))
				return count;
			else
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "aabbbaa";
		int count = findAllPalindromeSubstrings(str);
		System.out.println("Total palindrome substrings: " + count);
		count = findAllPalindromeSubstrings_optimised(str);
		System.out.println("Total palindrome substrings: " + count);
	}
}
