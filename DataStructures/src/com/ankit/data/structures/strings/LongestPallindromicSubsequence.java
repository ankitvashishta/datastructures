package com.ankit.data.structures.strings;

import java.util.PriorityQueue;

/**
 * Given a string, find the longest Palindromic subsequence.
 * 
 * @author ankit
 *
 */
public class LongestPallindromicSubsequence {

	/*
	 * Runtime Complexity: O(n^3)
	 * 
	 * Space Complexity: O(m * n) - Where m is the number of palindromes and n is
	 * the length of palindromes.
	 */
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
		return priorityQueue.peek().length();
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
