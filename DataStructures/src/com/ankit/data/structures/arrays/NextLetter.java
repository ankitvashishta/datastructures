package com.ankit.data.structures.arrays;

/**
 * Given an array of lowercase letters sorted in ascending order, find the
 * smallest letter in the given array greater than a given ‘key’. Assume the
 * given array is a circular list.
 * 
 * @author ankit
 *
 */
public class NextLetter {

	/*
	 * Runtime Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 */
	public static char searchNextLetter(char[] letters, char key) {
		if (key >= letters[letters.length - 1])
			return letters[0];
		int start = 0;
		int end = letters.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (key == letters[mid])
				return letters[mid + 1];
			if (key < letters[mid])
				end = mid;
			else
				start = mid + 1;

		}
		return letters[start];
	}

	/*
	 * Runtime Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 */
	public static char searchNextLetter_WithoutIf(char[] letters, char key) {
		int start = 0;
		int end = letters.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (key == letters[mid])
				return letters[mid + 1];
			if (key < letters[mid])
				end = mid;
			else
				start = mid + 1;

		}
		return letters[start % (letters.length - 1)];
	}

	public static void main(String[] args) {
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
		System.out.println(NextLetter.searchNextLetter_WithoutIf(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(NextLetter.searchNextLetter_WithoutIf(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(NextLetter.searchNextLetter_WithoutIf(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(NextLetter.searchNextLetter_WithoutIf(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}
}
