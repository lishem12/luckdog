package basic_class_03;

import java.util.HashMap;
import java.util.Map;
//一种特殊的链表节点类描述如下：
//public class Node {
//public int value;
//public Node next;
//public Node rand;
//public Node(int data) {
//this.value = data;
//}
//}

//Node类中的value是节点值，next指针和正常单链表中next指针的意义一
//样，都指向下一个节点，rand指针是Node类中新增的指针，这个指针可
//能指向链表中的任意一个节点，也可能指向null。
//给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个
//函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
//进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为
//O(N)内完成原问题要实现的函数。
public class Code_13_CopyListWithRandom {

	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}

	// 利用hash的映射性
	public static Node copyListWithRand1(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		for (Map.Entry<Node, Node> entrySet : map.entrySet()) {
			Node oldNode = entrySet.getKey();
			Node newNode = entrySet.getValue();
			newNode.next = map.get(oldNode.next);
			newNode.rand = map.get(oldNode.rand);
		}
		return map.get(head);
	}

	// 利用Node 的位置关系
	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node curCopy = null;
		// 复制
		while (cur != null) {
			curCopy = new Node(cur.value);
			curCopy.next = cur.next;
			cur.next = curCopy;
			cur = curCopy.next;
		}
		cur = head;

		// 复制随机节点
		while (cur != null) {
			cur.next.rand = cur.rand == null ? null : cur.rand.next;
			cur = cur.next.next;
		}

		Node newHead = head.next;
		cur = head;
		while (cur != null) {
			curCopy = cur.next;
			cur.next = curCopy.next;
			curCopy.next = cur.next == null ? null : cur.next.next;
			cur = cur.next;
		}

		return newHead;
	}

	public static void printRandLinkedList(Node head) {

		Node cur = head;
		System.out.print("order:");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		System.out.println("原链表：");
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		System.out.println("方法1复制链表：");
		printRandLinkedList(res1);
		System.out.println("原链表：");
		printRandLinkedList(head);
		res2 = copyListWithRand2(head);
		System.out.println("方法2复制链表：");
		printRandLinkedList(res2);
		System.out.println("原链表：");
		printRandLinkedList(head);
		System.out.println("=========================");
	}
}
