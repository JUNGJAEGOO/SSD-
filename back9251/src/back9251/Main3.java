package back9251;

import java.util.Scanner;

public class Main3 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		char[] A = in.nextLine().toCharArray();
		char[] B = in.nextLine().toCharArray();
		
		int dp[][] = new int[A.length+1][B.length+1];
		
		for ( int i = 1 ; i <= A.length ; i++) {
			
			for ( int j = 1 ; j <= B.length; j++) {
				
				if ( A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
			
		}
		
		int max = 0;
		for ( int i = 0 ; i <= A.length ; i++) {
			for ( int j = 0 ; j <= B.length ; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.print(max);
	}
}
