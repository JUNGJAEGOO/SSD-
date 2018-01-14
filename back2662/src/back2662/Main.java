package back2662;

import java.util.Scanner;

// 미완

public class Main {
	static int MAX,N;
	static int arr[][];
	static int dp[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		MAX = in.nextInt();
		N = in.nextInt();
		arr = new int[MAX+1][N+1];
		dp = new int[MAX+1][N+1];
		for ( int i = 0 ; i < MAX ; i++) {
			int cost = in.nextInt();
			for ( int j = 1 ; j <= N ; j++) {   // 0 은 기업 A 1은 기업 B...
				int pay = in.nextInt();
				arr[cost][j] = pay;
			}
		}
		
		for ( int i = 1 ; i <= MAX ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				dp[i][j] = Math.max(dp[i][j-1], arr[i][j]);
				for ( int k = 1 ; k < i ; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[k][j-1]+arr[i-k][j]);
				}
			}
		}
		
		for ( int i = 1 ; i <= MAX; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
	}
	
}
