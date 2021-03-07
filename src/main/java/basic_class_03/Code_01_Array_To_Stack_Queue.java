package basic_class_03;

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class Code_01_Array_To_Stack_Queue {

	public static class ArrayStack {
		private Integer[] arr; // 提供存储空间
		private Integer size; // 提供指针

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}

		/**
		 * Peek 英文 窥视
		 */
		public Integer peek() {
			if (this.size == 0) {
				throw null;
			}
			return arr[size - 1];
		}

		public void push(Integer i) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			arr[size++] = i;
		}

		public Integer pop() {
			if (this.size == 0) {
				throw new ArrayIndexOutOfBoundsException("The stack is empty");
			}
			return arr[--size];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr; // 提供存储空间
		private Integer first;
		private Integer last;
		private Integer size;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			first = last = size = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		public void push(Integer i) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			++size;
			arr[last] = i;
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			--size;
			int temp = arr[first];
			first = first == arr.length - 1 ? 0 : first + 1;
			return temp;
		}
	}
}
