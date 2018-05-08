package back1256;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		int dp[][] = new int[201][201];
		
		for ( int i = 0 ; i < 201 ; i++) {
			dp[i][0] = 1;
			for ( int j = 1 ; j <= i ; j++) {
				if ( j == 0 || j == i) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = Math.min(dp[i-1][j-1] + dp[i-1][j],(int)1e9);
				}
			}
		}
		
		int tot = N+M;
		
		if ( K > dp[N+M][N] ) {
			System.out.print(-1);
		}else {
			
			
			for( int i = 0 ; i < tot ; i++) {

				if ( K > dp[N+M-1][M] ){
					System.out.print("z");
					K -= dp[N+M-1][M];
					M--;
				}else {
					System.out.print("a");
					N--;
				}
				
			}
			
		}
		
	}
}
