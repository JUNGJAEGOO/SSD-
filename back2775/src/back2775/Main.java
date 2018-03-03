package back2775;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int dp[][] = new int[16][16];
		for (int i = 1 ; i <= 15 ; i++) {
			dp[0][i] = i;
		}
		for (int i = 1 ; i <= 15 ; i++) {
			for (int j = 1 ; j <= 15 ; j++) {
				dp[i][j] += dp[i][j-1] + dp[i-1][j];
			}
		}
		
		for (int i = 0 ; i <= 14 ; i++) {
			for (int j = 1 ; j<=14 ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		while ( T > 0) {
			
			
			int a = in.nextInt();
			int b = in.nextInt();
			
			
			System.out.print(dp[a][b]);
			

			T--;
		}
	}
}
