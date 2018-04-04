package back1351;

import java.util.*;

public class Main {
	static int dp[];
	static int P,Q;
	static long N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextLong();
		P = in.nextInt();
		Q = in.nextInt();
		dp = new int[10000001];
		dp[0] = 1;
		for ( int i = 1 ; i< 10000001 ; i++) {
			dp[i] = dp[i/P] + dp[i/Q];
		}
		
		long sum = 0;
		sum = func(N);
		System.out.println(sum);
	}
	
	public static long func(long n) {
		
		if ( n <= 10000000 ) {
			return dp[(int) n];
		}else {
			
			return func(n/P) + func(n/Q);
			
		}
		
	}
}
