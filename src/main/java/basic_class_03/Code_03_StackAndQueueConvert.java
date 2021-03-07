package basic_class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 如何仅用队列结构实现栈结构？ 如何仅用栈结构实现队列结构？ 实现push pop peek
 */
public class Code_03_StackAndQueueConvert {

	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			this.stackPush = new Stack<Integer>();
			this.stackPop = new Stack<Integer>();
		}

		/**
		 * stackPop 栈不为空不可执行操作 要执行操作就倒完
		 */
		private void inverted() {
			if (!stackPop.isEmpty()) {
				return;
			}
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}

		public void push(Integer num) {
			stackPush.push(num);
		}

		public Integer poll() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				return null;
			}
			inverted();
			return stackPop.pop();

		}

		public Integer peek() {
			if (stackPop.isEmpty() && stackPush.isEmpty()) {
				return null;
			}
			inverted();
			return stackPop.peek();
		}
	}

	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(Integer num) {
			queue.add(num);
		}

		public Integer poll() {
			if (queue.isEmpty()) {
				return null;
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			swap();
			return help.poll();
		}

		public Integer peek() {
			if (queue.isEmpty()) {
				return null;
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			Integer res = queue.peek();
			help.add(queue.poll());
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> temp = queue;
			queue = help;
			help = temp;
		}
	}
}
