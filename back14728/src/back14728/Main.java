package back14728;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int maxW = in.nextInt();
		int dp[][] = new int[N+1][maxW+1];
		int weight[] = new int[N+1];
		int value[] = new int[1+N];
		
		for ( int i =0  ; i <N ; i++) {
			weight[i] = in.nextInt();
			value[i] = in.nextInt();
		}
		
		for ( int j = 0 ; j<=maxW ; j++) {
			for ( int i = 1 ; i <= N ; i++) {
				if ( j-weight[i-1]>=0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]]+value[i-1]);
				}else if ( j-weight[i-1]<0) {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
/*		for( int i = 1 ; i <= N ; i++) {
			for(int j = 1;j<=maxW;j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		*/
		System.out.println(dp[N][maxW]);
	}
}
