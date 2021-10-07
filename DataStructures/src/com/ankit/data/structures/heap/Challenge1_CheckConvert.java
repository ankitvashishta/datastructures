package com.ankit.data.structures.heap;

import java.util.Arrays;

/**
 * Given a max heap, convert to min heap.
 * 
 * Example :
 *  Input - > [9,4,7,1,-2,6,5]
 *  Output -> [-2,1,5,9,4,6,7]
 * 
 * @author ankit
 *
 */
public class Challenge1_CheckConvert {

	/*
	 * Time Complexity : O(n)
	 */
	public static void convertMax(int[] maxHeap) {
		int midWay = (maxHeap.length - 1) / 2;
		for (int i = midWay; i >= 0; i--) {
			minHeapify(i, maxHeap);
		}
	}

	private static void minHeapify(int index, int[] maxHeap) {
		if (index > (maxHeap.length - 1) / 2)
			return;
		int min = index;
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		if (leftChild < maxHeap.length && maxHeap[leftChild] < maxHeap[min])
			min = leftChild;
		if (rightChild < maxHeap.length && maxHeap[rightChild] < maxHeap[min])
			min = rightChild;
		if (index != min) {
			int temp = maxHeap[index];
			maxHeap[index] = maxHeap[min];
			maxHeap[min] = temp;
			minHeapify(min, maxHeap);
		}
	}

	public static void main(String args[]) {
		int[] heapArray = { 9, 4, 7, 1, -2, 6, 5 };
		System.out.println("Max Heap: " + Arrays.toString(heapArray));
		convertMax(heapArray);
		System.out.println("Min Heap: " + Arrays.toString(heapArray));

	}

}
