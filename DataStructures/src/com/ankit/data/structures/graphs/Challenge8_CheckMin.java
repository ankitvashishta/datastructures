package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a directed graph, find the shortest distance between two nodes.
 * 
 * @author ankit
 *
 */
public class Challenge8_CheckMin {
	
	/*
	 * Time Complexity : O(V + E)
	 */
	public static int findShortestPathLength(Graph g, int source, int destination) {
		List<Integer> list = new ArrayList<>();
		traverse(g, source, destination, list, 0, new HashSet<Integer>());
		if (list.size() != 0) {
			Collections.sort(list);
			return list.get(0);
		}
		return -1;
	}

	private static void traverse(Graph g, int source, int destination, List<Integer> list, int max,
			Set<Integer> discoveredNodes) {
		if (source == destination) {
			list.add(max);
			return;
		}
		if (discoveredNodes.contains(source))
			return;
		discoveredNodes.add(source);
		DoublyLinkedList<Integer>[] adjacencyList = g.adjacencyList;
		DoublyLinkedList<Integer> currList = adjacencyList[source];
		DoublyLinkedList<Integer>.Node currNode = currList.getHeadNode();
		max++;
		while (currNode != null) {
			traverse(g, currNode.data, destination, list, max, discoveredNodes);
			currNode = currNode.nextNode;
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(1, 4);
		System.out.println(findShortestPathLength(g, 0, 4));
	}
}
