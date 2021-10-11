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

	public static void main(String args[]) {

		Graph g1 = new Graph(9);
		g1.addEdge(0, 2);
		g1.addEdge(0, 5);
		g1.addEdge(2, 3);
		g1.addEdge(2, 4);
		g1.addEdge(5, 3);
		g1.addEdge(5, 6);
		g1.addEdge(3, 6);
		g1.addEdge(6, 7);
		g1.addEdge(6, 8);
		g1.addEdge(6, 4);
		g1.addEdge(7, 8);
		g1.printGraph();
		System.out.println("Path exists: " + checkPath(g1, 0, 7));
		System.out.println();
		Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(1, 3);
		g2.addEdge(2, 3);

		g2.printGraph();
		System.out.println("Path exists: " + checkPath(g2, 3, 0));
	}
}
