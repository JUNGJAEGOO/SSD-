package back11053;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			dp[i] += 1;
		}
		
		
		
		for ( int i = 0 ; i < N ; i++) {

			for ( int j = 0 ; j < j ; j++) {
				
				if ( arr[j] > arr[i]) {
					if ( dp[i] + 1 > dp[j]) {
						dp[j] = dp[i] + 1;
					}
				}
				
			}
			
		}
		
	}
}
