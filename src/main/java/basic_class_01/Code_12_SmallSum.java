package basic_class_01;

import java.util.Arrays;

import utils.SortComparator;

/**
 * 小和问题
 */
public class Code_12_SmallSum {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return smallSum(arr, 0, arr.length - 1);
	}

	public static int smallSum(int[] arr, int left, int right) {
		if (left >= right) {
			return 0;
		}
		int mid = left + (right - left) / 2;
		return smallSum(arr, left, mid) + smallSum(arr, mid + 1, right) + merge(arr, left, right, mid);
	}

	public static int merge(int[] arr, int left, int right, int mid) {
		int[] help = new int[right - left + 1];
		int l = left;
		int r = mid + 1;
		int smallSum = 0;
		int index = 0;
		while (l <= mid && r <= right) {
			smallSum += arr[l] < arr[r] ? arr[l] * (right - r+ 1)  : 0;
			help[index++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
		}
		while (l <= mid) {
			help[index++] = arr[l++];
		}
		while (r <= right) {
			help[index++] = arr[r++];
		}
		for (int i = 0; i < help.length; ++i) {
			arr[left++] = help[i];
		}
		return smallSum;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int comparator(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int smallSum = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i]) {
					smallSum += arr[j];
				}
			}
		}
		return smallSum;
	}

	public static void main(String[] args) {
		int maxValue = 200;
		int maxSize = 20;
		int testTime = 500000;
		boolean succeed = true;

		for (int i = 0; i < testTime; ++i) {
			int[] arr1 = SortComparator.generateRandomArray(maxSize, maxValue);
			int[] arr2 = SortComparator.copyArray(arr1);

			int smallSum1 = smallSum(arr1);
			int smallSum2 = comparator(arr2);
			if (smallSum1 != smallSum2) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
