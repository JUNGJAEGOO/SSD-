package back3231;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		for ( int i = 0 ; i < n ; i++) {
			pq.add(new node(in.nextInt(),i));
		}
		
		int stan = -1;
		int sum = 0;
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			System.out.println(now.num+" "+now.idx);
			
			if ( now.idx > stan) {
				stan = now.idx;
			}else {
				stan = now.idx;
				sum++;
			}
			
		}
		
		System.out.println(sum);
		
	}
	
	public static class node implements Comparable<node>{
		int num;
		int idx;
		
		node ( int num,int idx){
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(node o) {
			if ( this.num > o.num) {
				return 1;
			}
			return -1;
		}
	}
}
