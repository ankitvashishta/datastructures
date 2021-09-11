package com.ankit.data.structures.strings;

/**
 * Given a sentence (an array of characters), reverse the order of words.
 * 
 * Example : Input String -> We love Java
 * 
 * Expected Output -> Java love We
 * 
 * How the solution works :
 * 
 * Step 1 : Reverse the string -> avaJ evol eW
 * 
 * Step 2 : Traverse the string and reverse every word in place -> Java love We
 * 
 * @author ankit
 *
 */
public class ReverseString {
	/*
	 * Runtime Complexity : O(n) -> O(n) for reversing the String. O(n+n) for
	 * traversing and reversing every word in place. That gives an overall runtime
	 * of O(3n), which, asymptotically is equal to O(n).
	 * 
	 * Space Complexity : O(1) as no auxiliary space was used.
	 */
	public static void reverseWords(char[] sentence) {

		// Step 1. Reverse the whole String
		reverseString(sentence, 0, sentence.length - 1);

		// Step 2. Traverse the string and reverse every word in place
		int start = 0;
		int end = 0;
		for (int i = 0; i < sentence.length; i++) {
			if (sentence[i] == ' ') {
				end = i - 1;
				reverseString(sentence, start, end);
				start = i + 1;
			}
		}
		reverseString(sentence, start, sentence.length - 1);

	}

	private static void reverseString(char[] sentence, int start, int end) {
		while (start <= end) {
			char temp = sentence[start];
			sentence[start] = sentence[end];
			sentence[end] = temp;
			start++;
			end--;
		}
	}

	/*************************************
	 ************ Main Method ************
	 *************************************/

	public static void main(String[] args) {
		String str = "We love Java";
		char[] charArray = str.toCharArray();
		System.out.println(charArray);
		reverseWords(charArray);
		System.out.println(charArray);
	}

}
