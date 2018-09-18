package back15967;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		System.out.println(1<<3);
		System.out.println(2<<1);
		System.out.println(1>>2);
		System.out.println(2>>1);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		
		int n = Integer.parseInt(st.nextToken());
		int q1 = Integer.parseInt(st.nextToken());
		int q2 = Integer.parseInt(st.nextToken());
		int arr[] = new int[n+1];
		long sum[] = new long[n+1];
		
		
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 1 ; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if ( i >= 1 ) {
				sum[i] = sum[i-1] + arr[i];
			}
		}
		
		
		for ( int i = 0 ; i < q1+q2 ; i++ ) {
			
			st = new StringTokenizer(br.readLine()," ");
			int com = Integer.parseInt(st.nextToken());
			
			if ( com == 1) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				System.out.print(sum[e]-sum[s-1]);
			}else {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				
				for ( int j = s ; j <= e ; j++) {
					arr[j] += l;
				}
				
				for ( int j = 1 ; j <= n ; j++) {
					if ( j >= 1 ) {
						sum[j] = sum[j-1] + arr[j];
					}
				}
				
			}
			
		}
		
	}
}
