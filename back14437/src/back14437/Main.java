package back14437;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		int len = c.length;
		
		int dp[][] = new int[3001][3001];
		
		for ( int i = 2 ; i <= 3000 ; i++) {
			dp[i][1] = i;
			for ( int j = 1 ; j <= 3000 ; j++) {
				if ( j >= 26) {
					dp[i][j] = ((dp[i][j-1] + dp[i-1][j])% 1_000_000_007 - dp[i-1][j-26] + 1_000_000_007) % 1_000_000_007;
				}else {
					dp[i][j] = (dp[i][j-1] + dp[i-1][j] ) % 1_000_000_007;
				}
			}
		}
		
		System.out.print(dp[len][N]);
	}
}
