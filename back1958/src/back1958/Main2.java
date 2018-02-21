package back1958;

import java.util.Scanner;

public class Main2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char one[] = in.nextLine().toCharArray();
		char two[] = in.nextLine().toCharArray();
		char three[] = in.nextLine().toCharArray();
		
		int dp[][][] = new int[one.length+1][two.length+1][three.length+1];
		
		for (int i = 1; i <= one.length ; i++) {
			for (int j = 1 ; j <= two.length ; j++) {
				for (int k = 1 ; k<= three.length ; k++) {
	
					if ( one[i-1] == two[j-1] && two[j-1] == three[k-1]) {
						dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					}else {
						dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
					}
				
				}
			}
		}
		
		for (int i = 0 ; i <= one.length ; i++) {
			for (int j = 0 ; j <= two.length ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		System.out.print(dp[one.length][two.length][three.length]);
	}
}
