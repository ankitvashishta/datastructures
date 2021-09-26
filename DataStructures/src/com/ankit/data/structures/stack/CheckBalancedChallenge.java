package com.ankit.data.structures.stack;

/**
 * For a given expression, check if its parentheses are balanced.
 * 
 * @author ankit
 *
 */
public class CheckBalancedChallenge {

	/*
	 * Time Complexity : O(n) as we traverse the expression exactly once.
	 * 
	 * Space Complexity : O(n) as we initialize a stack with expression's length.
	 */
	public static boolean isBalanced(String exp) {
		Stack<Character> stack = new Stack<>(exp.length());
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			switch (ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);
				break;
			case ')': {
				char ch1 = stack.pop();
				if (ch1 != '(')
					return false;
				break;
			}
			case '}': {
				char ch1 = stack.pop();
				if (ch1 != '{')
					return false;
				break;
			}
			case ']': {
				char ch1 = stack.pop();
				if (ch1 != '[')
					return false;
				break;
			}
			}

		}
		return stack.isEmpty();
	}

	public static void main(String args[]) {

		System.out.println(isBalanced("{[()]}"));
		System.out.println(isBalanced("[{(}]"));

	}
}
