package back1495;

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner( System.in);
		int N = in.nextInt();
		int S = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int dp[][] = new int[N+1][M+1];
		dp[0][S] = 1;
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 0 ; j <= M ; j++ ) {
				if ( dp[i-1][j] == 1) {
					if ( j+arr[i] <= M) {
						dp[i][j+arr[i]] = 1;
					}
					if ( j-arr[i] >= 0) {
						dp[i][j-arr[i]] = 1;
					}
				}
			}
		}
		/*for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 0; j<= M ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		*/
		for (int i = M ; i>= 0  ; i--) {
			if ( dp[N][i] == 1) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}
	

}
