package back9084;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T> 0) {
			
			int N = in.nextInt();
			int coin[] = new int[21];
			Arrays.fill(coin, 0);
			 // Å¸°Ù
			
			
			for ( int i = 0 ; i < N ; i++) {
				coin[i] = in.nextInt();
			}
			int M = in.nextInt();
			int dp[] = new int[10001];
			Arrays.fill(dp,0);
			
			for ( int i = 0 ; i < N ; i++) {
				dp[coin[i]]++;
				for ( int j = coin[i]+1 ; j <= M ; j++) {
					//if ( j-coin[i] >= 0 ) {
						dp[j] = dp[j] + dp[j-coin[i]];
					//}
				}
			}
			
			System.out.println(dp[M]);
			
			T--;
		}
	}
}
