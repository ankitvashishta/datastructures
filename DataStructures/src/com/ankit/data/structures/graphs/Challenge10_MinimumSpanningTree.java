package com.ankit.data.structures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a graph - set of vertices and edges(with weight), find the minimum
 * spanning tree. A spanning-tree of a connected, undirected graph is a subgraph
 * that is a tree and connects all the vertices.
 * 
 * Here, we use Prim's algo - we start with a vertex, and as we encounter any
 * vertex, mark it as visited. Next, we iterate through the edges and the
 * minimum weighted edge from the source vertex which is discovered is picked
 * up. As we mark the edge and its destination as visited, we add the weight of
 * the edge to the weight of mst. We iterate till all the vertices have been
 * discovered.
 * 
 * Runtime COmplexity : The runtime complexity of this solution is quadratic,
 * O(n^2) Here, n is the number of vertices.
 * 
 * Memory Complexity : O(n + e) where n -> vertices, e -> edges.
 * 
 * @author ankit
 *
 */
public class Challenge10_MinimumSpanningTree {

	static class graph {
		private List<vertex> g; // vertices
		private List<edge> e; // edges

		int findMinSpanningTree() {
			vertex root = g.get(0);
			root.setVisited(true);
			int visitedNodes = 1;
			int weight = 0;

			while (visitedNodes < g.size()) {
				edge minimum = null;
				for (int i = 0; i < e.size(); i++) {
					if (e.get(i).isVisited() == false) {
						if (e.get(i).getSrc().isVisited() == true && e.get(i).getDest().isVisited() == false) {
							if (minimum == null || minimum.getWeight() > e.get(i).getWeight())
								minimum = e.get(i);
						}
					}
				}
				minimum.setVisited(true);
				weight += minimum.getWeight();
				minimum.getDest().setVisited(true);
				visitedNodes++;
			}
			return weight;
		}

		public graph(List<vertex> g, List<edge> e) {
			super();
			this.g = g;
			this.e = e;
		}

		public List<vertex> getG() {
			return g;
		}

		public void setG(List<vertex> g) {
			this.g = g;
		}

		public List<edge> getE() {
			return e;
		}

		public void setE(List<edge> e) {
			this.e = e;
		}

		// This method returns the vertex with a given id if it
		// already exists in the graph, returns NULL otherwise
		vertex vertexExists(int id) {
			for (int i = 0; i < g.size(); i++) {
				if (g.get(i).getId() == id) {
					return g.get(i);
				}
			}
			return null;
		}

		// This method generates the graph with v vertices
		// and e edges
		void generateGraph(int vertices, List<ArrayList<Integer>> edges) {
			// create vertices
			for (int i = 0; i < vertices; i++) {
				vertex v = new vertex(i + 1, false);
				g.add(v);
			}

			// create edges
			for (int i = 0; i < edges.size(); i++) {
				vertex src = vertexExists(edges.get(i).get(1));
				vertex dest = vertexExists(edges.get(i).get(2));
				edge e = new edge(edges.get(i).get(0), false, src, dest);
				getE().add(e);
			}
		}

		String printGraph() {
			String result = "";

			for (int i = 0; i < e.size(); i++) {
				result += e.get(i).getSrc().getId() + "->" + e.get(i).getDest().getId() + "[" + e.get(i).getWeight()
						+ ", " + e.get(i).isVisited() + "]  ";
			}
			return result;
		}

		void printMst(int w) {
			System.out.println("MST");
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i).isVisited() == true) {
					System.out.println(e.get(i).getSrc().getId() + "->" + e.get(i).getDest().getId());
				}
			}
			System.out.println("weight: " + w);
			System.out.println();
		}
	}

	static class vertex {
		private int id;
		private boolean visited;

		public vertex(int id, boolean visited) {
			super();
			this.id = id;
			this.visited = visited;
		}

		int getId() {
			return id;
		}

		void setId(int id) {
			this.id = id;
		}

		boolean isVisited() {
			return visited;
		}

		void setVisited(boolean visited) {
			this.visited = visited;
		}
	}

	static class edge {
		private int weight;
		private boolean visited;
		private vertex src;
		private vertex dest;

		public edge(int weight, boolean visited, vertex src, vertex dest) {
			this.weight = weight;
			this.visited = visited;
			this.src = src;
			this.dest = dest;
		}

		int getWeight() {
			return weight;
		}

		void setWeight(int weight) {
			this.weight = weight;
		}

		boolean isVisited() {
			return visited;
		}

		void setVisited(boolean visited) {
			this.visited = visited;
		}

		vertex getSrc() {
			return src;
		}

		void setSrc(vertex src) {
			this.src = src;
		}

		vertex getDest() {
			return dest;
		}

		void setDest(vertex dest) {
			this.dest = dest;
		}
	}

	public static void testGraph1() {
		graph g = new graph(new ArrayList<vertex>(), new ArrayList<edge>());
		int v = 5;

		// each edge contains the following: weight, src, dest
		ArrayList<Integer> e1 = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
		ArrayList<Integer> e2 = new ArrayList<Integer>(Arrays.asList(1, 1, 3));
		ArrayList<Integer> e3 = new ArrayList<Integer>(Arrays.asList(2, 2, 3));
		ArrayList<Integer> e4 = new ArrayList<Integer>(Arrays.asList(3, 2, 4));
		ArrayList<Integer> e5 = new ArrayList<Integer>(Arrays.asList(3, 3, 5));
		ArrayList<Integer> e6 = new ArrayList<Integer>(Arrays.asList(2, 4, 5));

		List<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		e.add(e6);

		g.generateGraph(v, e);
		System.out.println("Testing graph 1...");
		// g.printGraph();
		int w = g.findMinSpanningTree();
		g.printMst(w);
	}

	public static void testGraph2() {
		graph g = new graph(new ArrayList<vertex>(), new ArrayList<edge>());
		int v = 7;

		// each edge contains the following: weight, src, dest
		ArrayList<Integer> e1 = new ArrayList<Integer>(Arrays.asList(2, 1, 4));
		ArrayList<Integer> e2 = new ArrayList<Integer>(Arrays.asList(1, 1, 3));
		ArrayList<Integer> e3 = new ArrayList<Integer>(Arrays.asList(2, 1, 2));
		ArrayList<Integer> e4 = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
		ArrayList<Integer> e5 = new ArrayList<Integer>(Arrays.asList(3, 2, 4));
		ArrayList<Integer> e6 = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
		ArrayList<Integer> e7 = new ArrayList<Integer>(Arrays.asList(2, 4, 7));
		ArrayList<Integer> e8 = new ArrayList<Integer>(Arrays.asList(1, 5, 6));
		ArrayList<Integer> e9 = new ArrayList<Integer>(Arrays.asList(2, 5, 7));

		List<ArrayList<Integer>> e = new ArrayList<ArrayList<Integer>>();
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		e.add(e6);
		e.add(e7);
		e.add(e8);
		e.add(e9);

		g.generateGraph(v, e);
		System.out.println("Testing graph 2...");
		// g.printGraph();
		int w = g.findMinSpanningTree();
		g.printMst(w);
	}

	public static void main(String[] args) {
		testGraph1();
		testGraph2();
	}

}
