package com.ankit.data.structures.stack;

/**
 * Solve this celebrity problem using a built-in Stack. Implement
 * findCelebrity() method to find the celebrity in a party (matrix) using a
 * stack. A celebrity is someone that everyone knows, but he/she doesn’t know
 * anyone at the party.
 * 
 * Where the party is a reference variable storing a 2D matrix, which has stored
 * all the information about acquaintances, numPeople and the number of people
 * present in the party.
 * 
 * In the party matrix, a particular [row][col] stores acquaintance information
 * for row and col. In other words, if [row][col] == 1, then it means row knows
 * col, and if it’s zero, then it means row doesn’t know col. Remember that
 * everyone knows a celebrity, but the celebrity doesn’t know the people at the
 * party.
 * 
 * Example : party = { {0,1,1,0}, 
 * 					   {1,0,1,1}, 
 * 					   {0,0,0,0}, 
 *                     {0,1,1,0}, }
 * 
 * numPeople = 4 (Number of rows in party array) 
 * 
 * Output : 2 (because row Index = 2 is a celebrity)
 * 
 * 
 * 
 * @author ankit
 *
 */
public class FindCelebChallenge {
	
	/*
	 * Time Complexity : O(n)
	 */
	public static int findCelebrity(int[][] party, int numPeople) {
		int celebrity = -1;
		Stack<Integer> stack = new Stack<Integer>(numPeople);
		for (int i = 0; i < numPeople; i++)
			stack.push(i);
		// Take two people out of stack and check if they know each other
		// One who doesn't know the other, push it back in stack.
		while (!stack.isEmpty()) {
			int x = stack.pop();
			if (stack.isEmpty())
				celebrity = x;
			else {
				int y = stack.pop();
				if (party[x][y] == 1)
					stack.push(y);
				else
					stack.push(x);
			}
		}
		int j = celebrity;
		// At this point we will have last element of stack as celebrity
		// Check it to make sure it's the right celebrity.
		// Celebrity knows no one while everyone knows celebrity
		for (int i = 0; i < numPeople; i++) {
			if (j != i) {
				if (party[i][j] == 1 && party[j][i] == 0) {
					continue;
				} else {
					celebrity = -1;
					break;
				}
			}

		}
		return celebrity;
	}
	
	public static void main(String args[]) {

		int[][] party1 = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 0, 0 }, { 0, 1, 1, 0 }, };

		int[][] party2 = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 0 }, };

		int[][] party3 = { { 0, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 1, 0 }, };

		System.out.println(findCelebrity(party1, 4));
		System.out.println(findCelebrity(party2, 4));
		System.out.println(findCelebrity(party3, 4));
	}
}
