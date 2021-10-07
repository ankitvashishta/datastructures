package com.ankit.data.structures.tries;

import java.util.Arrays;

/**
 * Given a dictionary and a word, use a trie to find if the given word can be
 * formed by combining two dictionary words.
 * 
 * Example, the dictionary contains - { "the", "hello", "there", "answer",
 * "any", "dragon", "world", "their", "inc" }
 * 
 * The word we are checking for is "helloworld", which is a combination of
 * "hello" and "world" existing in the dictionary.
 * 
 * @author ankit
 *
 */
public class Challenge4_DictWord {

	/*
	 * For m words in dictionary and h being the average length of a word, the
	 * insertion mechanism would take O(m*h).
	 * 
	 * For a word of length n to be searched, the runtime would be O(n^2).
	 * 
	 * Hence, overall time complexity would be O(mh + n^2).
	 */
	public static boolean isFormationPossible(String[] dict, String word) {
		Trie t = new Trie();
		for (int i = 0; i < dict.length; i++)
			t.insert(dict[i]);
		TrieNode root = t.getRoot();
		for (int i = 0; i < word.length(); i++) {
			String str1 = word.substring(0, i);
			String str2 = word.substring(i, word.length());
			boolean b1 = true;
			boolean b2 = true;
			if (str1.length() > 0)
				b1 = getWords(root, "", str1, 0);
			if (str2.length() > 0)
				b2 = getWords(root, "", str2, 0);
			if (b1 && b2)
				return true;
		}
		return false;
	}

	private static boolean getWords(TrieNode node, String str, String word, int i) {
		if (i == word.length()) {
			if (node.isEndWord) {
				return true;
			}
			return false;
		} else {
			char ch = word.charAt(i);
			int j = ch - 97;
			if (node.children[j] != null) {
				str = str + ch;
				node = node.children[j];
				return getWords(node, str, word, i + 1);
			} else
				return false;
		}
	}

	public static void main(String args[]) {
		String dict[] = { "the", "hello", "there", "answer", "any", "dragon", "world", "their", "inc" };
		System.out.println("Keys: " + Arrays.toString(dict));

		if (isFormationPossible(dict, "helloworld"))
			System.out.println("true");
		else
			System.out.println("false");

	}
}
