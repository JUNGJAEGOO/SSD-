package back12847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		int arr[] = new int[n+1];
		long sum[] = new long[n+1];
		for ( int i = 1 ; i<= n ; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());;
		}
		
		int cnt = 0;
		long max = 0;
		while ( true) {
			for ( int i = 0 ; i < m ; i++) {
				sum[cnt] += arr[cnt+i];
			}
			if ( max < sum[cnt]) {
				max = sum[cnt];
			}
			cnt++;
			if ( m + cnt > n) {
				break;
			}
		}
		System.out.println(max);
	}
}
