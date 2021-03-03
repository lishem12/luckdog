package basic_class_01;

import utils.SortComparator;

/**
 * 随机快排
 */
public class Code_04_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int[] help = partation(arr, left, right);
		quickSort(arr, left, help[0]);
		quickSort(arr, help[1], right);
	}

	public static int[] partation(int[] arr, int left, int right) {
		int index = (int) (Math.random() * (right - left)) + left;
		swap(arr, index, right);
		int more = right;
		int less = left - 1;
		index = left;
		while (index != more) {
			if (arr[index] < arr[right]) {
				swap(arr, ++less, index++);
			} else if (arr[index] == arr[right]) {
				++index;
			} else {
				swap(arr, index, --more);
			}
		}
		swap(arr, index, right);
		return new int[] { less, ++more};
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
			quickSort(arr1);
			SortComparator.comparator(arr2);
			if (!SortComparator.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
