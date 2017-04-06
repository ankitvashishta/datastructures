package com.ankit.data.structures.sorting;

public class BubbleSort {

	public static int counter = 0;

	public static void main(String args[]) {
		Integer[] arr = { 5, 2, 4, 3, 6, 1, 99, 101, 88, 67, 34, 2, 4, 99, -1 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(arr);
		for (Integer i : arr) {
			System.out.print(i + " , ");
		}
		//System.out.println("\n" + counter);
	}

	private void bubbleSort(Integer arr[]) {
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
}
//Check the first step of Bubble Sort
/*int key = arr[i];
if (arr[i] > arr[i + 1]) {
	arr[i] = arr[i + 1];
	arr[i + 1] = key;
}*/
