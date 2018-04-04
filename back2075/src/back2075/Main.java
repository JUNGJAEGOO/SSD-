package back2075;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<node> pq = new PriorityQueue<>();
		int arr[] = new int[N*N];
		int cnt = 0;
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < N ; j++) {
				pq.add (new node(Integer.parseInt(st.nextToken())) );
				//cnt++;
			}
		}
		
		
		while ( !pq.isEmpty()) {
			int now = pq.poll().number;
			cnt++;
			if ( cnt == N) {
				System.out.println(now);
				break;
			}
		}
	}
	
	public static class node implements Comparable<node>{
		int number;
		node( int number){
			this.number = number;
		}
		@Override
		public int compareTo(node o) {
			if ( this.number < o.number) {
				return 1;
			}
			return -1;
		}
		
	}
}
