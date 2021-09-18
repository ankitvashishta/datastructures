package com.ankit.data.structures.strings;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no
 * more than ‘k’ letters with any letter, find the length of the longest
 * substring having the same letters after replacement.
 * 
 * Example :
 * 
 * Input: String="aabccbb", k=2
 * 
 * Output: 5
 * 
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating
 * substring "bbbbb".
 * 
 * @author ankit
 *
 */
public class CharacterReplacement {
	/*
	 * The below solution uses sliding window pattern.
	 * 
	 * Time Complexity : O(n) where n is the size of the input string.
	 * 
	 * Space Complexity : O(1)
	 */
	public static int findLength(String str, int k) {
		char previousChar = str.charAt(0);
		char currentChar = str.charAt(0);
		int counter = 0;
		int maxLength = 1;
		int maxPossibleLength = 0;
		int startOfString = 0;
		for (int i = 0; i < str.length(); i++) {
			currentChar = str.charAt(i);
			if (currentChar == previousChar)
				maxLength++;
			else if (counter < k) {
				counter++;
				maxLength++;
			} else {
				startOfString++;
				counter = k - 1;
				previousChar = str.charAt(startOfString);
				maxLength--;
			}
			if (maxLength > maxPossibleLength)
				maxPossibleLength = maxLength;
		}
		return maxPossibleLength;
	}

	public static void main(String[] args) {
		System.out.println(CharacterReplacement.findLength("aabccbb", 2));
		System.out.println(CharacterReplacement.findLength("abbcb", 1));
		System.out.println(CharacterReplacement.findLength("abccde", 1));
	}
}
