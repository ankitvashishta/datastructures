package com.ankit.data.structures.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring in it with no more
 * than K distinct characters.
 * 
 * @author ankit
 *
 */
public class LongestDistinctKCharacterSubstring {

	/*
	 * Runtime Complexity: O(n), where n is the size of input string.
	 * 
	 * Space Complexity: O(k), where k is the size of distinct characters.
	 * 
	 */
	public static int findLength(String str, int k) {
		Set<Character> charSet = new HashSet<Character>();
		int j = 0;
		int maxLength = 0;
		for (int i = 0; i < str.length() - k && j < str.length();) {
			charSet.add(str.charAt(j));
			if (charSet.size() <= k) {
				if ((j - i + 1) > maxLength)
					maxLength = (j - i) + 1;
				j++;
			} else {
				charSet.remove(str.charAt(i));
				i++;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(
				"Length of the longest substring: " + LongestDistinctKCharacterSubstring.findLength("araaci", 2));
		System.out.println(
				"Length of the longest substring: " + LongestDistinctKCharacterSubstring.findLength("araaci", 1));
		System.out.println(
				"Length of the longest substring: " + LongestDistinctKCharacterSubstring.findLength("cbbebi", 3));
	}

}
