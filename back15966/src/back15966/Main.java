package back15966;

import java.io.*;
import java.util.*;

public class Main {
	static int dp[];
	static int arr[];
	static int N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st  =new StringTokenizer(br.readLine()," ");
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		
		for  (int i = 0 ; i < N ; i++) {
			dp[i] = 1;
			
			for ( int j = 0 ; j < i ; j++) {
				
				if ( arr[i] - 1 == arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		
		int max = 0;
		for (int i = 0 ; i < N ; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.print(max);
	}
	

}
