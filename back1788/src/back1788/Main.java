package back1788;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[2000002];
		
		N += 1000000;
		
		dp[1000000] = 0;
		dp[1000001] = 1;
		dp[1000002] = 1;
		
		
		for ( int i = 1000003 ; i <= 2000001 ; i++) {
			dp[i] = (dp[i-1] + dp[i-2] )% 1000000000;
		}
		dp[1000000-1] = 1;
		
		for ( int i = 1000000 ; i-2 >= 0 ; i--) {
			dp[i-2] = (dp[i] - dp[i-1]) % 1000000000;
		}
		
		/*for ( int i = 1000002 ; i >= 1000000-10 ; i--) {
			System.out.print(dp[i]+" ");
		}*/
		
		if ( dp[N] < 0) {
			System.out.println(-1);
		}else if ( dp[N] == 0) {
			System.out.println(0);
		}else {
			System.out.println(1);
		}
		
		System.out.println( Math.abs(dp[N]) );
	}
}
