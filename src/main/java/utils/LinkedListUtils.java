package utils;

public class LinkedListUtils {
	
	
	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while(head!= null) {
			System.out.print(head.data+",");
			head = head.next;
		}
		System.out.println();
	}
}
