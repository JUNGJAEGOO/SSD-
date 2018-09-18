package back2293;

import java.io.*;
import java.util.*;

public class Main {
	static int dp[];
	static int arr[];
	static int n,k;
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for ( int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[100_001];

		dp[0] = 1;
		for ( int j = 0 ; j < n ; j++) {
			for ( int i = 0 ; i < 100_001 ; i++ ) {

				if ( i-arr[j] >= 0 ) {
					dp[i] +=  dp[i-arr[j]];
				}
				
			}
			
		}
		
		for  (int i = 1 ; i < 20 ; i++) {
			System.out.print(dp[i]+ " ");
		}System.out.println();
		
		//System.out.println(k);
		System.out.print(dp[k]);
	}
	

}
