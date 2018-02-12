package back2747;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[46];
		dp[1] = 1;  dp[2] = 1;
		for (int i = 3 ; i <= N ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
