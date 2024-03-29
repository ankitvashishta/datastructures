package com.ankit.data.structures.strings;

import java.util.PriorityQueue;

/**
 * Given a sequence, find the length of its Longest Palindromic Subsequence
 * (LPS).
 * 
 * Subsequence - sequence that can be derived from another sequence by deleting
 * some or no elements without changing the order of the remaining elements.
 * 
 * Example -> Input: "abdbca"
 * 
 * Output: 5
 * 
 * Explanation: LPS is "abdba".
 * 
 * @author ankit
 *
 */
public class LongestPallindromicSubsequence {

	public int findLPSLength(String input) {

		PriorityQueue<String> priorityQueue = new PriorityQueue<String>(
				(a, b) -> ((Integer) b.length()).compareTo(a.length()));
		checkLPS(input, priorityQueue);

		return priorityQueue.peek().length();
	}

	public void checkLPS(String input, PriorityQueue<String> priorityQueue) {
		if (!(isPallindrome(input, priorityQueue))) {
			for (int i = 0; i < input.length() - 1; i++) {
				if (i == 0) {
					String subString = input.substring(i + 1);
					checkLPS(subString, priorityQueue);
				} else {
					String subString = input.substring(0, i) + input.substring(i + 1, input.length());
					checkLPS(subString, priorityQueue);
				}
			}
		}
	}

	public boolean isPallindrome(String str, PriorityQueue<String> priorityQueue) {
		int length = str.length() - 1;
		int mid = str.length() / 2;
		for (int i = 0; i < mid; i++) {
			if (str.charAt(i) != str.charAt(length - i))
				return false;
		}
		priorityQueue.add(str);
		return true;
	}

	public static void main(String[] args) {
		LongestPallindromicSubsequence lps = new LongestPallindromicSubsequence();
		System.out.println(lps.findLPSLength("abdbca"));
		System.out.println(lps.findLPSLength("cddpd"));
		System.out.println(lps.findLPSLength("pqr"));
	}
}
