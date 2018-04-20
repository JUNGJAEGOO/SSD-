package LinkedListPrac;

import java.util.*;

public class LinkedListPrac<T> {

	
	private node head;
	private node tail;
	private int size;
	
	public class node{
		
		private T data;
		private node link;
		
		private node ( T data,node link){
			this.data = data;
			this.link = link;
		}
		
		
	}
	
	private node find(int idx) {
		node tmp = head;
		
		for ( int i = 0 ; i < idx ; i++) {
			tmp = tmp.link;
		}
		
		return tmp;
	}
	
	private void linkFirst(T data) {
		
		node newnode = new node(data,null);
		newnode.data = data;
		newnode.link = head;
		head = newnode;
		
		if ( tail == null) {
			tail = head;
		}
		
		size++;
	}
	
	private void linkLast(T data) {
		node newnode = new node(data,null);
		newnode.data = data;
		
		if ( head == null) {
			head = newnode;
			tail = newnode;
		}else {
			newnode.link = tail;
			tail = newnode;
		}
		
		size++;
	}
	
	private void linkbefore(T data,int idx) {
		node newnode = new node(data,null);
		newnode.data = data;
		
		node prev = find(idx-1);
		newnode.link = prev.link;
		prev.link = newnode;
		
		size++;
	}
	
	public static void main(String args[]) {
		LinkedListPrac<Integer> list = new LinkedListPrac<>();
		list.linkFirst(1);
		list.linkbefore(2, 1);
		list.linkbefore(3,2);
		list.linkbefore(4,3);
		
		for ( int i = 0; i < list.size ; i++) {
			System.out.println(list.find(i).data);
		}
	}
}
