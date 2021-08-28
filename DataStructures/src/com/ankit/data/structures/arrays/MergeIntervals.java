package com.ankit.data.structures.arrays;

import java.util.ArrayList;

/**
 * Merge overlapping intervals in an array of interval pairs.
 * 
 * @author ankit
 *
 */
public class MergeIntervals {

	/*
	 * Runtime Complexity: O(n) where n is the size of the arrayList.
	 * Memory Complexity : O(1).
	 */
	static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		// write your code here
		for (int i = 0; i < (v.size() - 1); i++) {
			Pair pair = v.get(i);
			if (pair.second >= v.get(i + 1).first) {
				inner: while (pair.second >= v.get(i + 1).first) {
					pair = new Pair(pair.first, v.get(i + 1).second);
					if (i < (v.size() - 2))
						i++;
					else
						break inner;
				}
				result.add(pair);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Pair> v = new ArrayList<Pair>();

		v.add(new Pair(1, 5));
		v.add(new Pair(3, 7));
		v.add(new Pair(4, 6));
		v.add(new Pair(6, 8));
		v.add(new Pair(10, 12));
		v.add(new Pair(11, 15));

		ArrayList<Pair> result = mergeIntervals(v);

		for (int i = 0; i < result.size(); i++) {
			System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
		}
	}
}

class Pair {
	public int first;
	public int second;

	public Pair(int x, int y) {
		this.first = x;
		this.second = y;
	}
}
