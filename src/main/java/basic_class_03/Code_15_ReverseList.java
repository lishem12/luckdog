package basic_class_03;

// 反转双向链表和双向链表
public class Code_15_ReverseList {

	public static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static class DoubleNode {
		public int data;
		public DoubleNode next;
		public DoubleNode pre;

		public DoubleNode(int data) {
			this.data = data;
		}

	}

	// 反转单链表
	public static Node reverseList(Node head) {
		Node newHead = null;
		Node help = null;
		while (head != null) {
			help = head.next;
			head.next = newHead;
			newHead = head;
			head = help;
		}
		return newHead;
	}

	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.data + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.data + " ");
			end = end.pre;
		}
		System.out.println();
	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		printLinkedList(head1);
		head1 = reverseList(head1);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.pre = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.pre = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.pre = head2.next.next;
		printDoubleLinkedList(head2);
		printDoubleLinkedList(reverseList(head2));

	}

	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode next = null;
		DoubleNode pre = null;
		while (head != null) {
			next = head.next;
			head.pre = next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}
