package utils;

import java.util.Arrays;

public class SortComparator {

	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int size = (int) (maxSize * Math.random());
		int[] arr = new int[size];
		for (int i = 0; i < size; ++i) {
			arr[i] = (int) (Math.random() * (maxValue + 1) - Math.random() * maxValue);
		}
		return arr;
	}

	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; ++i) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] arr2 = new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		return arr2;
	}
}
