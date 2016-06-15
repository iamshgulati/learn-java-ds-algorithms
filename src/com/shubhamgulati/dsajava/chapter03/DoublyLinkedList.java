package com.shubhamgulati.dsajava.chapter03;

public class DoublyLinkedList {

	//properties
	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	//Create a new empty list
	public DoublyLinkedList() {
		head = new DLLNode(Integer.MIN_VALUE, null, null);
		tail = new DLLNode(Integer.MIN_VALUE, head, null);
		length = 0;
	}
	
	//Get the value at a given position
	public int get(int position) {
		return Integer.MIN_VALUE;
	}
	
	//Find the position of the head value that is equal to the given value
	//The equals() method is used to determine equality
	public int getPosition(int data) {
		//go looking for data
		DLLNode temp = head;
		int pos = 0;
		
		while(temp!=null) {
			if(temp.getData() == data) {
				//return the position if found
				return pos;
			}
			pos++;
			temp = temp.getNext();
		}
		//else return some large value
		return Integer.MIN_VALUE;
	}
	
	//Return the current length of the DLL
	public int length() {
		return length;
	}
	
	//Add a new value to the front of the list
	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue, head, head.getNext());
		head.setNext(newNode);
		length++;
	}
	
	//Add a new value to the list at a given position
	//All values at that position to the end move over to make room.
	public void insert(int data, int position) {
		//fix position
		if(position < 0) {
			position = 0;
		}
		if(position > length) {
			position = length;
		}
		
		//if the list is empty, make it be the only element
		if(head == null) {
			head = new DLLNode(data);
			tail = head;
		}
		
		//if adding at the front of the list
		else if(position == 0) {
			DLLNode temp = new DLLNode(data);
			temp.setNext(head);
			head = temp;
		}
		
		//else find the correct position and insert
		else {
			DLLNode temp = head;
			for(int i=1; i<position; i++){
				temp = temp.getNext();
			}
			DLLNode newNode = new DLLNode(data);
			newNode.setNext(temp.getNext());
			newNode.setPrev(temp);
			newNode.getNext().setPrev(newNode);
			temp.setNext(newNode);
		}
		
		//the list is now one value longer
		length++;
	}
	
	//Add a new value to the rear of the list
	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue, tail.getPrev(), tail);
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		length++;
	}
	
	//Remove the value at a given position
	//If the position is less than 0, remove the value at position 0.
	//If the position is greater than 0, remove the value at the last position.
	public void remove(int position) {
		//fix position
		if(position < 0) {
			position = 0;
		}
		if(position >= length) {
			position = length-1;
		}
		
		//if nothing in the list, do nothing
		if(head == null) {
			return;
		}
		
		//if removing the head element
		if(position == 0) {
			head = head.getNext();
			if(head == null) {
				tail = null;
			}
		}
		
		//else advance to the correct position and remove
		else {
			DLLNode temp = head;
			for(int i=1; i < position; i++) {
				temp = temp.getNext();
			}
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
		}
		
		//reduce the length of the list
		length--;
	}
	
	//Remove a node matching the specified node from the list
	//Use equals() instead of == to test for a matched node
	public synchronized void removeMatched(DLLNode node) {
		if(head == null) {
			return;
		}
		if(node.equals(head)) {
			head = head.getNext();
			if(head == null) {
				tail = null;
			}
			return;
		}
		
		DLLNode p = head;
		while (p != null) {
			if(node.equals(p)) {
				p.getPrev().setNext(p.getNext());
				p.getNext().setPrev(p.getPrev());
				return;
			}
		}
	}
	
	//Remove the head value from the list. If the list is empty, do nothing.
	public int removeHead() {
		if(length == 0) {
			return Integer.MIN_VALUE;
		}
		DLLNode save = head.getNext();
		head.setNext(save.getNext());
		save.getNext().setPrev(head);
		length--;
		return save.getData();
	}
	
	//Remove the tail value from the list. if the list is empty, do nothing
	public int removeTail() {
		if(length == 0) {
			return Integer.MIN_VALUE;
		}
		DLLNode save = tail.getPrev();
		tail.setPrev(save.getPrev());
		save.getPrev().setNext(tail);
		length--;
		return save.getData();
	}
	
	//Return a string representation of this collection, in the form: ["str1","str2",...]
	public String toString() {
		String result = "[]";
		if(length == 0) {
			return result;
		}
		
		result = "[" + head.getNext().getData();
		DLLNode temp = head.getNext().getNext();
		
		while(temp != tail) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		
		return result + "]";
	}
	
	//Remove everything from the DLL
	public void clearList() {
		head = null;
		tail = null;
		length = 0;
	}
}
