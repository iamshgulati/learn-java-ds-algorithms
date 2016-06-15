package com.shubhamgulati.dsajava.chapter03;

public class ListNode {
	private int data;
	private ListNode next;
	
	public ListNode(int data) {
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}
