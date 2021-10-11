package com.ankit.data.structures.graphs;

/**
 * Given a graph and 2 vertices, check if a path exists between them.
 * 
 * Here, we use DFS to find the path if exists between the vertices.
 * 
 * @author ankit
 *
 */
public class Challenge6_CheckPaths {

	/*
	 * Runtime Complexity : O(E + V).
	 */
	public static boolean checkPath(Graph g, int source, int destination) {
		return traverseNode(g, source, destination);
	}

	private static boolean traverseNode(Graph g, Integer node, int destination) {
		DoublyLinkedList<Integer>[] adjacencyList = g.adjacencyList;
		DoublyLinkedList<Integer> currList = adjacencyList[node];
		DoublyLinkedList<Integer>.Node currNode = currList.getHeadNode();

		while (currNode != null) {
			if (currNode.data == destination)
				return true;
			boolean pathExists = traverseNode(g, currNode.data, destination);
			if (pathExists)
				return pathExists;
			currNode = currNode.nextNode;
		}
		return false;
	}
}
