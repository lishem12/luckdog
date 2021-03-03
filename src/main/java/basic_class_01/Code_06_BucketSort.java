package basic_class_01;

import utils.SortComparator;

/**
 * 	计数排序，不能出现负数
 */
public class Code_06_BucketSort {

	public static void bucketSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			max = arr[i] > max ? arr[i] : max;
		}
		int[] help = new int[max + 1];
		for (int i = 0; i < arr.length; ++i) {
			++help[arr[i]];
		}
		for (int i = 0, index = 0; i < help.length; ++i) {
			while (help[i]-- != 0) {
				arr[index++] = i;
			}
		}
	}

	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int size = (int) (Math.random() * maxSize);
		int[] arr = new int[size];
		for (int i = 0; i < size; ++i) {
			arr[i] = (int) (Math.random() * maxValue);
		}
		return arr;
	}

	public static void main(String[] args) {
		int maxSize = 20;
		int maxValue = 200;
		int testTime = 500000;
		boolean succeed = true;

		for (int i = 0; i < testTime; ++i) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = SortComparator.copyArray(arr1);
			bucketSort(arr1);
			SortComparator.comparator(arr2);
			if (!SortComparator.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
