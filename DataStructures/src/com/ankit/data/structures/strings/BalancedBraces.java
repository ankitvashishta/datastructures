package com.ankit.data.structures.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * For a given number ‘N’, write a function to generate all combination of ‘N’
 * pairs of balanced braces.
 * 
 * Example -> Input: N=3
 * 
 * Output: {{{}}}, {{}{}}, {{}}{}, {}{{}}, {}{}{}
 * 
 * @author ankit
 *
 */
public class BalancedBraces {

	/*
	 * The runtime complexity of this solution is exponential, 2^n.
	 * 
	 * Space Complexity : O(n)
	 */
	public static ArrayList<ArrayList<Character>> printAllBraces(int num) {
		ArrayList<ArrayList<Character>> resultChar = new ArrayList<ArrayList<Character>>();
		String parantheses = "{}";
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
		for (String str : result) {
			ArrayList<Character> chars = new ArrayList<>();
			for (char ch : str.toCharArray()) {
				chars.add(ch);
			}
			resultChar.add(chars);
		}
		result.stream().forEach(e -> {
			System.out.println(e);
			ArrayList<Character> chars = (ArrayList<Character>) e.chars().mapToObj(a -> (char) a)
					.collect(Collectors.toList());
			resultChar.add(chars);
		});
		return resultChar;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
		result = printAllBraces(3);
		print(result);
	}

	static void print(ArrayList<ArrayList<Character>> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).toString());
		}
	}

}
