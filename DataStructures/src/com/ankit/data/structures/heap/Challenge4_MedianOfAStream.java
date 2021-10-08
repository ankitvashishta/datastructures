package com.ankit.data.structures.heap;

import java.util.PriorityQueue;

/**
 * Design a class to calculate the median of a number stream. If the count of
 * numbers inserted in the class is even, the median will be the average of the
 * middle two numbers.
 * 
 * 1. We can store the first half of numbers (i.e., smallNumList) in a Max Heap.
 * We should use a Max Heap as we are interested in knowing the largest number
 * in the first half.
 * 
 * 2. We can store the second half of numbers (i.e., largeNumList) in a Min
 * Heap, as we are interested in knowing the smallest number in the second half.
 * 
 * 3. Inserting a number in a heap will take O(logN).
 * 
 * 4. At any time, the median of the current list of numbers can be calculated
 * from the top element of the two heaps
 * 
 * @author ankit
 *
 */
public class Challenge4_MedianOfAStream {

	PriorityQueue<Integer> maxHeap;
	PriorityQueue<Integer> minHeap;

	public Challenge4_MedianOfAStream() {
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	/*
	 * Time Complexity : O(logn)
	 * 
	 * Space Complexity : O(n) - as at any time, we'll be storing those numbers.
	 */
	public void insertNum(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num)
			maxHeap.add(num);
		else
			minHeap.add(num);

		if (maxHeap.size() > (minHeap.size() + 1))
			minHeap.add(maxHeap.poll());
		else if (minHeap.size() > maxHeap.size())
			maxHeap.add(minHeap.poll());
	}

	/*
	 * Time Complexity : O(1), as we can find the median from the top elements of
	 * the heaps.
	 */
	public double findMedian() {
		if (maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		else
			return maxHeap.peek();

	}

	public static void main(String[] args) {
		Challenge4_MedianOfAStream medianOfAStream = new Challenge4_MedianOfAStream();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}
}
