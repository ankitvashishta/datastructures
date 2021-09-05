package com.ankit.data.structures.arrays;

/**
 * Given an infinite sorted array (or an array with unknown size), find if a
 * given number ‘key’ is present in the array. Write a function to return the
 * index of the ‘key’ if it is present in the array, otherwise return -1.
 * 
 * Since it is not possible to define an array with infinite (unknown) size, you
 * will be provided with an interface ArrayReader to read elements of the array.
 * ArrayReader.get(index) will return the number at index; if the array’s size
 * is smaller than the index, it will return Integer.MAX_VALUE.
 * 
 * @author ankit
 *
 */
public class SearchInfiniteSortedArray {

	/*
	 * Runtime Complexity: O(logn)
	 * 
	 * The program takes O(logn) to get the upper bound and then O(logn) to search
	 * the element using binary serach. Asymptotically -> O(logn + logn) = O(logn)
	 * 
	 * Space Complexity: O(1).
	 */
	public static int search(ArrayReader reader, int key) {
		int start = 0;
		int end = 1;
		while (reader.get(end) < key) {
			start = end;
			end = end * 2;
		}
		return binarySearch(reader, key, start, end);
	}

	public static int binarySearch(ArrayReader reader, int key, int start, int end) {
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			int temp = reader.get(mid);
			if (key == temp)
				return mid;
			else if (temp < key)
				start = mid + 1;
			else
				end = mid;
		}
		if (reader.get(start) == key)
			return start;
		return -1;
	}

	public static void main(String[] args) {
		ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
		System.out.println(SearchInfiniteSortedArray.search(reader, 16));
		System.out.println(SearchInfiniteSortedArray.search(reader, 11));
		reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
		System.out.println(SearchInfiniteSortedArray.search(reader, 15));
		System.out.println(SearchInfiniteSortedArray.search(reader, 200));
	}
}

class ArrayReader {
	int[] arr;

	ArrayReader(int[] arr) {
		this.arr = arr;
	}

	public int get(int index) {
		if (index >= arr.length)
			return Integer.MAX_VALUE;
		return arr[index];
	}
}
