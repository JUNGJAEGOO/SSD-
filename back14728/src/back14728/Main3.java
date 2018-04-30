package back14728;

import java.util.*;

public class Main3 {
	static int dp[][];
	static int N;
	static int time[];
	static int point[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int K = in.nextInt();
		
		time = new int[N];
		point = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			time[i] = in.nextInt();
			point[i] = in.nextInt();
			
		}
		
		dp = new int[101][10001];
		for ( int i = 0 ; i < 101 ; i++) {
			for (int j = 0 ; j < 10001 ; j++) {
				dp[i][j] = -1;
			}
		}
	
		System.out.print(func(0,K));
	}
	
	public static int func(int idx,int hp) {
		
		if ( idx == N) {
			return 0;
		}
		
		int ret = dp[idx][hp];
		if ( ret != -1) {
			return ret;
		}
		ret= 0;
		
		ret = Math.max(ret, func(idx+1,hp));
		
		if ( hp - time[idx] >= 0) {
			ret = Math.max(ret, func(idx+1,hp-time[idx]) + point[idx]);
		}
		
		return dp[idx][hp] = ret;
	}
}
