import java.util.*;

public class Main1 {
	static int A[];
	static int dp[];
	static int W,N;
	static int inf = 10000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		A = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			A[i] = in.nextInt();
		}
		
		dp = new int[64001];
		for ( int i = 0 ; i < 64001 ; i++) {
			dp[i] = -1;
		}
		W = in.nextInt();
		
		System.out.print(func(W));
		
	}
	
	public static int func(int now) {
		
		//System.out.println(now);
		
		if ( now == 0) {
			return 0;
		}
		
		int ret = dp[now];
		if (ret != -1) {
			return ret;
		}
		ret = inf;
		
		for ( int i = 0 ; i < N ; i++) {
			if ( now - A[i] >= 0 ) {
				ret = Math.min(ret, 1 + func(now-A[i]));
			}
		}
		
		return dp[now] = ret;
		
	}
}
