package back2565;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[501];
		int dp[] = new int[501];
		for (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			arr[x] = in.nextInt();
			dp[x] = 1;
		}
		
		
		for (int i = 1 ; i < 501 ; i++) {
			
			
			for (int j = 0 ; j < i ; j ++) {
				if ( arr[j] < arr[i]) {
					if ( dp[j] == dp[i]) {
						dp[i] = 1 + dp[j];
					}
				}
			}	
		}
		for (int i = 1 ; i < 15 ; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		Arrays.sort(dp);
		System.out.println(N-dp[dp.length-1]);
	}
}
