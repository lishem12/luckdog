package basic_class_03;

import utils.LinkedListUtils;
import utils.Node;

//将单向链表按某值划分成左边小、中间相等、右边大的形式
//【题目】
//给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整数pivot。
//实现一个调整链表的函数，
//将链表调整为左部分都是值小于pivot的节点，
//中间部分都是值等于pivot的节点，
//右部分都是值大于pivot的节点。
//除这个要求外，对调整后的节点顺序没有更多的要求。
//例如：链表9->0->4->5->1，pivot=3。
//调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
//总之，满足左部分都是小于3的节点，中间部分都是等于3的节点，右部分都是大于3的节点即可。
//对某部分内部的节点顺序不做要求
public class Code_12_SmallerEqualBigger {

	public static Node listPartition2(Node head, int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.data < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.data == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else if (head.data > pivot) {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;
	}

	// 转化为 数组
	public static Node listPartition1(Node head, int pivot) {
		Node cur = head;
		int len = 0;
		while (cur != null) {
			++len;
			cur = cur.next;
		}
		cur = head;
		Node[] nodes = new Node[len];
		for (int i = 0; i < nodes.length; ++i) {
			nodes[i] = cur;
			cur = cur.next;
		}
		int less = -1;
		int more = nodes.length;
		int index = 0;
		while (index < more) {
			if (nodes[index].data < pivot) {
				swap(nodes, index++, ++less);
			} else if (nodes[index].data == pivot) {
				++index;
			} else {
				swap(nodes, index, --more);
			}
		}
		for (int i = 1; i < nodes.length; ++i) {
			nodes[i - 1].next = nodes[i];
		}
		nodes[nodes.length - 1].next = null;
		return nodes[0];
	}

	private static void swap(Node[] nodes, int node1, int node2) {
		Node temp = nodes[node1];
		nodes[node1] = nodes[node2];
		nodes[node2] = temp;
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);

		// 7 9 1 8 5 2 5
		LinkedListUtils.printLinkedList(head1);
		// head1 = listPartition1(head1, 5);
		head1 = listPartition2(head1, 5);
		LinkedListUtils.printLinkedList(head1);
	}
}
