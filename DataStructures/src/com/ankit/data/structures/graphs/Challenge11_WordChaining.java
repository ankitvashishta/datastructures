package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Figure out whether the given words can form a circular chain. Assume that a
 * single word can never form a chain.
 * 
 * Two words can be chained together if the first word’s last letter is equal to
 * the second word’s first letter. We are given a list of words and we need to
 * figure out if all the words can be chained together or not. Let’s assume that
 * all the words are lower case.
 * 
 * Example 1 : Input -> [eve, eat, ripe, tear]
 * 
 * Output : true
 * 
 * Example 2 : Input -> [deg, fed]
 * 
 * Output : false
 * 
 * Note : Please see how the words are inserted in graph -> createGraph method.
 * 
 * @author ankit
 *
 */
public class Challenge11_WordChaining {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("eve", "eat", "ripe", "tear"));
		graph g = new graph(new ArrayList<vertex>());
		g.createGraph(list);
		boolean result = g.canChainWords(list.size());
		String output = result == true ? "true" : "false";
		System.out.println(output);
	}
}

/*
 * The runtime complexity of the generate_graph method is quadratic, O(n^2)
 * 
 * The runtime complexity of the check_cycle_rec method is factorial, O(n!).
 * 
 * Therefore, the recurrence relation for time complexity is:
 * 
 * T(n) = O(n) + nT(n-1)
 */
class graph {
	private List<vertex> g;

	boolean canChainWords(int list_size) {
		Map<Character, Boolean> visitedMap = new HashMap<>();
		vertex v = g.get(0);
		visitedMap.put(v.getValue(), true);
		while (visitedMap.keySet().size() < list_size) {
			if (visitedMap.keySet().size() == g.size())
				return true;
			if (!visitedMap.containsKey(v.getValue()))
				visitedMap.put(v.getValue(), true);
			List<vertex> adjVertices = v.getAdj_vertices();
			for (vertex adjVertex : adjVertices) {
				if (!visitedMap.containsKey(adjVertex.getValue())) {
					v = adjVertex;
					if (v.getAdj_vertices().size() == 0)
						return false;
					break;
				}
			}
		}
		return false;
	}

	public graph(List<vertex> g) {
		super();
		this.g = g;
	}

	public List<vertex> getG() {
		return g;
	}

	void setG(List<vertex> g) {
		this.g = g;
	}

	// This method creates a graph from a list of words. A node of
	// the graph contains a character representing the start or end
	// character of a word.
	void createGraph(List<String> words_list) {
		for (int i = 0; i < words_list.size(); i++) {
			String word = words_list.get(i);
			char start_char = word.charAt(0);
			char end_char = word.charAt(word.length() - 1);

			vertex start = vertexExists(start_char);
			if (start == null) {
				start = new vertex(start_char, false);
				g.add(start);
			}

			vertex end = vertexExists(end_char);
			if (end == null) {
				end = new vertex(end_char, false);
				g.add(end);
			}

			// Add an edge from start vertex to end vertex
			addEdge(start, end);
		}
	}

	// This method returns the vertex with a given value if it
	// already exists in the graph, returns NULL otherwise
	vertex vertexExists(char value) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getValue() == value) {
				return g.get(i);
			}
		}
		return null;
	}

	// This method returns TRUE if all nodes of the graph have
	// been visited
	boolean allVisited() {
		for (int i = 0; i < getG().size(); i++) {
			if (getG().get(i).isVisited() == false) {
				return false;
			}
		}
		return true;
	}

	// This method adds an edge from start vertex to end vertex by
	// adding the end vertex in the adjacency list of start vertex
	// It also adds the start vertex to the in_vertices of end vertex
	void addEdge(vertex start, vertex end) {
		start.getAdj_vertices().add(end);
		end.getIn_vertices().add(start);
	}
}

class vertex {
	private char value;
	private boolean visited;
	private List<vertex> adj_vertices;
	private List<vertex> in_vertices;

	public vertex(char value, boolean visited) {
		this.value = value;
		this.visited = visited;
		this.adj_vertices = new ArrayList<vertex>();
		this.in_vertices = new ArrayList<vertex>();
	}

	char getValue() {
		return value;
	}

	void setValue(char value) {
		this.value = value;
	}

	boolean isVisited() {
		return visited;
	}

	void setVisited(boolean visited) {
		this.visited = visited;
	}

	List<vertex> getAdj_vertices() {
		return this.adj_vertices;
	}

	List<vertex> getIn_vertices() {
		return this.in_vertices;
	}
}
