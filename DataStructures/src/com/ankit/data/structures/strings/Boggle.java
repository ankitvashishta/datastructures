package com.ankit.data.structures.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a N×N grid of characters and a dictionary, find all words which can be
 * made from the characters in the grid and are present in the given dictionary.
 * 
 * Example :
 * 
 * grid = [['c', 'a', 't'],
 * 		   ['r', 'r', 'e'],
 * 		   ['t', 'o', 'n']]
 * 
 * dictionary = {"cat", "cater", "cartoon", "toon", "moon", "not", "tone", "apple", "ton", "art"}
 * 
 * Result = {art, ton, cater, cat, eat}
 * 
 * @author ankit
 *
 */
public class Boggle {
	private char[][] grid;
	private HashSet<String> dictionary;

	Boggle(char[][] grid, HashSet<String> dictionary) {
		this.grid = grid;
		this.dictionary = dictionary;
	}

	public boolean isPrefix(String str) {
		for (String word : dictionary)
			if (word.contains(str))
				return true;
		return false;
	}

	/*
	 * Time Complexity : O(N ^ N) where N is the dimension of the grid. The runtime
	 * complexity of this solution is exponential
	 *
	 * Space Complexity : O(N^2) The space complexity of this solution is quadratic
	 * 
	 * The solution uses backtracking algorithm.
	 */
	public HashSet<String> findAllWords() {
		HashSet<String> result = new HashSet<String>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				StringBuffer str = new StringBuffer();
				str.append(grid[i][j]);
				Pair pair = new Pair(i, j);
				List<Pair> pairList = new ArrayList<Pair>();
				pairList.add(pair);
				traverseAdjacently(str, pair, pairList, result);
			}
		}

		return result;
	}

	/*
	 * A word can start and end at any character in the grid. The next character
	 * must be adjacent to the previous character in any of the directions: up,
	 * down, left, right and diagonal.
	 * 
	 * For a given alphabet in a grid, there can be eight possible adjacent
	 * characters to traverse.
	 */
	public void traverseAdjacently(StringBuffer str, Pair pair, List<Pair> pairList, HashSet<String> result) {
		int X = pair.X;
		int Y = pair.Y;
		if (X > 0) {
			if (Y > 0) {
				checkWord(X - 1, Y - 1, str, pairList, result);
			}
			checkWord(X - 1, Y, str, pairList, result);
			if (Y < grid.length - 1) {
				checkWord(X - 1, Y + 1, str, pairList, result);
			}
		}
		if (Y > 0) {
			checkWord(X, Y - 1, str, pairList, result);
		}
		if (Y < grid.length - 1) {
			checkWord(X, Y + 1, str, pairList, result);
		}
		if (X < grid.length - 1) {
			if (Y > 0) {
				checkWord(X + 1, Y - 1, str, pairList, result);
			}
			checkWord(X + 1, Y, str, pairList, result);
			if (Y < grid.length - 1) {
				checkWord(X + 1, Y + 1, str, pairList, result);
			}
		}
	}

	private void checkWord(int X, int Y, StringBuffer str, List<Pair> pairList, HashSet<String> result) {
		Pair newPair = new Pair(X, Y);
		if (!pairList.contains(newPair)) {
			StringBuffer newStr = new StringBuffer(str.toString());
			newStr.append(grid[newPair.X][newPair.Y]);
			if (dictionary.contains(newStr.toString())) {
				result.add(newStr.toString());
			}
			if (isPrefix(newStr.toString())) {
				traverseAdjacently(newStr, newPair, pairList, result);
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid = new char[][] { { 'c', 'a', 't' }, { 'r', 'r', 'e' }, { 't', 'o', 'n' } };

		String[] dict = { "cat", "cater", "cartoon", "art", "toon", "moon", "eat", "ton" };
		HashSet<String> dictionary = new HashSet<String>();
		for (String s : dict) {
			dictionary.add(s);
		}

		Boggle b = new Boggle(grid, dictionary);
		HashSet<String> words = b.findAllWords();
		for (String s : words) {
			System.out.println(s);
		}
	}

}

class Pair {
	int X;
	int Y;

	Pair(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	@Override
	public boolean equals(Object o) {
		Pair newPair = (Pair) o;
		return (this.X == newPair.X && this.Y == newPair.Y);
	}
}
