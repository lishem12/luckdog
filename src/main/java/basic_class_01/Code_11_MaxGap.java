package basic_class_01;

import java.util.Arrays;

import utils.SortComparator;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序。 分组比数组大 1 是为了消除组内的可能
 */
public class Code_11_MaxGap {

	public static int maxGap(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			max = max > arr[i] ? max : arr[i];
			min = min < arr[i] ? min : arr[i];
		}
		if (max == min) {
			return 0;
		}
		int[] maxNum = new int[arr.length + 1];
		int[] minNum = new int[arr.length + 1];
		boolean[] hasNum = new boolean[arr.length + 1];
		for (int i = 0; i < arr.length; ++i) {
			int index = arr.length * (arr[i] - min) / (max - min);
			maxNum[index] = hasNum[index] ? maxNum[index] > arr[i] ? maxNum[index] : arr[i] : arr[i];
			minNum[index] = hasNum[index] ? minNum[index] < arr[i] ? minNum[index] : arr[i] : arr[i];
			hasNum[index] = true;
		}

		int lastIndex = 0;
		int maxGap = Integer.MIN_VALUE;
		for(int i=1;i<maxNum.length;++i) {
			if(!hasNum[i]) {
				continue;
			}
			maxGap = maxGap> minNum[i] -maxNum[lastIndex]?maxGap:minNum[i] -maxNum[lastIndex];
			lastIndex = i;
		}
		return maxGap;
	}

	public static int comparator(int[] arr) {
		if(arr== null || arr.length<2) {
			return 0;
		}
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		for(int i=1;i<arr.length;++i) {
			max = max>arr[i]-arr[i-1]?max:arr[i]-arr[i-1];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int maxValue = 100;
        int maxSize = 100;
        int testTime = 500000;
        boolean succeed = true;
        
        for (int i = 0; i < testTime; ++i) {
            int[] arr = SortComparator.generateRandomArray(maxValue, maxSize);
            int[] arr2 = SortComparator.copyArray(arr);

            int gap1 = maxGap(arr);
            int gap2 = comparator(arr2);
            if (gap1 != gap2) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "NICE" : "OHNO");
	}
}
