package basic_class_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.SortComparator;

/**
 * 两个数组， A有序，B无序 打印在A 中不在B 中的数 要求实现时间复杂度O(M*logN)
 */
public class Code_10_GetAllNotIncluded {

	/**
	 * @param A 有序数组
	 * @param B 无序数组
	 * @return
	 */
	public static List<Integer> getAllNotInclude(int[] A, int[] B) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < B.length; ++i) {
			int left = 0;
			int right = A.length - 1;
			boolean isContains = false;

			while (left <= right) {
				int mid = (right + left) / 2;
				if (A[mid] > B[i]) {
					right = mid - 1;
				} else if (A[mid] < B[i]) {
					left = mid + 1;
				} else {
					isContains = true;
					break;
				}
			}
			if (!isContains) {
				res.add(B[i]);
			}
		}

		return res;
	}

	/**
	 * 
	 * @param A 有序数组
	 * @param B 无序数组
	 * @return
	 */
	public static List<Integer> comparator(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < B.length; ++i) {
			boolean isContains = false;
			for (int j = 0; j < A.length; ++j) {
				if (A[j] == B[i]) {
					isContains = true;
				}
			}
			if (!isContains) {
				res.add(B[i]);
			}
		}
		return res;
	}

	public static boolean isEqual(List<Integer> list1, List<Integer> list2) {
		if (list1 == null && list2 == null) {
			return true;
		}
		if ((list1 == null && list2 != null) || (list1 != null && list2 == null)) {
			return false;
		}
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int i = 0; i < list1.size(); ++i) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int testTime = 500000;
		int sortedArrayMaxSize = 300;
		int unsortedArrayMaxSize = 10;
		int maxValue = 100;
		boolean succeed = true;

		for (int i = 0; i < testTime; ++i) {
			int[] A = SortComparator.generateRandomArray(maxValue, sortedArrayMaxSize);
			int[] B = SortComparator.generateRandomArray(maxValue, unsortedArrayMaxSize);
			Arrays.sort(A);
			List<Integer> res1 = getAllNotInclude(A, B);
			List<Integer> res2 = comparator(A, B);

			if (!isEqual(res1, res2)) {
				System.out.println(Arrays.toString(A));
				System.out.println(Arrays.toString(B));
				System.out.println(res1);
				System.out.println(res2);
				succeed = false;
				break;
			}
		}

		System.out.println(succeed ? "NICE" : "FUCK");
	}
}
