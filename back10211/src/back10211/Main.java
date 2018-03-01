package back10211;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			int num = in.nextInt();
			int arr[] = new int[num];
			for (int i = 0 ; i < num ; i++) {
				arr[i] = in.nextInt();
			}
			int dp[] = new int[num];
			dp[0] = arr[0];
			for (int i = 1 ; i < num ; i++) {
				if ( dp[i-1] >= 0) {
					dp[i] = arr[i] + dp[i-1];
				}else {
					dp[i] = arr[i];
				}
			}
			
			
			Arrays.sort(dp);
			System.out.println(dp[dp.length-1]);
			T--;
		}
	}
}
