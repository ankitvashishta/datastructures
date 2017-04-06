package com.ankit.data.structures.exercise;

public class Test1 {
	public static void main(String args[]) {
		int[] array = { -1, 1, 3, 5, 7, 9, 11, 34, 67, 88, 99, 101 };
		// { -1, 1, 2, 2, 3, 4, 4, 5, 6, 34, 67, 88, 99, 99, 101 };
		int element = 1;
		Test1 test = new Test1();
		int position = test.binarySearch(array, element);
		System.out.println("Position is : " + position);
	}

	private int binarySearch(int[] arr, int element) {
		int start = 0;
		int mid = arr.length / 2;
		int end = arr.length;
		while (true) {
			if (arr[mid] == element) {
				int i = 0;
				for (i = mid; i < end; i++) {
					if (arr[i] == element)
						continue;
					else
						break;
				}
				return i;
			} else if (element < arr[mid]) {
				if (end == mid || start == mid) {
					return mid;
				}
				end = mid;
				mid = (start + end) / 2;
				continue;
			} else if (element > arr[mid]) {
				if (end == mid || start == mid) {
					return mid + 1;
				}
				start = mid;
				mid = (start + end) / 2;
				continue;
			}
		}
	}
}
