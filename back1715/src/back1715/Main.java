package back1715;

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for ( int i = 0 ; i < N ; i++) {
			pq.add(in.nextLong());
		}
		
		if ( pq.size() == 1 ) {
			System.out.print(0);
			return;
		}
		
		long sum = 0;
		
		while ( pq.size() != 1 && !pq.isEmpty() ) {
			long tmp = pq.poll() + pq.poll();
			sum += tmp;
			pq.add(tmp);
			
		}
		
		System.out.print(sum);
	}
	
}
