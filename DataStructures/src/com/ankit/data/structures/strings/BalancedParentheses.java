package com.ankit.data.structures.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * For a given number ‘N’, write a function to generate all combination of ‘N’
 * pairs of balanced parentheses.
 * 
 * Example -> Input: N=3
 * 
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * 
 * @author ankit
 *
 */
public class BalancedParentheses {

	public static List<String> generateValidParentheses(int num) {
		String parantheses = "()";
		List<String> result = new ArrayList<String>();
		if (num > 0)
			result.add(parantheses);
		for (int i = 1; i < num; i++) {
			List<String> resultCopy = new ArrayList<String>();
			for (String res : result) {
				for (int j = 0; j < res.length(); j++) {
					String str = res.substring(0, j) + parantheses + res.substring(j);
					if (!resultCopy.contains(str))
						resultCopy.add(str);
				}
				String str = res + parantheses;
				if (!resultCopy.contains(str))
					resultCopy.add(str);
			}
			result = resultCopy;
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> result = generateValidParentheses(2);
		System.out.println("All combinations of balanced parentheses are: " + result);

		result = generateValidParentheses(3);
		System.out.println("All combinations of balanced parentheses are: " + result);
	}

}
