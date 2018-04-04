package back9764;

import java.util.*;

public class Main {
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		dp = new int[2001][2001];
		for ( int i = 0 ; i < 2001 ; i++ ) {
			for ( int j = 0 ; j < 2001 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		while ( T > 0) {
			
			int N = in.nextInt();
			
			System.out.println(func(N,1));
			
			T--;
		}
	}
	
	public static int func(int idx,int num) {
		
		if ( idx < num) {
			return 0;
		}
		
		if ( idx == num) {
			return 1;
		}
		
		if ( idx == 0) {
			return 1;
		}
		
		int ret = dp[idx][num];
		if ( ret != -1 ) {
			return ret;
		}
		ret = 0;
		ret = ( func(idx-num,num+1) + func(idx,num+1) ) % 100999;
		
		return dp[idx][num] = ret;
	}
	
}
