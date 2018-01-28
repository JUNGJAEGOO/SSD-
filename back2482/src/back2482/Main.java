package back2482;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static int arr[];
	static int N,K;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		dp = new int[N+1][N+1];
		dp[3][1] = 3;
		dp[3][2] = 1;
		dp[3][3] = 1;
		dp[2][1] = 1;
		for (int i = 4 ; i <= N ; i++) {
			for (int j = 1 ; j <= i/2 ; j++) {
				if ( j == 1) {
					dp[i][j] = i;
					continue;
				}
				dp[i][j] = (dp[i-2][j-1]+dp[i-1][j])%1000000003 ;

			}
		}
		
		/*for(int i = 4 ; i<= 10 ; i++) {
			for ( int j = 1 ; j<=10 ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
		System.out.println(dp[N][K]);
		
		
	}
	
}
