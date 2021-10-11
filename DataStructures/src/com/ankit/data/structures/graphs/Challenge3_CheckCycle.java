package com.ankit.data.structures.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a graph, check if it contains a cycle.
 * 
 * Example : graph = {
 * 						0 -> 1 
 * 						1 -> 2 
 * 						2 -> 0
 *  				 }
 *  
 *  Output : true.
 *  
 *  We use DFS to traverse the graph and store a stack to keep
 *  track of the nodes encountered during a node traversal call.
 *  If a node is encountered which is already in the stack, that
 *  means a cycle is found.
 * 
 * @author ankit
 *
 */
public class Challenge3_CheckCycle {

	/*
	 * Runtime Complexity : O(V + E) - this is complexity of traversing a graph
	 * using adjacency lists.
	 */
	public static boolean detectCycle(Graph g) {
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
		Graph g1 = new Graph(4);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(3, 0);
		g1.printGraph();
		System.out.println(detectCycle(g1));

		System.out.println();
		Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.printGraph();
		System.out.println(detectCycle(g2));
	}
}
