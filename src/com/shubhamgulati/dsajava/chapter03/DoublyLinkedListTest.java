package com.shubhamgulati.dsajava.chapter03;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		makeList(myList);
		printList(myList);
	}
	
	private static void makeList(DoublyLinkedList myList) {
		for(int i=0; i<10; i++) {
			System.out.println(myList.toString());
			myList.insertTail(i);
		}
	}
	
	private static void printList(DoublyLinkedList myList) {
		System.out.println(myList.toString());
	}
}
