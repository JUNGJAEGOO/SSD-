package back4095;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		
		while ( true ) {
			int R = in.nextInt();
			int C = in.nextInt();
			if ( R == 0 && C == 0) {
				break;
			}
			
			int dp[][] = new int[R+1][C+1];
			int mat[][] = new int[R+1][C+1];
			for ( int i = 1 ; i <= R ; i++) {
				for (int j = 1 ; j <= C ; j++) {
					
					mat[i][j] = in.nextInt();
					
				}
			}
			
			for ( int i = 1 ; i <= R ; i++) {
				for (int j = 1 ; j <= C ; j++) {
					
					if ( mat[i][j] != 0 ) {
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
					}
				}
			}
			
			
			int max = 0;
			for ( int i = 1 ; i <= R ; i++) {
				for (int j = 1 ; j <= C ; j++) {
					
					max = Math.max(max, dp[i][j]);
					//System.out.print(dp[i][j]+" ");
				}//System.out.println();
			}
			
			System.out.println(max);
			
		}
	}
}
