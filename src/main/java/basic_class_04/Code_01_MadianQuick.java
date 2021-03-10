package basic_class_04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import utils.SortComparator;

//有一个源源不断地吐出整数的数据流，假设你有足够的空间来
//保存吐出的数。请设计一个名叫MedianHolder的结构，
//MedianHolder可以随时取得之前吐出所有数的中位数。
//【要求】
//1．如果MedianHolder已经保存了吐出的N个数，那么任意时刻
//将一个新数加入到MedianHolder的过程，其时间复杂度是O(logN)。
//2．取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)。
// 如果个数是偶数，返回均值
public class Code_01_MadianQuick {

	public static class MedianHolder {
		private PriorityQueue<Integer> minHeap;
		private PriorityQueue<Integer> maxHeap;

		public MedianHolder() {
			minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			});

			maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		}

		public void addNumber(int num) {
			if (maxHeap.isEmpty()) {
				maxHeap.add(num);
				return;
			} else {
				if (this.maxHeap.peek() >= num) {
					this.maxHeap.add(num);
				} else {
					if (this.minHeap.isEmpty()) {
						this.minHeap.add(num);
						return;
					}
					this.minHeap.add(num);
				}
			}
			modifyTwoHeapsSize();
		}

		private void modifyTwoHeapsSize() {
			if (this.maxHeap.size() == this.minHeap.size() + 2) {
				this.minHeap.add(this.maxHeap.poll());
			} else if (this.minHeap.size() == this.maxHeap.size() + 2) {
				this.maxHeap.add(this.minHeap.poll());
			}
		}

		public Integer getMedian() {
			int maxHeapSize = this.maxHeap.size();
			int minHeapSize = this.minHeap.size();
			if (maxHeapSize + minHeapSize == 0) {
				return null;
			}
			Integer maxHeapHead = this.maxHeap.peek();
			Integer minHeapHead = this.minHeap.peek();
			if ((maxHeapSize + minHeapSize) % 2 == 0) {
				return (maxHeapHead + minHeapHead) / 2;
			}
			return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;

		}
	}

	public static int comparator(int[] arr) {
		if (arr == null) {
			return 0;
		}
		Arrays.sort(arr);
		if (arr.length % 2 == 0) {
			return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
		} else {
			return arr[arr.length / 2];
		}

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] getRandomArray(int maxLen, int maxValue) {
		int[] res = new int[(int) (Math.random() * maxLen) + 1];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue);
		}
		return res;
	}

	public static void main(String[] args) {
		MedianHolder medianHolder = new MedianHolder();
		boolean err = false;
		int testTimes = 200000;
		for (int i = 0; i != testTimes; i++) {
			int len = 30;
			int maxValue = 1000;
			int[] arr = getRandomArray(len, maxValue);
			MedianHolder medianHold = new MedianHolder();
			for (int j = 0; j != arr.length; j++) {
				medianHold.addNumber(arr[j]);
			}
			if (medianHold.getMedian() != comparator(arr)) {
				err = true;
				printArray(arr);
				break;
			}
		}
		System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");
	}

}
