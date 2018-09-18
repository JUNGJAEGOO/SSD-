package back9465;

import java.util.*;

public class Main {
	static int N;
	static int dp[][];
	static int A[];
	static int B[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0 ) {
			
			
			N = in.nextInt();
			
			A = new int[N+1];
			B = new int[N+1];
			
			for ( int i = 1 ; i <= N ; i++) {
				A[i] = in.nextInt();
			}
			
			for ( int i = 1 ; i <= N ; i++) {
				B[i] = in.nextInt();
			}
			
			dp = new int[100_001][2];
			
			for ( int i = 0 ; i < 100_000 ; i++) {
				for ( int j = 0 ; j < 2 ; j++) {
					dp[i][j] = -1;
				}
			}
			
			System.out.println( Math.max( func(0, 1), func(0,0) ) );
			
			
			T--;
		}
		
	}
	
	public static int func(int x,int updown) {
		
		if ( x == N) {
			return 0;
		}
		
		int ret = dp[x][updown];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( updown == 0) {
			ret = Math.max(ret, B[x+1] + func(x+1,1) );
			ret = Math.max(ret, func(x+1,0) );
		}else {
			ret = Math.max(ret, A[x+1] + func(x+1,0) );
			ret = Math.max(ret, func(x+1,1) );
		}
		
		
		return dp[x][updown] = ret;
	}
}
