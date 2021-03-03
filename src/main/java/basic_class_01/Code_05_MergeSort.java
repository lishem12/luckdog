package basic_class_01;

import utils.SortComparator;

public class Code_05_MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + ((right - left) >> 2);
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, right, mid);
	}

	public static void merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		int index = 0;
		int l = left;
		int r = mid + 1;
		while (l <= mid && r <= right) {
			help[index++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
		}
		while (l <= mid) {
			help[index++] = arr[l++];
		}
		while (r <= right) {
			help[index++] = arr[r++];
		}
		for (index = 0; index < help.length; ++index) {
			arr[left + index] = help[index];
		}
	}

	public static void main(String[] args) {
		int maxSize = 20;
		int maxValue = 200;
		int testTime = 500000;
		boolean succeed = true;

		for (int i = 0; i < testTime; ++i) {
			int[] arr1 = SortComparator.generateRandomArray(maxSize, maxValue);
			int[] arr2 = SortComparator.copyArray(arr1);
			mergeSort(arr1);
			SortComparator.comparator(arr2);
			if (!SortComparator.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
