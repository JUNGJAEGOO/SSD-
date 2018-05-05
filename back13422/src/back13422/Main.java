package back13422;

import java.util.*;

public class Main {
	public static void main(String	args[]) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for ( int testcase = 0 ; testcase < T ; testcase++) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			int K = in.nextInt();
			

			if ( N == M) {
				
				int sum = 0;
				for ( int i = 0 ; i < N ; i++) {
					sum += in.nextInt();
				}
				
				if ( sum < K) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				continue;
			}
			
			int arr[] = new int[N+M];
			
			for ( int i = 0 ; i < N ; i++) {
				arr[i] = in.nextInt();
				
			}

			
			int sum[] = new int[N];
			
			for ( int i = 0 ; i < M ; i++) {
				sum[0] += arr[i];
			}
			
			for ( int i = 1 ; i < N ; i++) {
				
				sum[i] = sum[i-1] + arr[(M+i-1)%N] - arr[i-1];
				
			}
			
			/*for ( int i = 0 ; i < N ; i++) {
				System.out.print(sum[i]+" ");
			}System.out.println();
			 */
			
			int ans = 0;
			for ( int i = 0 ; i < N ; i++) {
				
				if(  sum[i] < K ) {
					ans++;
				}
				
			}
			
			System.out.print(ans);
		}
	}
}
