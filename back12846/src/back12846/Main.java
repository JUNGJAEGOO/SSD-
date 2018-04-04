package back12846;

import java.util.*;

public class Main {
	static int N;
	static int arr[];
	static int dp[];
	
	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		
	}
	
	public static int func(int idx) {
		
		int ret = dp[idx];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = idx+1 ; i < N ; i++) {
			
		}
	}
}
