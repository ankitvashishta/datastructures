package com.ankit.data.structures.graphs;

/**
 * Given a graph, find the number of edges in the graph.
 * 
 * graph = { 
 * 			0 - 1, 0 - 4,
 * 			1 - 2, 1 - 3,
 * 			4 - 2, 4 - 5,
 * 			2 - 5,
 * 			5 - 6, 5 - 7, 5 - 3,
 * 			6 - 7 
 * 		   }
 * 
 * Output : 11
 * 
 * @author ankit
 *
 */
public class Challenge5_CheckNumEdges {
	
	/*
	 * Runtime Complexity : O(V + E)
	 * 
	 * In an undirected graph, the number of edges is always even because the edges
	 * are bidirectional. Hence we divide the result by 2.
	 */
	public static int numEdges(Graph g) {
		int sum = 0;
		int vertices = g.vertices;
		DoublyLinkedList<Integer> adjacencyList[] = g.adjacencyList;
		DoublyLinkedList<Integer> currList = null;
		for (int i = 0; i < vertices; i++) {
			currList = adjacencyList[i];
			DoublyLinkedList<Integer>.Node currNode = currList.getHeadNode();
			while (currNode != null) {
				sum++;
				currNode = currNode.nextNode;
			}
		}
		return sum / 2;
	}

	public static void main(String args[]) {

		Graph g = new Graph(9);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(5, 3);
		g.addEdge(5, 6);
		g.addEdge(3, 6);
		g.addEdge(6, 7);
		g.addEdge(6, 8);
		g.addEdge(6, 4);
		g.addEdge(7, 8);

		g.printGraph();
		System.out.println("Number of edges: " + numEdges(g));
		System.out.println();

		Graph g2 = new Graph(7);
		g2.addEdge(1, 2);
		g2.addEdge(1, 3);
		g2.addEdge(3, 4);
		g2.addEdge(3, 5);
		g2.addEdge(2, 5);
		g2.addEdge(2, 4);
		g2.addEdge(4, 6);
		g2.addEdge(4, 5);
		g2.addEdge(6, 5);

		g2.printGraph();
		System.out.println("Number of edges: " + numEdges(g2));
	}
}
