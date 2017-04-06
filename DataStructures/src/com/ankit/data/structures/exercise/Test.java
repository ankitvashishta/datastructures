package com.ankit.data.structures.exercise;

public class Test {

	public static void main(String args[]) {
		int[] array = { -1, 1, 2, 2, 3, 4, 4, 5, 6, 34, 67, 88, 99, 99, 101 };
		int element = 67;
		Test test = new Test();
		test.binarySearch(array, element);

	}

	private void binarySearch(int[] arr, int element) {
		int start = 0;
		int mid = arr.length / 2;
		int end = arr.length;
		while (true) {
			if (arr[mid] == element) {
				System.out.println("Position is : " + mid);
				break;
			} else if (element < arr[mid]) {
				end = mid;
				mid = (start + end) / 2;
				continue;
			} else if (element > arr[mid]) {
				start = mid;
				mid = (start + end) / 2;
				continue;
			}

		}

	}

}
