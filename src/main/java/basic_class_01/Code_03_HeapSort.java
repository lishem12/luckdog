package basic_class_01;


import utils.SortComparator;

/**
 * 堆排序
 */
public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; ++i) {
			heapInsert(arr, i);
		}

		for (int i = arr.length - 1; i > 0; --i) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}

	}

	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int maxIndex = arr[index] > arr[left] ? index : left;
			maxIndex = left + 1 == size ? maxIndex : (arr[maxIndex] > arr[left + 1] ? maxIndex : left + 1);
			if (maxIndex == index) {
				return;
			}
			swap(arr, maxIndex, index);
			index = maxIndex;
			left = index * 2 + 1;
		}

	}

	public static void heapInsert(int[] arr, int index) {
		while (index > 0) {
			int parent = (index - 1) / 2;
			if (arr[index] > arr[parent]) {
				swap(arr, index, parent);
			}
			index = parent;
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
			heapSort(arr1);
			SortComparator.comparator(arr2);
			if (!SortComparator.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
