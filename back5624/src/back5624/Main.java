package back5624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		boolean dp[] = new boolean[400002];

		int ans = 0;
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j < i ; j++) {
				if ( dp[ arr[i] - arr[j] + 200000 ]  ) {
					//System.out.println(arr[i]-arr[j]);
					ans++;
					break;
					
				}
			}
			for ( int j = 1 ; j<= i ; j++) {
				dp[arr[i] + arr[j] + 200000] = true;
			}
		}
		
		/*for ( int i = 200000 ; i<= 200050 ; i++) {
			if ( dp[i]) {
			System.out.print(i+" ");
			}
		}*/
	
		System.out.println(ans);
	}
}
