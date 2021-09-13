package com.ankit.data.structures.strings;

/**
 * Given strings s1 and s2, we need to transform s1 into s2 by deleting and
 * inserting characters. Write a function to calculate the count of the minimum
 * number of deletion and insertion operations.
 * 
 * Example:
 * 
 * Input: s1 = "passport" s2 = "ppsspt"
 * 
 * Output: 3 deletions and 1 insertion
 * 
 * 
 * Explanation: We need to delete {'a', 'o', 'r'} and insert {'p'} to s1 to
 * transform it into s2.
 * 
 * @author ankit
 *
 */
public class MinimumDeletionsInsertions {

	/*
	 * Runtime Complexity: Because of the three recursive calls, the time complexity
	 * of the above algorithm is exponential O(2^{m+n}).
	 * 
	 * Space Complexity: O(m+n) -> this space will be used to store the recursion
	 * stack.
	 */
	public void findMDI(String s1, String s2) {
		int subsequence = getCommonSubsequenceLength(s1, s2, 0, 0, 0);
		System.out.println("Minimum deletions needed: " + (s1.length() - subsequence));
		System.out.println("Minimum insertions needed: " + (s2.length() - subsequence));
	}

	private int getCommonSubsequenceLength(String s1, String s2, int i, int j, int k) {
		if (i == s1.length() || j == s2.length())
			return k;
		if (s1.charAt(i) == s2.charAt(j)) {
			return getCommonSubsequenceLength(s1, s2, i + 1, j + 1, k + 1);
		}
		int counter1 = getCommonSubsequenceLength(s1, s2, i + 1, j, k);
		int counter2 = getCommonSubsequenceLength(s1, s2, i, j + 1, k);
		return Math.max(counter1, counter2);
	}

	public static void main(String[] args) {
		MinimumDeletionsInsertions mdi = new MinimumDeletionsInsertions();
		mdi.findMDI("abc", "fbc");
		mdi.findMDI("abdca", "cbda");
		mdi.findMDI("passport", "ppsspt");
	}

}
