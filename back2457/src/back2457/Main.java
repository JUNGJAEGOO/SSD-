package back2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<node> list;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		PriorityQueue<node> pq = new PriorityQueue<>();
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new  StringTokenizer(br.readLine()," ");
			
			int fromM = Integer.parseInt(st.nextToken());
			int fromD = Integer.parseInt(st.nextToken());
			int toM = Integer.parseInt(st.nextToken());
			int toD = Integer.parseInt(st.nextToken());
			
			int from = cals(fromM) + fromD;
			int to = cals(toM) + toD - 1;
			
			list.add(new node(from,to));
			pq.add(new node(from,to));
		}
		
		int cnt = 0;
		int end = 31 + 28 + 1;
		
		while ( !pq.isEmpty() ) {
			System.out.println(end);
			node now = pq.poll();
			if ( now.from <= end + 1) {
					end = now.to;
					cnt++;
			}
			
			if ( end >= cals(11) + 30) {
				break;
			}
		}
		
		System.out.print(cnt);
		
	}
	
	public static int cals(int month) {
		
		switch ( month){
			case 1:
				return 0;
			case 2:
				return 31;
			case 3:
				return 28+31;
			case 4:
				return 28+31+31;
			case 5:
				return 28+31+31+30;
			case 6:
				return 28+31+31+30+31;
			case 7:
				return 28+31+31+30+31+30;
			case 8:
				return 28+31+31+30+31+30+31;
			case 9:
				return 28+31+31+30+31+30+31+31;
			case 10:
				return 28+31+31+30+31+30+31+31+30;
			case 11:
				return 28+31+31+30+31+30+31+31+30+31;
			case 12:
				return 28+31+31+30+31+30+31+31+30+31+30;
				
		}
		
		return 0;
		
	}
	
	public static class node implements Comparable<node>{
		
		int from;
		int to;
		int diff;
		
		node (int from, int to ){
			this.from = from;
			this.to = to;
			this.diff = to - from;
		}

		@Override
		public int compareTo(node o) {
			
			if ( this.diff > o.diff ) {
				return 1;
			}else if ( this.diff == o.diff) {
				
				if ( this.from < o.from) {
					return 1;
				}
				else if (this.from == o.from) {
					
					if ( this.to > o.to) {
						return 1;
					}
					return -1;
					
				}
			}
			return -1;

		}
		
	}
}
