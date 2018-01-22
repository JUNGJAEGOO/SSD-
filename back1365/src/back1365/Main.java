package back1365;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int dp[] = new int[N];
		dp[0] = arr[0];
		
		int size = 1;
		for  (int i = 1 ; i< N ; i++) {
			if ( arr[i] > dp[size-1]) {
				dp[size] = arr[i]; 
				size++;
			}else if ( arr[1] < dp[0]) {
				dp[0] = arr[1];
			}else {
				int idx = Arrays.binarySearch(dp,0,size,arr[i]);
				//System.out.println(arr[i]+" "+idx);
				if ( idx < 0) {
					idx = -idx-1;
				}
				dp[idx] = arr[i];
			}
		}
		
		System.out.println(N-size);
	}
}
