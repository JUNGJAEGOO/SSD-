package back13703;

import java.util.*;

public class Main {
	static int K,N;

	static long dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		K = in.nextInt();
		N = in.nextInt();
		
		dp = new long[64][1000];
		for ( int i = 0 ; i < 64 ; i++) {
			for (int j = 0 ; j < 1000 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		
		
		System.out.print(func(0,K));
	}
	
	public static long func(int sec,int now) {
		
		//System.out.println(sec+" "+now);
		
		if ( now == 0) {
			return 0;
		}
		
		if ( sec == N) {
			return 1;
		}
		
		long ret = dp[sec][now];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( now + 1 > 0) {
			ret += func(sec+1,now+1);
		}
		
		if ( now - 1 > 0) {
			ret += func(sec+1,now-1);
		}
		
		return dp[sec][now] = ret;
	}
}
