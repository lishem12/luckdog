package basic_class_03;

import java.util.Stack;

import utils.LinkedListUtils;
import utils.Node;

//判断一个链表是否为回文结构
//【题目】
//给定一个链表的头节点head，请判断该链表是否为回文结构。
//例如：
//1->2->1，返回true。
//1->2->2->1，返回true。
//15->6->15，返回true。
//1->2->3，返回false。
//进阶：
//如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。

public class Code_11_IsPalindromeList {

	/**
	 * 方式1 借用栈，时间复杂度O(N),空间复杂度O(N)
	 */
	public static boolean isPalindrome1(Node head) {
		if (head == null) {
			return true;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop().data != head.data) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// 方式2 借用栈，用半个栈，时间复杂度O(N),空间复杂度O(N/2)
	// 细节，还有后半部分是利用栈大小，而不是考虑链表
	public static boolean isPalindrome2(Node head) {
		if (head == null) {
			return true;
		}
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		fast = slow;
		while (fast != null) {
			stack.push(fast);
			fast = fast.next;
		}
		fast = head;
		while (!stack.isEmpty()) {
			if (stack.pop().data != fast.data) {
				return false;
			}
			fast = fast.next;
		}
		return true;
	}

	// 方式3 完全用指针玩，时间复杂度O(N),空间复杂度O(1)
	public static boolean isPalindrome3(Node head) {
		if (head == null) {
			return true;
		}
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		Node help = null;
		slow.next = null;
		while (fast != null) {
			help = fast.next;
			fast.next = slow;
			slow = fast;
			fast = help;
		}
		boolean flag = true;
		help = head;
		fast = slow;
		while (fast != null) {
			if (fast.data != help.data) {
				flag = false;
				break;
			}
			fast = fast.next;
			help = help.next;
		}
		fast = slow.next;
		slow.next = null;
		while (fast != null) {
			help = fast.next;
			fast.next = slow;
			slow = fast;
			fast = help;
		}
		return flag;
	}

	public static void main(String[] args) {
		Node head = null;
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		LinkedListUtils.printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		LinkedListUtils.printLinkedList(head);
		System.out.println("=========================");
	}
}
