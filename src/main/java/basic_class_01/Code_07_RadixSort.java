package basic_class_01;

import utils.SortComparator;

/**
 * 基数排序(桶排序)
 */
public class Code_07_RadixSort {

	public static void radixSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		radixSort(arr, 0, arr.length - 1, maxbits(arr));
	}

	public static void radixSort(int[] arr, int left, int right, int digits) {
		int[] count = new int[10]; // 用于统计的桶
		int[] help = new int[right - left + 1];
		for (int d = 1; d <= digits; ++d) {
			// 桶清零
			for (int i = 0; i < count.length; ++i) {
				count[i] = 0;
			}
			// 桶计数
			for (int i = left; i <= right; ++i) {
				++count[getDigit(arr[i], d)];
			}
			// 桶累加
			for (int i = 1; i < count.length; ++i) {
				count[i] += count[i - 1];
			}
			// 往 help 数组里倒腾
			for (int i = right; i >= left; --i) {
				help[--count[getDigit(arr[i], d)]] = arr[i];
			}
			// 复制回来
			for (int i = 0; i < help.length; ++i) {
				arr[left + i] = help[i];
			}
		}
	}

	public static int getDigit(int num, int d) {
		return (num / (int) Math.pow(10, d - 1) % 10);
	}

	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			max = max > arr[i] ? max : arr[i];
		}
		int count = 0;
		while (max != 0) {
			++count;
			max /= 10;
		}
		return count;
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
			radixSort(arr1);
			SortComparator.comparator(arr2);
			if (!SortComparator.isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
