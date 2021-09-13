package com.ankit.data.structures.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring
 * which is common in both the strings.
 * 
 * @author ankit
 *
 */
public class LongestCommonSubstring {

	/*
	 * Runtime Complexity: O(n^2 + m^2) where n and m respectively are the lengths
	 * of given Strings
	 * 
	 * Space Complexity: O(n)
	 */
	public int findLCSLength(String s1, String s2) {
		Set<String> stringSet = new HashSet<String>();
		for (int i = 0; i < s1.length(); i++) {
			for (int j = i + 1; j < s1.length(); j++) {
				stringSet.add(s1.substring(i, j));
			}
		}
		int commonStringLength = 0;
		for (int i = 0; i < s2.length(); i++) {
			for (int j = i + 1; j < s2.length(); j++) {
				String temp = s2.substring(i, j);
				if (stringSet.contains(temp)) {
					if (temp.length() > commonStringLength)
						commonStringLength = temp.length();
				}
			}
		}
		return commonStringLength;
	}

	/*
	 * Runtime Complexity: Because of the three recursive calls, the time complexity
	 * of the above algorithm is exponential O(3^{m+n}).
	 * 
	 * Space Complexity: O(m+n) -> this space will be used to store the recursion
	 * stack.
	 */
	public int findLCSLength_optimised(String s1, String s2) {
		return getLCSLength(s1, s2, 0, 0, 0);
	}

	private int getLCSLength(String s1, String s2, int i, int j, int k) {
		if (i == s1.length() || j == s2.length())
			return k;
		if (s1.charAt(i) == s2.charAt(j)) {
			k = getLCSLength(s1, s2, i + 1, j + 1, k + 1);
		}
		int counter1 = getLCSLength(s1, s2, i + 1, j, 0);
		int counter2 = getLCSLength(s1, s2, i, j + 1, 0);

		return Math.max(k, Math.max(counter1, counter2));

	}

	public static void main(String[] args) {
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		System.out.println(lcs.findLCSLength("abdca", "cbda"));
		System.out.println(lcs.findLCSLength("passport", "ppsspt"));
		System.out.println(lcs.findLCSLength_optimised("abdca", "cbda"));
		System.out.println(lcs.findLCSLength_optimised("passport", "ppsspt"));
	}

}
