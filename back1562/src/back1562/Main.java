package back1562;

import java.util.*;

public class Main {
	static int N;
	static long dp[][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		//System.out.println(1<<10);
		dp = new long[101][10][(1<<10) + 1];
		for (int i = 0 ; i < 101 ; i++) {
			for ( int j = 0 ; j < 10 ; j++) {
				for (int k = 0 ; k < (1<<10) + 1 ; k++ ) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		long ans = 0;
		ans = func(0,0,0);
		System.out.println(ans);
	}
	
	public static long func(int len,int before,int visit) {
		
		if ( len == N && visit == 1023) {
			return 1;
		}else if ( len == N && visit != 1023) {
			return 0;
		}
		
		long ret = dp[len][before][visit];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( len == 0 ) {
			for ( int i = 1 ; i <= 9 ; i++) {
				ret += (func(len+1,i,visit|(1<<i)) % 1000000000);
			}
		}else {
			for ( int i = 0 ; i<= 9 ; i++) {
				if ( i == before -1 || i == before + 1) {
					ret += (func(len+1,i,visit|(1<<i))%1000000000);
				}
			}
		}
		
		return dp[len][before][visit] = ret % 1000000000;
	}
}
