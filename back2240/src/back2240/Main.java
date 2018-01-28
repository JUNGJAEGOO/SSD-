package back2240;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int W = in.nextInt();
		int arr[] = new int[T+1];
		for (int i = 1 ; i<= T ; i++) {
			arr[i] = in.nextInt();
		}
		int dp[][][] = new int[T+1][W+2][3];
		
		for ( int j = 1 ; j <= W+1; j++) {
			
			for ( int i = 1 ; i <= T; i++) {
				if ( arr[i] == 1) {
				
					dp[i][j][1] = Math.max(dp[i-1][j][1]+1,dp[i-1][j-1][2]+1);
					dp[i][j][2] = Math.max(dp[i-1][j-1][1],dp[i-1][j][2]);
					
				}
				else if ( arr[i] == 2) {
					
					dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][2]);
					dp[i][j][2] = Math.max(dp[i-1][j-1][1]+1,dp[i-1][j][2]+1);
					
				}
			}
			
		}
		
		int max = 0;
		for ( int i = 1 ; i <= W+1 ; i++) {
			//System.out.println(dp[T][i][1]+" "+dp[T][i][2]);
			max = Math.max(max,Math.max(dp[T][i][1],dp[T][i][2]));
		}
		System.out.print(max);
	}
}
