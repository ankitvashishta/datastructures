package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
 * prerequisite tasks which need to be completed before it can be scheduled.
 * Given the number of tasks and a list of prerequisite pairs, find out if it is
 * possible to schedule all the tasks.
 * 
 * Example 1 : Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * 
 * Output: true
 * 
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
 * 
 * Output: false - as there is a cyclic dependency.
 * 
 * @author ankit
 *
 */
public class Challenge13_TaskScheduling {

	public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
		Map<Integer, List<Integer>> dependencies = new HashMap<>();
		for (int i = 0; i < tasks; i++) {
			dependencies.put(i, new ArrayList<Integer>());
		}
		for (int[] prerequisite : prerequisites) {
			dependencies.get(prerequisite[1]).add(prerequisite[0]);
		}
		Integer startTask = -1;
		for (int i = 0; i < tasks; i++) {
			if (dependencies.get(i).size() == 0) {
				startTask = i;
				break;
			}
		}
		if (startTask == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {

		boolean result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		System.out.println("Tasks execution possible: " + result);

		result = isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
		System.out.println("Tasks execution possible: " + result);

		result = isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
				new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println("Tasks execution possible: " + result);
	}

}
