package back1660;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int sum = 3;
		int three = 3;
		int coin[] = new int[123];
		coin[1] = 1;
		for (int i = 2 ; i < 122 ; i++) {
			coin[i] = coin[i-1] + sum;
			sum += three;
			three++;
		}

		
		int dp[] = new int[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			dp[i] = N;
		}
		
		for ( int i = 1 ; i < coin.length ; i++) {
			if ( coin[i] <= N) {
				dp[coin[i]]=1;
			for ( int j = coin[i] ; j <= N ; j++) {
				//System.out.println(dp[j-coin[i]]);
				dp[j] = Math.min(dp[j-coin[i]]+1,dp[j]);
				
			}
			}
		}
		System.out.println(dp[N]);
	}
}
