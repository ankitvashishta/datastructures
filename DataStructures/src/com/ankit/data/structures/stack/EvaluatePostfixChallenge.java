package com.ankit.data.structures.stack;

/**
 * Compute postfix mathematical expressions using stacks.
 * 
 * Sample Input : expression = "921*-8-4+"
 * 
 * Output : 3
 * 
 * Explanation :
 * 
 * 1st operation => 2 * 1 = 2,
 * 
 * 2nd operation => 9 - 2 = 7,
 * 
 * 3rd operation => 7 - 8 = -1,
 * 
 * 4th operation => -1 + 4 = 3
 * 
 * @author ankit
 *
 */
public class EvaluatePostfixChallenge {

	/*
	 * Time Complexity : O(n) - Since we traverse the string of n characters once,
	 * the time complexity for this algorithm is O(n).
	 */
	public static int evaluatePostFix(String expression) {
		Stack<Integer> stack = new Stack<Integer>(expression.length());
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (Character.isDigit(ch)) {
				stack.push(Character.getNumericValue(ch));
			} else {
				Integer operator2 = stack.pop();
				Integer operator1 = stack.pop();
				if (ch == '+')
					stack.push(operator1 + operator2);
				else if (ch == '-')
					stack.push(operator1 - operator2);
				else if (ch == '*')
					stack.push(operator1 * operator2);
				else if (ch == '/')
					stack.push(operator1 / operator2);
				else if (ch == '%')
					stack.push(operator1 % operator2);
			}
		}
		return stack.pop();
	}

	public static void main(String args[]) {

		System.out.println(evaluatePostFix("921*-8-4+"));

	}
}