package com.ankit.data.structures.sorting;

public class InsertionSort {
	static int counter = 0;

	public static void main(String[] args) {

		int[] array = { 5, 2, 4, 3, 6, 1, 99, 101, 88, 67, 34, 2, 4, 99, -1 };
			//{ 5, 2, 4, 6, 1, 3 };

		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
				counter++;
			}
			array[i + 1] = key;
			counter++;
		}
		for (int i : array) {
			System.out.print(i + " , ");
		}
		System.out.println("\n" + "no of computations : " + counter);

		// TODO Auto-generated method stub

	}
}
