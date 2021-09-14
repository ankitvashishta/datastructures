package com.ankit.data.structures.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets, and your goal is to put maximum number of fruits
 * in each basket. The only restriction is that each basket can have only one
 * type of fruit.
 * 
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop
 * when you have to pick from a third fruit type.
 * 
 * @author ankit
 *
 */
public class FruitsIntoBaskets {

	/*
	 * Time Complexity: O(n) where n is the size of array.
	 * 
	 * Space Complexity: O(k) where k is the number of baskets.
	 */
	public static int findLength(char[] strArray) {
		int noOfBaskets = 2;
		Set<Character> charSet = new HashSet<Character>();
		int j = 0;
		int maxLength = 0;
		for (int i = 0; i < strArray.length - noOfBaskets && j < strArray.length;) {
			charSet.add(strArray[j]);
			if (charSet.size() <= noOfBaskets) {
				if ((j - i + 1) > maxLength)
					maxLength = (j - i) + 1;
				j++;
			} else {
				charSet.remove(strArray[i]);
				i++;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(
				"Maximum number of fruits: " + FruitsIntoBaskets.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: "
				+ FruitsIntoBaskets.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}
}
