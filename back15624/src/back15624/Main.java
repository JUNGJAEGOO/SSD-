package back15624;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int dp[] = new int[1000001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for ( int i = 3; i < 1000001; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
		}
		
		System.out.print(dp[N]);
	}
}
