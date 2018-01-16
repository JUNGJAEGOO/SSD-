package back10844;

import java.util.Scanner;

public class Main2 {
	static int dp[][];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		dp = new int[101][11];
		for ( int i = 0 ; i <= 100 ; i++ ) {
			for ( int j = 0 ; j <= 10 ; j++) {
				dp[i][j] = -1;
			}
		}
		N = in.nextInt();
		long ans = 0;
		for ( int i = 1 ; i<= 9 ; i++) {
			ans = ans + (func(1,i) % 1000000000);
		}
		System.out.println(ans%1000000000);
	}
	
	public static int func(int len,int num) {
		
		if ( len == N) {
			return 1;
		}
		
		int ret = dp[len][num];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 0 ; i <= 9 ; i++) {
			if ( i == num-1 || i == num+1) {
				ret += func(len+1,i);
			}
		}
		
		System.out.println(ret);
		return dp[len][num] = (ret % 1000000000);
		
	}
}
