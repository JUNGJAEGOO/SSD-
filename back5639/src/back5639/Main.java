package back5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static node root;
	public static void main(String args[]) throws NumberFormatException, IOException {
		//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		int arr[] = new int[10001];
		int cnt = 0;
		while ( in.hasNextLine() ) {
			int inn = Integer.parseInt(in.nextLine());
			
			arr[cnt] = inn;
			cnt++;
		}
		
		root = new node(arr[0]);
		for (int i = 1 ; i < arr.length ; i++) {
			
			root.search(root,arr[i]);
			
		}
		
		root.find(root);
	}
	
	public static class node{
		int key;
		node left;
		node right;
		
		node ( int key ){
			this.key = key;
		}
		
		public static void search(node nod,int key) {
			if ( key < nod.key) {
				if ( nod.left == null) {
					nod.left = new node(key);
					return;
				}else {
					search(nod.left,key);
				}
			}else {
				if ( nod.right == null) {
					nod.right = new node(key);
					return;
				}else {
					search(nod.right,key);
				}
			}
		};
		
		public static void find(node nod) {
			if ( nod.left != null) {
				find(nod.left);
			}
			if ( nod.right != null) {
				find(nod.right);
			}
			if ( nod.key != 0) {
			System.out.println(nod.key);
			}
		}

		
	}
}
