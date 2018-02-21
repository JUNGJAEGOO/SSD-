package back13302;

import java.util.*;

public class Main {
	static int day[];
	static int dp[][];
	static int inf = 100000000;
	static int N,M;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		day = new int[N+1];
		for (int i = 0 ; i < M ; i++) {
			day[in.nextInt()-1] = 1;
		}
		dp = new int[101][101];
		for (int i = 0 ; i < 101 ; i++) {
			for (int j = 0 ; j < 101 ; j++) {
				dp[i][j] = -1;	
			}
		}
		System.out.println(func(0,0));
		
	}
	
	public static int func(int now,int coupon) {
		
		if ( now >= N) {
			return 0;
		}
		
		int ret = dp[now][coupon];
		if ( ret != -1) {
			return ret;
		}
		
		ret = inf;
		
		if ( day[now] == 1) {
			ret = Math.min(ret,func(now+1,coupon));
		}else if ( coupon >= 3 ){
			ret = Math.min(ret,func(now+1,coupon-3));
		}else {
			ret = Math.min(ret, 10000+func(now+1,coupon));
		}
		ret = Math.min(ret, 25000+func(now+3,coupon+1));
		ret = Math.min(ret, 37000+func(now+5,coupon+2));
		
		return dp[now][coupon] = ret;
		
	}
}
