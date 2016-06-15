package com.shubhamgulati.dsajava.chapter03;

public class LinkedListTest {
	
	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		makeList(myList);
		printList(myList);
	}
	
	private static void makeList(LinkedList myList) {
		for(int i=0; i<10; i++) {
			System.out.println(myList.toString());
			myList.insertAtEnd(new ListNode(i));
		}
	}
	
	private static void printList(LinkedList myList) {
		System.out.println(myList.toString());
	}
}
