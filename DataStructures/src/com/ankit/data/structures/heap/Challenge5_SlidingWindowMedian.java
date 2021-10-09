package com.ankit.data.structures.heap;

import java.util.PriorityQueue;

public class Challenge5_SlidingWindowMedian {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public double[] findSlidingWindowMedian(int[] nums, int k) {
		double[] result = new double[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			addElement(nums[i]);
		}
		result[0] = getMedian();
		// TODO: Write your code here
		for (int i = k; i < nums.length; i++) {
			removeElement(nums[i - k]);
			addElement(nums[i]);
			result[i - (k - 1)] = getMedian();
		}
		return result;
	}

	private void removeElement(Integer i) {
		if (maxHeap.peek() >= i)
			maxHeap.remove(i);
		else
			minHeap.remove(i);
		reOrganizeHeaps();
	}

	private void addElement(Integer i) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= i)
			maxHeap.add(i);
		else
			minHeap.add(i);
		reOrganizeHeaps();
	}

	private void reOrganizeHeaps() {
		if (maxHeap.size() > (minHeap.size() + 1))
			minHeap.add(maxHeap.poll());
		else if (maxHeap.size() < minHeap.size())
			maxHeap.add(minHeap.poll());
	}

	private double getMedian() {
		if (maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		else
			return maxHeap.peek();
	}

	public static void main(String[] args) {
		Challenge5_SlidingWindowMedian slidingWindowMedian = new Challenge5_SlidingWindowMedian();
		double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
		System.out.println();

		slidingWindowMedian = new Challenge5_SlidingWindowMedian();
		result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
	}

}
