package com.ankit.data.structures.strings;

import java.util.PriorityQueue;

/**
 * Given a string, find the length of its Longest Palindromic Substring (LPS).
 * 
 * Input: "abdbca"
 * 
 * Output: 3
 * 
 * Explanation: LPS is "bdb".
 * 
 * @author ankit
 *
 */
public class LongestPalindromicSubstring {

	public static int findLPSLength(String input) {

		PriorityQueue<String> priorityQueue = new PriorityQueue<String>(
				(a, b) -> ((Integer) b.length()).compareTo(a.length()));
		if (input.length() >= 2) {
			for (int i = 0; i < input.length() - 1; i++) {
				for (int j = i + 2; j <= input.length(); j++) {
					isPallindrome(input.substring(i, j), priorityQueue);
				}
			}
		}
		if (!priorityQueue.isEmpty())
			return priorityQueue.peek().length();
		return 1;
	}

	public static boolean isPallindrome(String str, PriorityQueue<String> priorityQueue) {
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
		String str = "aabbbaa";
		int count = findLPSLength(str);
		System.out.println("Length Of Longest Pallindrome: " + count);
	}
}
