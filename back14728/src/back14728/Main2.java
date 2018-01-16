package back14728;

import java.util.Scanner;

public class Main2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		int arr[][] = new int[N+1][2];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		
		int dp[][] = new int[N+1][T+1];
		
		for ( int i = 1 ; i <= N ; i++) {
			
			for ( int j = 1 ; j <= T ; j++) {
				if ( arr[i][0] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], arr[i][1]+dp[i-1][j-arr[i][0]]);
					
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		
		System.out.println(dp[N][T]);
	}
}
