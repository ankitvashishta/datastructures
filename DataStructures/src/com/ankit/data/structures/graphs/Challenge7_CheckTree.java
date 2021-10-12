package com.ankit.data.structures.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a directed graph, check if it is a tree or not. Following are the
 * conditions to be a tree :
 * 
 * 1. Each node, except root, has exactly one parent
 * 
 * 2. Graph is connected.
 * 
 * 3. There are no cycles
 * 
 * For conditions 1 and 2, we do a BFS, and add the discovered nodes to a set.
 * If a node is encountered which is already discovered - means it has either
 * another parent or has a loop, so we return false. If by the end of traversal,
 * if the set of discovered nodes is not equal to the number of vertices in the
 * graph, that means the graph is not connected. And hence is not a tree.
 * 
 * For 3rd condition, we use DFS to check for a cycle.
 * 
 * @author ankit
 *
 */
public class Challenge7_CheckTree {

	/*
	 * Runtime Complexity : O(V + E)
	 */
	public static boolean isTree(Graph g) {
		Queue<Integer> currQueue = new Queue<>(g.vertices);
		currQueue.enqueue(0);
		Set<Integer> discoveredNodes = new HashSet<>();
		if (traverseGraphBFS(g, discoveredNodes, currQueue))
			if (discoveredNodes.size() == g.vertices && !detectCycle(g))
				return true;

		return false;
	}

	private static boolean traverseGraphBFS(Graph g, Set<Integer> discoveredNodes, Queue<Integer> currQueue) {
		if (currQueue.isEmpty())
			return true;
		Integer node = currQueue.dequeue();
		if (discoveredNodes.contains(node))
			return false;
		discoveredNodes.add(node);
		DoublyLinkedList<Integer>[] adjacencyList = g.adjacencyList;
		DoublyLinkedList<Integer> currList = adjacencyList[node];
		DoublyLinkedList<Integer>.Node currNode = currList.getHeadNode();
		while (currNode != null) {
			currQueue.enqueue(currNode.data);
			currNode = currNode.nextNode;
		}
		return traverseGraphBFS(g, discoveredNodes, currQueue);
	}

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

		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.printGraph();
		System.out.println("isTree : " + isTree(g));

		Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(0, 3);
		g2.addEdge(3, 2);
		g2.printGraph();
		System.out.println("isTree : " + isTree(g2));

		Graph g3 = new Graph(6);
		g3.addEdge(0, 1);
		g3.addEdge(0, 2);
		g3.addEdge(0, 3);
		g3.addEdge(4, 5);
		g3.printGraph();
		System.out.println("isTree : " + isTree(g3));
	}
}
