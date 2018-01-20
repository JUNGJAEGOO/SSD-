package back10837;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static int K;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		K = in.nextInt();
		dp = new int[K+1][K+1];
		for (int i = 0 ; i <= K ; i++) {
			for (int j = 0 ; j <= K ; j++) {
				dp[i][j] = -1;
			}
		}
		func(0,0);
		/*for (int i = 0 ; i <= K ; i++) {
			for (int j = 0 ; j <= K ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
		int C = in.nextInt();
		for ( int i = 0 ; i < C ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			if ( dp[x][y] == 1) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
		}
	}
	
	public static int func(int m,int n) {
		
		//System.out.println(m+","+n);
		
		if ( Math.max(m, n) > K) {
			return 0;
		}
		
		/*if ( m + (K-n) < n) {
			System.out.println("sex");
			return 0;
		}*/
	
		//System.out.println("hi");
		
		int ret = dp[m][n];
		if ( ret != -1) {
			return ret;
		}
		ret = 1;
	
		if ( Math.min(m+1,n) + (K-(Math.max(m+1,n))) + 2 >= Math.max(m+1, n)) {
			func(m+1,n);
		}
		if ( Math.min(m, n+1) + (K-(Math.max(m, n+1))) + 1>= Math.max(m, n+1)) {
			func(m,n+1);
		}
		
		return dp[m][n] =ret;
	}
	
}
