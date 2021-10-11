package com.ankit.data.structures.strings;

import java.util.Stack;

public class MixedPallindrome {
	
	public static void checkString(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!stack.isEmpty() && stack.peek() == ch)
				stack.pop();
			else
				stack.push(ch);
		}
		if(!stack.isEmpty())
			System.out.println(str);
	}
	
	public static void main(String args[]) {
		checkString("aabb");
		checkString("aaccbb");
		checkString("abcba");
		checkString("abccba");
		checkString("xaabbx");
	}

}
