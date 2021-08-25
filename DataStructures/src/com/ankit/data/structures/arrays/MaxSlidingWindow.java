package com.ankit.data.structures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 
 * @author ankit
 * Given an array of integers, find the maximum value in a window.
 *
 */
class MaxSlidingWindow {
	
	/*
	 * Time Complexity: O(n * k) where n->size of array & k->windowSize.
	 * Space Complexity: O(1)
	 */
	public static ArrayList<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i <= arr.length - windowSize; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < i + windowSize; j++) {
				if (arr[j] > max)
					max = arr[j];
			}
			result.add(max);
		}
		return result;
	}

	/*
	 * Time Complexity: O(nlogk) where n->size of array & k->windowSize.
	 * Insertion, deletion and search takes logn time in PriorityQueue. 
	 * Space Complexity: O(k)
	 */
	public static ArrayList<Integer> findMaxSlidingWindow_PriorityQueue(int[] arr, int windowSize) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < windowSize; i++) {
			priorityQueue.add(arr[i]);
		}
		result.add(priorityQueue.peek());
		priorityQueue.remove(arr[0]);
		for (int i = windowSize; i < arr.length; i++) {
			priorityQueue.add(arr[i]);
			result.add(priorityQueue.peek());
			priorityQueue.remove(arr[(i - windowSize) + 1]);
		}
		return result;
	}

	/*
	 * Time Complexity: O(n).
	 * It can be observed that every element of array is
	 * added and removed at most once. So there are total 2n operations.
	 * Space complexity: O(k).
	 */
	public static ArrayList<Integer> findMaxSlidingWindow_Deque(int[] arr, int windowSize) {
		Deque<Integer> deque = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < windowSize; i++) {
			while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}
		result.add(arr[deque.getFirst()]);
		for (int i = windowSize; i < arr.length; i++) {
			while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
			deque.remove(i - windowSize);
			result.add(arr[deque.getFirst()]);
		}
		return result;
	}

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
		int windowSize = 4;
		System.out.println(findMaxSlidingWindow(arr, windowSize));
		System.out.println(findMaxSlidingWindow_PriorityQueue(arr, windowSize));
		System.out.println(findMaxSlidingWindow_Deque(arr, windowSize));
	}
}
