package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Given the root node of a directed graph, clone this graph by creating its
 * deep copy so that the cloned graph has the same vertices and edges as the
 * original graph.
 * 
 * Assumption : it is a connected graph.
 * 
 * We use DFS here.
 * 
 * @author ankit
 *
 */
public class Challenge9_CloneGraph {
	public static Node clone(Node root) {
		Map<Integer, Node> traversedNodes = new HashMap<>();
		return traverse(root, traversedNodes);
	}

	public static Node traverse(Node node, Map<Integer, Node> traversedNodes) {
		if (node == null)
			return null;
		if (traversedNodes.containsKey(node.data))
			return traversedNodes.get(node.data);
		Node newNode = new Node(node.data);
		traversedNodes.put(newNode.data, newNode);
		for (Node tempNode : node.neighbors) {
			Node temp = traverse(tempNode, traversedNodes);
			if (temp != null)
				newNode.neighbors.add(temp);
		}
		return newNode;
	}

}

class Node {
	public int data;
	public List<Node> neighbors = new ArrayList<Node>();

	public Node(int d) {
		data = d;
	}
}
