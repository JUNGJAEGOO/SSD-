package back14697;

import java.util.*;

public class Main {
	static int A,B,C,N;
	static boolean pass = false;
	static long dp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		A = in.nextInt();
		B = in.nextInt();
		C = in.nextInt();
		N = in.nextInt();
		dp = new long[301];
		Arrays.fill(dp, -1);
		func(N);
		
		for (int i = 1 ; i <= N ; i++) {
			System.out.print(dp[i]+" ");
		}System.out.println();
		
		if ( dp[N] > 0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	public static long func (int sum) {
		
		//System.out.println(sum);
		
		if ( sum == 0) {
			return 1;
		}
		
		long ret = dp[sum];
		if ( ret != -1) {
			return ret;
		}
		ret= 0;
		
		if ( sum-A >= 0) {
			ret += func(sum-A)%1000000000;
		}
		if ( sum-B >= 0) {
			ret += func(sum-B)%1000000000;
		}
		if ( sum-C >= 0) {
			ret += func(sum-C)%1000000000;
		}
		
		return dp[sum] = ret;
	}
}
