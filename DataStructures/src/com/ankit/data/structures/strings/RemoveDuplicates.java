package com.ankit.data.structures.strings;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Remove duplicate characters from a String(char array).
 * 
 * @author ankit
 *
 */
public class RemoveDuplicates {
	/*
	 * Runtime Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 */
	static void removeDuplicates(char[] str) {
		Set<Character> charSet = new LinkedHashSet<Character>();
		int readIndex = 0;
		int writeIndex = 0;
		while (readIndex != str.length) {
			if (charSet.add(str[readIndex])) {
				str[writeIndex] = str[readIndex];
				writeIndex++;
			}
			readIndex++;
		}
		if (writeIndex != str.length)
			str[writeIndex] = '\0';
	}

	public static void main(String[] args) {
		String str = "dabbac";
		char[] input = str.toCharArray();
		System.out.print("Before: ");
		System.out.println(input);
		RemoveDuplicates.removeDuplicates(input);
		System.out.print("After: ");
		print(input);
	}

	static void print(char[] s) {
		int i = 0;
		while (s[i] != '\0') {
			System.out.print(s[i]);
			++i;
		}
		System.out.println();
	}
}
