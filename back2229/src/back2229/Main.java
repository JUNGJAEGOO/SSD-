package back2229;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[N+1];
		int arr[] = new int[N+1];
		for ( int i =1 ; i<= N ;i++) {
			arr[i] = in.nextInt();
		}
		

		for ( int i = 1 ; i <= N ; i++) {
			
			int res = 0;
			int max = 0;
			int min = Integer.MAX_VALUE;
			for ( int j = i ; j > 0 ; j--) {
				if ( arr[j]>max) {
					max = arr[j];
				}
				if ( arr[j]<min) {
					min = arr[j];
				}
				
				res = Math.max(res, dp[j-1]+max-min);
				
			}
			
			dp[i] = res;
			System.out.print(dp[i]+" ");
		}
		
		
	}
}
