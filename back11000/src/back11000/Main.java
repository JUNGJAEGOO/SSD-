package back11000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		node2 arr[] = new node2[N];
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new node2(start,end);
		}
		
		Arrays.sort(arr);
		
		int cnt = 0 ;
		int ans = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		for ( int i = 0 ; i < N ; i++) {
			
			while ( !pq.isEmpty() ) {
				
				node top = pq.peek();
				if ( top.end <= arr[i].start) {
					pq.poll();
					cnt--;
				}else {
					pq.add(new node(arr[i].start,arr[i].end));
					cnt++;
					ans = Math.max(ans, cnt);
					break;
				}
				
			}
			
			if ( pq.isEmpty() ) {
				cnt++;
				ans = Math.max(ans, cnt);
				pq.add(new node(arr[i].start,arr[i].end));
			}
		}
		
		System.out.print(ans);
	}
	
	public static class node implements Comparable<node>{
		int start,end;
		node ( int start,int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(node o) {
			if ( this.end > o.end ) {
				return 1;
			}
			return -1;
		}
	}
	
	public static class node2 implements Comparable<node2>{
		int start,end;
		node2 ( int start,int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(node2 o) {
			if ( this.start > o.start ) {
				return 1;
			}
			return -1;
		}
	}
	
}
