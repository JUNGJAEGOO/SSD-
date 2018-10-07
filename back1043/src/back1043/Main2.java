package back1043;

import java.util.*;

public class Main2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[][] = new int[N][2];
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}

		for ( int i = 0 ; i < N ; i++) {
		
			if ( i >= 2) {
				dp[i][0] = Math.max(dp[i-2][0] + arr[i],Math.max(dp[i-2][1] + arr[i], Math.max(dp[i-1][0], dp[i-1][1])));
			}else {
				dp[i][0] = arr[i];
			}
			
			if ( i >= 1 ) {
				dp[i][1] = dp[i-1][0] + arr[i];
			
			}
			
		}
		
		int ans = 0;
		for ( int i = 0 ; i < N ; i++) {
			ans = Math.max(ans, dp[i][0]);
			//System.out.print(dp[i][0]+" ");
		}//System.out.println();
		
		for ( int i = 0 ; i < N ; i++) {
			ans = Math.max(ans, dp[i][1]);
			//System.out.print(dp[i][1]+" ");
		}//System.out.println();
		
		
		System.out.println(ans);
		
	}
}
