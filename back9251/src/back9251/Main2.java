package back9251;

import java.util.Scanner;

public class Main2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char one[] = in.nextLine().toCharArray();
		char two[] = in.nextLine().toCharArray();
		int dp[][] = new int[one.length+1][two.length+1];
		
		for (int i = 1; i <= one.length ; i++) {
			for (int j = 1 ; j <= two.length ; j++) {
			
				if ( one[i-1] == two[j-1] ) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
				
			}
		}
		
		for (int i = 0 ; i <= one.length ; i++) {
			for (int j = 0 ; j <= two.length ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		System.out.print(dp[one.length][two.length]);
	}
}
