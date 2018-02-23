package back15486;

import java.util.*;

public class Main {
	static int T[],P[];
	static int dp[];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		T = new int[N];
		P = new int[N];
		for (int i = 0 ; i < N ; i++) {
			T[i] = in.nextInt();
			P[i] = in.nextInt();
			
		}
		dp = new int[1500001];
		Arrays.fill(dp,-1);
		
		System.out.println(func(0));
		
		for (int i = 1 ; i <= N ; i++) {
			System.out.print(dp[i]+" ");
		}
	}
	
	public static int func(int day) {
		
		System.out.println(day+" ");
		
		int ret = dp[day];
		if ( ret != -1) {
			return ret;
		}
		if ( day == N) {
			return 0;
		}
		ret = func(day+1);
		if ( day + T[day] <= N) {
			ret = Math.max(ret, func(day+T[day])+P[day]);
		}
		
		
		return dp[day] = ret;
		
	}
}
