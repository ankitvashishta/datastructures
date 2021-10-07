package com.ankit.data.structures.tries;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a trie, return all the words in a sorted order.
 * 
 * @author ankit
 *
 */
public class Challenge2_TrieWords {

	/*
	 * Runtime Complexity : O(n)
	 * 
	 * As the algorithm traverses all the nodes, its run time is O(n) where n is the
	 * number of nodes in the trie.
	 */
	public static ArrayList<String> findWords(TrieNode root) {
		ArrayList<String> result = new ArrayList<String>();
		getWords(root, "", result);
		return result;
	}

	private static void getWords(TrieNode node, String str, ArrayList<String> result) {
		if (node.isEndWord)
			result.add(str);
		for (int i = 0; i < 26; i++) {
			TrieNode tNode = node.children[i];
			if (tNode != null) {
				char ch = (char) (97 + i);
				getWords(tNode, str + ch, result);
			}
		}
	}

	public static void main(String args[]) {
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };
		System.out.println("Keys: " + Arrays.toString(keys));

		// Construct trie
		Trie t = new Trie();
		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		ArrayList<String> list = findWords(t.getRoot());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
