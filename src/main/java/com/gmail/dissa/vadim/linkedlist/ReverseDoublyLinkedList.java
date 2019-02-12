package com.gmail.dissa.vadim.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Reverse a doubly linked list
 * You’re given the pointer to the head node of a doubly linked list. Reverse the order 
 * of the nodes in the list. The head node might be NULL to indicate that the list is 
 * empty. Change the next and prev pointers of all the nodes so that the direction 
 * of the list is reversed. Return a reference to the head node of the reversed list.
*/

public class ReverseDoublyLinkedList {
	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		DoublyLinkedListNode result = new DoublyLinkedListNode(head.data);

		while (head.next != null) {
			DoublyLinkedListNode tmp = new DoublyLinkedListNode(head.next.data);
			result.prev = tmp;
			tmp.prev = null;
			tmp.next = result;
			result = tmp;
			head = head.next;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			DoublyLinkedList llist = new DoublyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			DoublyLinkedListNode llist1 = reverse(llist.head);

			printDoublyLinkedList(llist1, " ", bufferedWriter);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
