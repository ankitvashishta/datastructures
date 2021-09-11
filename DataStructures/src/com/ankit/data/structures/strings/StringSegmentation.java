package com.ankit.data.structures.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a dictionary of words and an input string tell whether the input string
 * can be completely segmented into dictionary words.
 * 
 * @author ankit
 *
 */
public class StringSegmentation {

	/*
	 * Runtime Complexity: O(2^n) -> The runtime complexity of this solution is
	 * exponential, if we use recursion.
	 * 
	 * Space Complexity: O(n^2) -> because we create a substring on each recursion
	 * call.
	 */
	public static boolean canSegmentString(String s, Set<String> dictionary) {
		for (int i = 1; i < s.length(); i++) {
			String subString1 = s.substring(0, i);
			if (dictionary.contains(subString1)) {
				String subString2 = s.substring(i, s.length());
				if (dictionary.contains(subString2)) {
					System.out.println(subString1);
					System.out.println(subString2);
					return true;
				} else if (canSegmentString(subString2, dictionary)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("hello");
		dictionary.add("hell");
		dictionary.add("on");
		dictionary.add("now");

		String s = new String();
		s = "hellonow";
		if (canSegmentString(s, dictionary)) {
			System.out.println("String Can be Segmented");
		} else {
			System.out.println("String Can NOT be Segmented");
		}
	}
}
