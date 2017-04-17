package com.ankit.data.structures.sorting;

/**
 * @author Vashishta.Ankit
 * 
 * Working - Starting from the beginning of the list, compare every adjacent
 * pair, swap their position if they are not in the right order (the latter one
 * is smaller than the former one). After each iteration, one less element (the
 * last one) is needed to be compared until there are no more elements left to
 * be compared.
 * 
 * Example -  5, 4, 3, 2, 1(Sequence to be sorted.)
 * Cycle 1 :
 * (5, 4, 3, 2, 1) -> (4, 5, 3, 2, 1)
 * (4, 5, 3, 2, 1) -> (4, 3, 5, 2, 1)
 * (4, 3, 5, 2, 1) -> (4, 3, 2, 5, 1)
 * (4, 3, 2, 5, 1) -> (4, 3, 2, 1, 5)
 * Cycle 2:
 * (4, 3, 2, 1, 5) -> (3, 4, 2, 1, 5)
 * (3, 4, 2, 1, 5) -> (3, 2, 4, 1, 5)
 * (3, 2, 4, 1, 5) -> (3, 2, 1, 4, 5)
 * Cycle 3:
 * (3, 2, 1, 4, 5) -> (2, 3, 1, 4, 5)
 * (2, 3, 1, 4, 5) -> (2, 1, 3, 4, 5)
 * Cycle 4:
 * (2, 1, 3, 4, 5) -> (1, 2, 3, 4, 5)
 * 
 * The first Cycle starts with a loop starting with 
 * comparing first element with the second element.
 * This loop continues to make n-1 comparisons and 
 * hence positions the largest element.
 * 
 * The successive cycles have to make one comparison 
 * lesser from the previous cycle as they have one 
 * lesser element to position.
 * 
 * 
 *
 */

public class BubbleSort {

	public static int counter = 0;

	public static void main(String args[]) {
		Integer[] arr = { 5, 2, 4, 3, 6, 1, 99, 101, 88, 67, 34, 2, 4, 99, -1 };
		Integer[] arr1 = { 5, 2, 4, 3, 6, 1, 99, 101, 88, 67, 34, 2, 4, 99, -1 };
		System.out.println(arr.length);
		
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(arr);
		bubbleSort.printArray(arr);
		
		bubbleSort.bubbleSort_Incremental(arr1);
		bubbleSort.printArray(arr1);
	}

	private void sort(Integer arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				counter++;
				int key = arr[j];
				if (arr[j] < arr[j - 1]) {
					arr[j] = arr[j - 1];
					arr[j - 1] = key;
				}
			}
		}
	}

	private void bubbleSort_Incremental(Integer arr[]) {
		int arrayLengthLimit = arr.length - 1;
		for (int i = 0; i < arrayLengthLimit; i++) {
			for (int j = 0; j < arrayLengthLimit - i; j++) {
				counter++;
				int key = arr[j];
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j + 1];
					arr[j + 1] = key;
				}
			}
		}
	}
	
	private void printArray(Integer arr[]){
		System.out.println();
		for (Integer i : arr) {
			System.out.print(i + " , ");
		}
	}

}
// Check the first step of Bubble Sort
/*
 * int key = arr[i]; if (arr[i] > arr[i + 1]) { arr[i] = arr[i + 1]; arr[i + 1]
 * = key; }
 */
