package basic_class_03;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。 【要求】 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 */
public class Code_02_GetMinStack {

	/**
	 * 同步增长方式
	 */
	public static class MyStack1 {
		private Stack<Integer> stack;
		private Stack<Integer> minStack;

		public MyStack1() {
			stack = new Stack<Integer>();
			minStack = new Stack<Integer>();
		}

		public Integer pop() {
			if (stack.isEmpty()) {
				return null;
			}
			minStack.pop();
			return stack.pop();
		}

		public void push(Integer i) {
			stack.push(i);
			if (minStack.isEmpty()) {
				minStack.push(i);
			} else {
				minStack.push(minStack.peek() < i ? minStack.peek() : i);
			}
		}

		public Integer getMin() {
			if (minStack.isEmpty()) {
				return null;
			}
			return minStack.peek();
		}
	}

	public static class MyStack2 {
		private Stack<Integer> stack;
		private Stack<Integer> minStack;

		public Integer pop() {
			if (stack.isEmpty()) {
				return null;
			}
			if (stack.peek() == minStack.peek()) {
				minStack.pop();
			}
			return stack.pop();
		}

		public void push(Integer i) {
			stack.push(i);
			if (minStack.isEmpty() || minStack.peek() >= i) {
				minStack.push(i);
			}
		}

		public Integer getMin() {
			if (minStack.isEmpty()) {
				return null;
			}
			return minStack.peek();
		}
	}

	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getMin());//3
		stack1.push(4);
		System.out.println(stack1.getMin());//3
		stack1.push(1);
		System.out.println(stack1.getMin());//1
		System.out.println(stack1.pop());//1
		System.out.println(stack1.getMin());//3

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getMin());//3
		stack2.push(4);
		System.out.println(stack2.getMin());//3
		stack2.push(1);
		System.out.println(stack2.getMin());//1
		System.out.println(stack2.pop());//1
		System.out.println(stack2.getMin());//3
	}
}
