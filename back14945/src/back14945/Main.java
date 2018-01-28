package back14945;

import java.util.Scanner;

public class Main {
	static int dp[][][];
	static int limit;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		limit = N-1;
		dp = new int[101][101][101];
		for ( int i = 0 ; i <= 100 ; i++) {
			for ( int j = 0 ; j <= 100 ; j++) {
				for ( int k = 0 ; k <= 100 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		System.out.println(func(0,0,0));
		
	}
	
	public static int func(int len,int left,int right) {
		
		if ( len != 0 && left == right) {
			return 0;
		}
		if ( left > len || right > len) {
			return 0;
		}
		if ( len == limit) {
			return 1;
		}
		
		int ret = dp[len][left][right];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		ret += func(len+1,left,right);
		ret += func(len+1,left+1,right);
		ret += func(len+1,left,right+1);
		ret += func(len+1,left+1,right+1);
				
		return dp[len][left][right] = ret%10007;
		
	}
}
