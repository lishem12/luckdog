package basic_class_03;

import utils.Node;

//两个单链表相交的一系列问题
//【题目】
//在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点
//head1和head2，这两个链表可能相交，也可能不相交。请实现一个函数，
//如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null
//即可。
//要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到
//O(N+M)，额外空间复杂度请达到O(1)。
public class Code_14_FindFirstIntersectNode {

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) { // 无环
			return noLoop(head1, head2);
		} else if (loop1 != null && loop2 != null) { // 都有环
			return bothLoop(head1,loop1,head2,loop2);
		} else { // 一个有环一个无环
			return null;
		}

	}

	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) { // 同入环
			int len = 0;
			cur1 = head1;
			cur2 = head2;
			while (cur1 != loop1) {
				++len;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				--len;
				cur2 = cur2.next;
			}
			cur1 = len > 0 ? head1 : head2;
			cur2 = len > 0 ? head2 : head1;
			for (int i = 0; i < Math.abs(len); ++i) {
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return cur1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	// 都无环的情况
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int len = 0;
		while (cur1.next != null) {
			cur1 = cur1.next;
			++len;
		}
		while (cur2.next != null) {
			cur2 = cur2.next;
			--len;
		}
		if (cur1 != cur2) { // 没有公共的尾，谈何相交
			return null;
		}

		// 让cur1 拿到长的先走
		cur1 = len > 0 ? head1 : head2;
		cur2 = len > 0 ? head2 : head1;
		for (int i = 0; i < Math.abs(len); ++i) {
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public static Node getLoopNode(Node head) {
		if (head == null) {
			return null;
		}
		Node fast = head.next.next;
		Node slow = head.next;
		while (fast != slow) {
			if (fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).data);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).data);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).data);

	}

}
