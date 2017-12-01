package back1699;

import java.util.Arrays;
import java.util.Scanner;

// ¹Ì°á 
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[100001];
		
		

		for ( int i = 1 ; i <= 100000 ; i++) {
				int min = i;
			for ( int j = 1 ; j*j <= i ; j++) {
				min = Math.min(min, dp[i-j*j]+1);
			}
			dp[i] = min;
		}
		
		for ( int i = 1 ; i <= 32 ; i++) {
			System.out.print(dp[i]+" ");
		}
		
		System.out.println(dp[N]);
	}
}
