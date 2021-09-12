package com.ankit.data.structures.strings;

/**
 * Given a text and a pattern, evaluate the pattern to see if it matches with
 * the text.
 * 
 * @author ankit
 *
 */
public class StringMatch {

	/*
	 * Runtime Complexity: O(2^n) -> where n is the size of input String.
	 * 
	 * Space Complexity: O(2^n) -> The memory complexity of this solution is
	 * exponential, recursive solution will use memory on the stack.
	 */
	static boolean regxMatchRec(String text, String pattern) {
		if (text.isEmpty() && pattern.isEmpty())
			return true;
		if (!text.isEmpty() && pattern.isEmpty())
			return false;
		if (pattern.length() > 1 && pattern.charAt(1) == '*') {
			String remainingPattern = pattern.substring(2);
			String remainingText = text;
			for (int i = 0; i <= text.length(); i++) {
				if (regxMatchRec(remainingText, remainingPattern))
					return true;
				if (remainingText.isEmpty()) {
					return false;
				}
				if (pattern.charAt(0) != '.' && remainingText.charAt(0) != pattern.charAt(0)) {
					return false;
				}
				remainingText = remainingText.substring(1);
			}
		}
		if (text.isEmpty())
			return false;
		if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0))
			return regxMatchRec(text.substring(1), pattern.substring(1));
		return false;

	}

	public static void main(String[] args) {
		String s = "b";
		String p = "b*";
		boolean output2 = regxMatchRec(s, p);
		if (output2) {
			System.out.print(s + " " + p + " match");
		} else {
			System.out.print(s + " " + p + " did not match.");
		}
	}
}
