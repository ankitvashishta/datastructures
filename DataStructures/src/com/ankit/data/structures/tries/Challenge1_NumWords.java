package com.ankit.data.structures.tries;

import java.util.Arrays;

/**
 * Given a Trie, find the total number of words it contains
 * 
 * @author ankit
 *
 */
public class Challenge1_NumWords {

	/*
	 * Runtime Complexity : O(d^h). Since the array under each node is traversed and
	 * checked for children, the worst-case running time is O(d^h), where d is the
	 * size of the alphabet (26 for English), and h is the length of the longest
	 * word in the dictionary. Note that d is constant, but h is not. So, this is an
	 * exponential function.
	 */
	public static int totalWords(TrieNode root) {
		return getCount(root, 0);
	}

	/*
	 * We start with the root node, and traverse the root node for all its
	 * children(26). A child is initialized if it is a part of any word. Any child
	 * marked as endWord - means that a word ends ther, so we increase the count of
	 * words as we encounter isEndWord as true for any child node.
	 */
	private static int getCount(TrieNode node, int count) {
		if (node.isEndWord)
			count++;
		for (TrieNode tNode : node.children) {
			if (tNode != null)
				count = getCount(tNode, count);
		}
		return count;
	}

	public static void main(String args[]) {
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their", "abc" };
		System.out.println("Keys: " + Arrays.toString(keys));

		// Construct trie
		Trie t = new Trie();
		for (int i = 0; i < keys.length; i++)
			t.insert(keys[i]);

		System.out.println(totalWords(t.getRoot()));
	}

}
