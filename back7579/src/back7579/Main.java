package back7579;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int arr[],cost[];
	static int dp[];
	static int inf = 1000000000;
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		int sum = 0;
		arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		cost = new int[N];
		for (int i = 0 ; i < N ; i++) {
			cost[i] = in.nextInt();
			sum += cost[i];
		}
		visit = new boolean[N];
		dp = new int[10000001];
		for (int i = 0 ; i <= 10000000 ; i++) {
				dp[i] = 0;
			
		}
		
		for (int i = 0 ; i < N ; i++) {
			// ÄÚ½ºÆ®
			for ( int j = cost[i] ; j <= sum ; j++) {
				
					dp[j] = Math.max(dp[j], dp[j-arr[i]]+cost[i] );
				
			}
		}
		
		for (int i = 0 ; i <= 60 ; i++) {
			System.out.print(dp[i]+" ");
		}
		
	}
	

}
