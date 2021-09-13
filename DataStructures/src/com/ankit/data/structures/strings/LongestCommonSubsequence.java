package com.ankit.data.structures.strings;

/**
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence
 * which is common in both the strings.
 * 
 * Subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * @author ankit
 *
 */
public class LongestCommonSubsequence {

	/*
	 * Runtime Complexity: Because of the three recursive calls, the time complexity
	 * of the above algorithm is exponential O(3^{m+n}).
	 * 
	 * Space Complexity: O(m+n) -> this space will be used to store the recursion
	 * stack.
	 */
	public int findLCSLength(String s1, String s2) {
		return getLCSLength(s1, s2, 0, 0, 0);
	}

	private int getLCSLength(String s1, String s2, int i, int j, int k) {
		if (i == s1.length() || j == s2.length())
			return k;
		if (s1.charAt(i) == s2.charAt(j)) {
			return getLCSLength(s1, s2, i + 1, j + 1, k + 1);
		}
		int counter1 = getLCSLength(s1, s2, i + 1, j, k);
		int counter2 = getLCSLength(s1, s2, i, j + 1, k);

		return Math.max(counter1, counter2);

	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.findLCSLength("abdca", "cbda"));
		System.out.println(lcs.findLCSLength("passport", "ppsspt"));
	}
}
