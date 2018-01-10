package back2133;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int N = 30;
		int dp[] = new int[N+1];
		dp[2] = 3;
		int dp2[] = new int[N+1];
		for ( int i = 4 ; i <= N ; i+=2) {
			dp[i] = 2;
		}
		dp2[0] =1;
		for ( int i = 2 ; i <= N ; i+=2) {
			for ( int j = 2 ; j <= i ; j+=2) {
				dp2[i] += dp[j] * dp2[i-j];
			}
		}
		
		System.out.println(dp2[n]);
	}
}
