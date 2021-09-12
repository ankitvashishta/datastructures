package com.ankit.data.structures.strings;

/**
 * Given a string, we want to cut it into pieces such that each piece is a
 * palindrome.
 * 
 * Input: "abdbca"
 * 
 * Output: 3
 * 
 * Explanation: Palindrome pieces are "a", "bdb", "c", "a".
 * 
 * @author ankit
 *
 */
public class PalindromicPartitioning {

	public int findMPPCuts(String input) {
		int counter = 0;
		if (input.length() >= 2) {
			for (int i = 0; i < input.length(); i++) {
				for (int j = input.length(); j > i; j--) {
					if (isPallindrome(input.substring(i, j))) {
						i = j - 1;
						counter++;
						break;
					}
				}
			}
		}
		return counter - 1;
	}

	public static boolean isPallindrome(String str) {
		int length = str.length() - 1;
		int mid = str.length() / 2;
		for (int i = 0; i < mid; i++) {
			if (str.charAt(i) != str.charAt(length - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromicPartitioning mpp = new PalindromicPartitioning();
		System.out.println(mpp.findMPPCuts("abdbca"));
		System.out.println(mpp.findMPPCuts("cdpdd"));
		System.out.println(mpp.findMPPCuts("pqr"));
		System.out.println(mpp.findMPPCuts("pp"));

	}

}
