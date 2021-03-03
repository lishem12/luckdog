package basic_class_01;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 */
public class Code_08_NetherlandsFlag {

	public static int[] partition(int[] arr, int num) {
		if (arr == null) {
			return arr;
		}
		int index = 0;
		int more = arr.length;
		int less = -1;
		while (index != more) {
			if (arr[index] < num) {
				swap(arr, index++, ++less);
			} else if (arr[index] == num) {
				index++;
			} else {
				swap(arr, --more, index);
			}
		}
		return arr;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		System.out.println(Arrays.toString(test));
		int[] res = partition(test, 1);
		System.out.println(Arrays.toString(res));
	}

}
