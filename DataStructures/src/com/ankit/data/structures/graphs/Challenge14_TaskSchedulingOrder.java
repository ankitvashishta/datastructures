package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some
 * prerequisite tasks which need to be completed before it can be scheduled.
 * Given the number of tasks and a list of prerequisite pairs, find the ordering
 * of tasks we should pick to finish all tasks.
 * 
 * Example 1 : Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
 * 
 * Output: [0, 1, 2]
 * 
 * Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
 * 
 * Output: []
 * 
 * This can be solved using TaskScheduling to find if cyclic dependency exists &
 * Topological sort to sort the tasks in the order of prerequisites.
 * 
 * @author ankit
 *
 */
public class Challenge14_TaskSchedulingOrder {
	public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
		List<Integer> sortedOrder = new ArrayList<>();
		Map<Integer, List<Integer>> dependencies = new HashMap<>();
		Set<Integer> completedTasks = new LinkedHashSet<>();
		if (!isSchedulingPossible(tasks, prerequisites, dependencies, completedTasks))
			return sortedOrder;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < tasks; i++) {
			if (!sortedOrder.contains(i))
				queue.offer(i);
			while (!queue.isEmpty()) {
				Integer currVertex = queue.poll();
				if (sortedOrder.contains(currVertex))
					sortedOrder.remove(currVertex);
				sortedOrder.add(currVertex);
				for (int[] edge : prerequisites) {
					if (edge[0] == currVertex)
						queue.offer(edge[1]);
				}
			}
		}
		return sortedOrder;
	}

	public static void main(String[] args) {
		List<Integer> result = findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
		System.out.println(result);
		result = findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
		System.out.println(result);
		result = findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
				new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println(result);
	}

	private static boolean isSchedulingPossible(int tasks, int[][] prerequisites,
			Map<Integer, List<Integer>> dependencies, Set<Integer> completedTasks) {
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
}
