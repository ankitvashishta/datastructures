package com.ankit.data.structures.strings;

/**
 * Given a null terminated string, remove any white spaces (tabs or spaces).
 * 
 * @author ankit
 *
 */
public class RemoveWhiteSpaces {
	/*
	 * Runtime Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 */
	static void removeWhiteSpaces(char[] s) {
		int readIndex = 0;
		int writeIndex = 0;
		while (readIndex != s.length) {
			if (!(s[readIndex] == ' ' || s[readIndex] == '\t')) {
				s[writeIndex] = s[readIndex];
				writeIndex++;
			}
			readIndex++;
		}
		if (writeIndex != s.length)
			s[writeIndex] = '\0';
	}

	public static void main(String[] args) {
		String str = "All greek to me";
		char[] s = str.toCharArray();
		System.out.print("Before: ");
		System.out.println(s);
		removeWhiteSpaces(s);
		System.out.print("After: ");
		print(s);
	}

	static void print(char[] s) {
		int i = 0;
		while (i < s.length && s[i] != '\0') {
			System.out.print(s[i]);
			++i;
		}
		System.out.println();
	}
}
