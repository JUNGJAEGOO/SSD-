package back1958;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] in1 = br.readLine().toCharArray();
		char[] in2 = br.readLine().toCharArray();
		char[] in3 = br.readLine().toCharArray();
		int n = in1.length;
		int m = in2.length;
		int k = in3.length;
		int dp[][][] = new int[101][101][101];
		for ( int i = 1 ; i <= n ; i++) {
			for ( int j = 1 ; j <= m ; j++) {
				for ( int s = 1 ; s <= k ; s++) {
					if ( in1[i-1] == in2[j-1] && in2[j-1] == in3[s-1] ) {
						dp[i][j][s] = dp[i-1][j-1][s-1] + 1;
					}else {
						dp[i][j][s] = Math.max(dp[i-1][j][s], Math.max(dp[i][j-1][s], dp[i][j][s-1]));
					}
				}	
			}	
		}
		
		System.out.println(dp[n][m][k]);
	}
}
