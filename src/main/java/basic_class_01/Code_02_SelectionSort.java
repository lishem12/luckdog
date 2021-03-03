package basic_class_01;

import utils.SortComparator;

/**
 * 选择排序
 */
public class Code_02_SelectionSort {

	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; ++i) {
			int minIndex = i;
			for (int j = i; j < arr.length; ++j) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, minIndex, i);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int maxSize = 20;
		int maxValue = 200;
		int testTime = 500000;
		boolean succeed = true;

		for (int i = 0; i < testTime; ++i) {
			int[] arr1 = SortComparator.generateRandomArray(maxSize, maxValue);
			int[] arr2 = SortComparator.copyArray(arr1);
			selectionSort(arr1);
			SortComparator.comparator(arr2);
			if (!SortComparator.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}

}
