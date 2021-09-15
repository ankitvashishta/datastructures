package com.ankit.data.structures.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring, which has no
 * repeating characters.
 * 
 * Example :
 * 
 * Input: String="aabccbb"
 * 
 * Output: 3
 * 
 * Explanation: The longest substring without any repeating characters is "abc".
 * 
 * @author ankit
 *
 */
public class NoRepeatSubstring {

	/*
	 * Runtime Complexity: O(n) where n is the size of input string
	 * 
	 * Space Complexity: O(k) where k is the number of distinct characters in the
	 * input string.
	 */
	public static int findLength(String str) {
		Set<Character> charSet = new HashSet<Character>();
		int maxLength = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!charSet.add(str.charAt(i))) {
				if (charSet.size() > maxLength)
					maxLength = charSet.size();
				charSet = new HashSet<Character>();
				charSet.add(str.charAt(i));
			}
		}
		if (charSet.size() > maxLength)
			maxLength = charSet.size();
		return maxLength;
	}
}
