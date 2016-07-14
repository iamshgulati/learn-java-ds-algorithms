package com.shubhamgulati.learn_java_ds_algorithms.linked_list;

public class DLLNode {
	private int data;
	private DLLNode prev;
	private DLLNode next;
	
	public DLLNode(int data) {
		this.data = data;
		prev = null;
		next = null;
	}
	
	public DLLNode(int data, DLLNode prev, DLLNode next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public DLLNode getPrev() {
		return prev;
	}
	
	public DLLNode getNext() {
		return next;
	}
	
	public void setPrev(DLLNode where) {
		prev = where;
	}
	
	public void setNext(DLLNode where) {
		next = where;
	}
}
