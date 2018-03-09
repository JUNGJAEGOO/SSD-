package back11388;

import java.util.*;

public class Main {
	static long dp[];
	static int arr[];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dp = new long[1000001];
		for (int i = 0 ; i < 1000001 ; i++ ) {
			dp[i] = -1;
		}
		arr = new int[N+1];
		for (int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println(func(0,1));
		
		for (int i = 0 ; i <= N ; i++) {
			System.out.print(dp[i]+" ");
		}
	}
	
	public static long func(int now,int num) {
		
		
		System.out.println(now+" "+num);
		
		if ( now == N ) {
			return 0;
		}
		
		long ret = dp[now];
		if ( ret != - 1) {
			return ret;
		}
		
		ret = 0;
		ret = Math.max(ret, num*arr[now+1]+func(now+1,num+1));
		ret = Math.max(ret, func(now+1,num));
		
		return dp[now] = ret;
	}
}
