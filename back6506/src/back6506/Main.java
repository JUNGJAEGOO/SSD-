package back6506;

import java.util.*;

public class Main {
	static int arr[];
	static long dp[][];
	static int N,M;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			
			N = in.nextInt();
			M = in.nextInt();
			if ( N == 0 && M == 0) {
				break;
			}
			arr = new int[N];
			for (int i = 0 ; i < N ; i++) {
				arr[i] = in.nextInt();
			}
			
			dp = new long[101][101];
			for ( int i = 0 ; i <= 100 ; i++) {
				for ( int j = 0 ; j <= 100 ;j++) {
					
						dp[i][j] = -1;
					
				}
			}
			
			long ans = 0;
			for (int s = 0 ; s< N ; s++) {
				
				ans += (func(s,1));
			}
			System.out.println(ans);
		}
	}
	
	static long func(int idx,int len) {
		if (  len == M ) {
			return 1;
		}
		
		long ret = dp[idx][len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		for ( int i = idx ; i < N ; i++) {
			if ( arr[i] > arr[idx] ) {
				ret += func(i,len+1);
			}
		}
		
		return dp[idx][len] = ret;
	}
}
