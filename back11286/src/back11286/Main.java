package back11286;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			int x = in.nextInt();
			if ( x == 0) {
				if ( !pq.isEmpty()) {
					sb.append(pq.poll().num+"\n");
				}else {
					sb.append("0\n");
				}
			}
			else {
				pq.add(new node(x,Math.abs(x)));
			}
			
		}
		
		System.out.print(sb);
	}
	
	public static class node implements Comparable<node>{
		int num;
		int abs;
		node (int num,int abs){
			this.num = num;
			this.abs = abs;
		}
		@Override
		public int compareTo(node o) {
			if ( this.abs > o.abs ) {
				return 1;
			}else if ( this.abs == o.abs) {
				if ( this.num > o.num) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
