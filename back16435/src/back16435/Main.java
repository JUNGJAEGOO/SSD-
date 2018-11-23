package back16435;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		while ( !pq.isEmpty() ) {
			
			int now = pq.poll();
			if ( now <= L) {
				L++;
			}else {
				break;
			}
			
		}
		
		System.out.print(L);
		
	}
}
