package back2410;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in=  new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[1000002];
		dp[0] = 1;
		//dp[1] = 1;
		
		int coin[] = new int[20];
		for (int i = 0 ; i < 20 ; i++) {
			coin[i] = (int)Math.pow(2,i);
			//System.out.println(coin[i]);
		}
		
		for (int i = 0 ; i < coin.length ; i++) {
			for (int j = coin[i] ; j <= N ; j++) {
				if ( j-coin[i] >= 0) {
					dp[j] = (dp[j-coin[i]]+dp[j])%1000000000;
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}
