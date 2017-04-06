package com.ankit.data.structures.exercise;

public class Exercises_SerachElement {

	public static void main(String args[]) {
		int[] sortedArray = {0, 1, 2, 2, 3, 4, 4, 5, 6, 34, 65, 88, 99, 99, 101 };

		// { -14, -11, -9, -7, -5, -3, -1, 11, 19, 22, 30, 44, 55 };
		int x = 101;
		Exercises_SerachElement ex = new Exercises_SerachElement();
		ex.getPositions(sortedArray, x);
	}

	private void getPositions(int[] arr, int element) {
		int elementPosition = -1;
		for (int j = 0; j < arr.length; j++) {
			int x = arr[j];
			if (x == element) {
				elementPosition = j;
			}
		}
		if (arr[0] < 0) {
			searchGeneral(arr, element, elementPosition);
		} else {
			searchForPositives(arr, element, elementPosition);
		}
	}

	public void searchForPositives(int[] arr, int element, int elementPosition) {
		int outerLoop = 0;
		outer: for (outerLoop = 0; outerLoop < elementPosition; outerLoop++) {
			inner: for (int innerLoop = elementPosition - 1; innerLoop > outerLoop; innerLoop--) {
				if (arr[outerLoop] + arr[innerLoop] == element) {
					System.out.println("the elements are : '" + arr[outerLoop]
							+ "' at position " + outerLoop + " and '"
							+ arr[innerLoop] + "' at position " + innerLoop);
					break outer;
				} else if (arr[outerLoop] + arr[innerLoop] < element) {
					continue outer;
				} else if (arr[outerLoop] + arr[innerLoop] > element) {
					continue inner;
				}
			}
		}
		if (outerLoop >= elementPosition) {
			System.out.println("Element not found");
		}
	}

	public void searchGeneral(int[] arr, int element, int elementPosition) {
		int outerLoop = 0;
		outer: for (outerLoop = 0; outerLoop < elementPosition; outerLoop++) {
			inner: for (int innerLoop = arr.length - 1; innerLoop > outerLoop; innerLoop--) {
				if (arr[outerLoop] + arr[innerLoop] == element) {
					System.out.println("the elements are : '" + arr[outerLoop]
							+ "' at position " + outerLoop + " and '"
							+ arr[innerLoop] + "' at position " + innerLoop);
					break outer;
				} else if (arr[outerLoop] + arr[innerLoop] < element) {
					continue outer;
				} else if (arr[outerLoop] + arr[innerLoop] > element) {
					continue inner;
				}
			}
		}
		if (outerLoop >= elementPosition) {
			System.out.println("Element not found");
		}
	}

}
