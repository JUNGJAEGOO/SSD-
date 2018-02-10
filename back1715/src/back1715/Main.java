package back1715;

import java.util.*;

public class Main {
	static int dp[];
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		dp = new int[100001];
		for (int i = 0 ; i < 100001 ;i++) {
			dp[i] = -1;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		arr = new int[N+1];
		for (int i = 1 ; i<= N ; i++) {
			pq.add(in.nextInt());
		}
		
		if ( N == 1) {
			System.out.print(pq.poll());
			return;
		}
		
		long sum = 0;

		long before = pq.poll();
		while ( !pq.isEmpty() ) {
			sum += before + pq.poll();
			before = sum;
		}
		
		System.out.println(sum);
		
	}
	
}
