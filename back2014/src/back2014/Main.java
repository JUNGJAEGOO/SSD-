package back2014;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int N = in.nextInt();
		int arr[] = new int[K];
		
		for ( int i = 0 ; i < K ; i++) {
			arr[i] = in.nextInt();
		}
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for ( int i = 0 ; i < K ; i++) {
			if ( !pq.contains(arr[i]) ) {
				pq.add((long) arr[i]);
			}
		}
		
		long tmp = 0;
		while ( N > 0) {
			
			tmp = pq.poll();
			N--;
			//System.out.println(tmp);
			for ( int i = 0 ; i < K ; i++) {
				pq.add(arr[i]*tmp);
				if ( tmp % arr[i] == 0 ) {
					break;
				}
			}
			
			
			if ( N == 0) {
				System.out.print(tmp);
			}
		}
	}
	
	
}
