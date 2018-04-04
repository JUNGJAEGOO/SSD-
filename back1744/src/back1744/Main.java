package back1744;

import java.util.*;

public class Main {
	
	static int arr[];
	static int inf = -1000000000;
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr= new int[N];
		PriorityQueue<node> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for ( int i = 0 ; i < N  ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] > 0) {
				pq1.add(new node(arr[i]));
			}else {
				pq2.add(arr[i]);
			}
			
		}
		
		int sum = 0;
		while ( !pq1.isEmpty() ) {
			
			int x = 0;
			if ( pq1.size() != 0) {
			x = pq1.poll().num;
			}
			int y = 0;
			if ( pq1.size() != 0) {
			y = pq1.poll().num;
			}
			System.out.println(x+" "+y);
			if ( x == 0 && y == 0) {
				break;
			}
			if ( x != 0 && y != 0) {
				if ( x == 1 || y == 1) {
					sum += (x+y);
				}else {
					sum += x*y;
				}
			}
			if ( x == 0 && y != 0) {
				sum += y;
			}
			if ( x != 0 && y == 0) {
				sum += x;
			}
			
			
		}
		
		while ( !pq2.isEmpty() ) {
			
			int x = 1;
			if ( pq2.size() > 0) {
				x = pq2.poll();
			}
			int y = 1;
			if ( pq2.size() > 0) {
				y = pq2.poll();
			}
			
			if ( x <= 0 && y <= 0 ) {
				sum += x*y;
			}
			if ( x == 1 && y <= 0) {
				sum += y;
			}
			if ( x <= 0 && y == 1) {
				sum += x;
			}
		}
		
		System.out.print(sum);
	}
	
	public static class node implements Comparable<node>{
		int num;
		node ( int num){
			this.num = num;
		}
		@Override
		public int compareTo(node o) {
			if ( this.num < o.num) {
				return 1;
			}
			return -1;
		}
	}
	

}
