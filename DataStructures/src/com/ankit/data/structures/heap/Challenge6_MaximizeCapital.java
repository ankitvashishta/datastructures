package com.ankit.data.structures.heap;

import java.util.PriorityQueue;

/**
 * Given a set of investment projects with their respective profits, we need to
 * find the most profitable projects. We are given an initial capital and are
 * allowed to invest only in a fixed number of projects. Our goal is to choose
 * projects that give us the maximum profit.
 * 
 * Example:
 * 
 * Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1,
 * Number of Projects=2 Output: 6 Explanation:
 * 
 * With initial capital of ‘1’, we will start the second project which will give
 * us profit of ‘2’. Once we selected our first project, our total capital will
 * become 3 (profit + initial capital). With ‘3’ capital, we will select the
 * third project, which will give us ‘3’ profit. After the completion of the two
 * projects, our total capital will be 6 (1+2+3).
 * 
 * @author ankit
 *
 */
public class Challenge6_MaximizeCapital {

	public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a, b) -> b - a);
		int currCapital = initialCapital;
		int prevCounter = 0;
		for (int i = 0; i < numberOfProjects; i++) {
			int counter = prevCounter;
			while (counter < capital.length && capital[counter] <= currCapital) {
				profitQueue.add(profits[counter]);
				counter++;
			}
			prevCounter = counter;
			currCapital = currCapital + profitQueue.peek();
		}
		return currCapital;
	}

	public static void main(String[] args) {
		int result = findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
		System.out.println("Maximum capital: " + result);
		result = findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
		System.out.println("Maximum capital: " + result);
	}

}
