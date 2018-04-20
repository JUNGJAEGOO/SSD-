package back13301;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long dp[] = new long[81];
		
		dp[1] = 4;
		dp[2] = 6;
		for ( int i = 3 ; i < 81 ; i ++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.print(dp[N]);
	}
}
