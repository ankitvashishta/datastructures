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
				for (int j = i + 2; j <= input.length(); j++) {
					if (isPallindrome(input.substring(i, j)))
						counter++;
				}
			}
		}
		return counter;
	}

	public static boolean isPallindrome(String str) {
		int length = str.length() - 1;
		int mid = str.length() / 2;
		for (int i = 0; i < mid; i++) {
			if (str.charAt(i) != str.charAt(length - i))
				return false;
		}
		System.out.println(str);
		return true;
	}

	public static void main(String[] args) {
		String str = "aabbbaa";
		int count = findAllPalindromeSubstrings(str);
		System.out.println("Total palindrome substrings: " + count);
	}
}
