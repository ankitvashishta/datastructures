package com.ankit.data.structures.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a graph, find its mother vertex.
 * 
 * Example : graph = { 
 * 						3 -> 0 
 * 						3 -> 1 
 * 						0 -> 1 
 * 						1 -> 2 
 * 					} 
 * 
 * Output : 3
 * 
 * @author ankit
 *
 */
public class Challenge4_CheckMotherVertex {

	/*
	 * Runtime Complexity : O(V + E)
	 */
	public static int findMotherVertex(Graph g) {
		if (hasLoop(g))
			return 0;
		DoublyLinkedList<Integer> adjacencyList[] = g.adjacencyList;
		Set<Integer> destination = new HashSet<>();
		int vertices = g.vertices;
		for (int i = 0; i < vertices; i++) {
			DoublyLinkedList<Integer> currList = adjacencyList[i];
			DoublyLinkedList<Integer>.Node currNode = currList.getHeadNode();
			while (currNode != null) {
				destination.add(currNode.data);
				currNode = currNode.nextNode;
			}
		}
		for (int i = 0; i < vertices; i++) {
			if (!destination.contains(i) && adjacencyList[i].getHeadNode() != null)
				return i;
		}
		return -1;
	}

	private static boolean hasLoop(Graph g) {
		int vertices = g.vertices;
		Set<Integer> visitedNodes = new HashSet<>();

		for (int i = 0; i < vertices; i++) {
			if (!visitedNodes.contains(i)) {
				Set<Integer> currStack = new HashSet<>();
				boolean loopExists = traverseNode(g, i, visitedNodes, currStack);
				if (loopExists)
					return loopExists;
			}
		}
		return false;
	}

	private static boolean traverseNode(Graph g, Integer node, Set<Integer> visitedNodes, Set<Integer> currStack) {
		visitedNodes.add(node);
		if (currStack.contains(node))
			return true;
		currStack.add(node);

		DoublyLinkedList<Integer>[] adjacencyList = g.adjacencyList;
		DoublyLinkedList<Integer> currList = adjacencyList[node];
		DoublyLinkedList<Integer>.Node currNode = currList.getHeadNode();

		while (currNode != null) {
			boolean loopExists = traverseNode(g, currNode.data, visitedNodes, currStack);
			if (loopExists)
				return loopExists;
			currStack.remove(currNode.data);
			currNode = currNode.nextNode;
		}
		return false;
	}

	public static void main(String args[]) {

		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(3, 0);
		g.addEdge(3, 1);
		g.printGraph();
		System.out.println("Mother Vertex is: " + findMotherVertex(g));

	}

}
