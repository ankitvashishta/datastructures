package com.ankit.data.structures.tries;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of strings, sort them using Trie Data Structure.
 * 
 * @author ankit
 *
 */
public class Challenge3_Sort {

	/*
	 * Time Complexity : O(n).
	 * 
	 * The retrieval will be always in sorted manner, as we traverse in the array
	 * from 0-25 places.
	 */
	public static ArrayList<String> sortArray(String[] arr) {
		ArrayList<String> result = new ArrayList<String>();
		TrieNode root = new TrieNode();
		populateWords(arr, root);
		getWords(root, "", result);
		return result;
	}

	/*
	 * Populate a Trie with the words given. Every node of a trie contains an array
	 * of child nodes of the size = 26, which is the number of small case letters in
	 * english. For a node, if the next letter exists, we initialize the node at
	 * that placeholder, else it is null.
	 */
	private static void populateWords(String[] arr, TrieNode root) {
		for (String str : arr) {
			TrieNode currNode = root;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int j = ch - 97;
				if (currNode.children[j] == null)
					currNode.children[j] = new TrieNode();
				if (i == str.length() - 1)
					currNode.children[j].markAsLeaf();
				else
					currNode = currNode.children[j];
			}
		}
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

		Trie t = new Trie();
		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		ArrayList<String> list = sortArray(keys);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
