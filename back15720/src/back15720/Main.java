package back15720;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int B = in.nextInt();
		int C = in.nextInt();
		int D = in.nextInt();
		
		PriorityQueue<node> burger = new PriorityQueue<>();
		PriorityQueue<node> side = new PriorityQueue<>();
		PriorityQueue<node> beverage = new PriorityQueue<>();
		
		long origin = 0;
		long after = 0;
		
		for ( int i = 0 ; i < B ; i++) {
			int x = in.nextInt();
			burger.add(new node(x));
			origin += x;
		}
		
		for ( int i = 0 ; i < C ; i++) {
			int x = in.nextInt();
			side.add(new node(x));
			origin += x;
		}
		
		for ( int i = 0 ; i < D ; i++) {
			int x = in.nextInt();
			beverage.add(new node(x));
			origin += x;
		}
		
		while ( true ) {
			
			if ( burger.isEmpty() || side.isEmpty() || beverage.isEmpty() ) {
				break;
			}
			//System.out.print(after);
			after += 0.9*(burger.poll().num + side.poll().num + beverage.poll().num);
		}
		
		while ( !burger.isEmpty()) {
			after += burger.poll().num;
		}
		
		while ( !side.isEmpty()) {
			after += side.poll().num;		
		}
		
		while ( !beverage.isEmpty()) {
			after += beverage.poll().num;
		}
		
		System.out.println(origin);
		System.out.println(after);
		
	}
	
	public static class node implements Comparable<node>{
		int num;
		node (int num ){
			this.num = num;
		}
		
		@Override
		public int compareTo(node o) {
			if ( this.num > o.num) {
				return -1;
			}else {
				return 1;
			}
		}
	}

}
