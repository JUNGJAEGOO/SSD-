package back11057;

import java.util.*;

public class Main {
	static int dp[][];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		dp = new int[1001][1001];
		for ( int i = 0 ; i < 1001 ; i++) {
			for ( int j = 0 ; j < 1001 ; j++) {
				dp[i][j] = -1;
			}
 		}
	
		
		System.out.println(func(0,0));
		
		
	}
	
	public static int func(int now,int len) {
		
		
		if ( len == N) {
			return 1;
		}
		
		int ret = dp[now][len];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = now ; i <= 9 ; i++) {
			ret += func(i,len+1);
		}
		
		return dp[now][len] = ret % 10007;
		
	}
}
