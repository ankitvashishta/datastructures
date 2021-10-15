package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a graph, find its topological sort. Topological Sort of a directed
 * graph (a graph with unidirectional edges) is a linear ordering of its
 * vertices such that for every directed edge (U, V) from vertex U to vertex V,
 * U comes before V in the ordering.
 * 
 * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
 * 
 * Output: Following are the two valid topological sorts for the given graph:
 * 
 * 1) 3, 2, 0, 1
 * 
 * 2) 3, 2, 1, 0
 * 
 * @author ankit
 *
 */
public class Challenge12_TopologicalSort {
	public static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedOrder = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = vertices - 1; i >= 0; i--) {
			if (!sortedOrder.contains(i))
				queue.offer(i);
			while (!queue.isEmpty()) {
				Integer currVertex = queue.poll();
				if (sortedOrder.contains(currVertex))
					sortedOrder.remove(currVertex);
				sortedOrder.add(currVertex);
				for (int[] edge : edges) {
					if (edge[0] == currVertex)
						queue.offer(edge[1]);
				}
			}
		}

		return sortedOrder;
	}

	public static void main(String[] args) {
		List<Integer> result = sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 },
				new int[] { 3, 1 } });
		System.out.println(result);

		result = sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 }, new int[] { 5, 4 },
				new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}
