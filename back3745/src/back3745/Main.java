package back3745;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while ( true ) {
			String first = br.readLine();
			if ( first == null) {
				break;
			}
			int N = Integer.parseInt(first);
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int arr[] = new int[N+1];
			for (int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				//arr[i] = 1;
			}
			int[] dp = new int[N+1];
			dp[0] = arr[0];
			int len = 0;
			for (int i = 1 ; i< N ; i++) {
				if ( arr[i] > dp[len] ) {
					len++;
					dp[len] = arr[i];
				}else {
					
					int idx = Arrays.binarySearch(dp,0,len, arr[i]);
					
					if ( idx < 0 ) {
						idx = -idx -1;
					}
					//System.out.println(idx);
					dp[idx] = arr[i];
				}
				
			}
			
			
			sb.append(len+1+"\n");
		}
		System.out.print(sb);
	}
}
