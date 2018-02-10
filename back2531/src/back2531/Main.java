package back2531;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int d = in.nextInt();
		int k = in.nextInt();
		int c = in.nextInt();
		
		int dp[] = new int[N];
		int arr[] = new int[3001];
		Deque<Integer> dq = new LinkedList<>();
		
		int chobap[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			chobap[i] = in.nextInt();
		}
		
		int sort = 0;
		for (int i = 0 ; i < k ; i++) {
			dq.addLast(chobap[i]);
			if ( arr[chobap[i]] == 0 ) {
				sort++;
			}
			arr[chobap[i]]++;
			
		}
		
		if ( dq.contains(c)) {
			dp[0] = sort;
		}else {
			dp[0] = sort+1;
		}

		int idx = k;
		for (int i = 1 ; i < N ; i++) {
			
			int rem = dq.removeFirst();
			arr[rem]--;
			if( arr[rem] == 0) {
				sort--;
			}
			
			dq.addLast(chobap[idx]);
			if ( arr[chobap[idx]] == 0) {
				sort++;
			}
			arr[chobap[idx]]++;
		
			
			if ( dq.contains(c)) {
				dp[i] = sort;
			}else {
				dp[i] = sort+1;
			}
			
			idx = ( idx+1 ) % N;
		}
		
		int max = 0;
		for (int i = 0 ; i < N ; i++) {
			if ( dp[i] > max) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
		
	}
}
