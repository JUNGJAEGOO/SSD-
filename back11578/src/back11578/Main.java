package back11578;

import java.util.*;

public class Main {
	
	static ArrayList<Integer> person[];
	static int N,M;
	static int dp[][];
	static int inf = 10000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		//System.out.print(1<<10);
		
		person = new ArrayList[N];
		for ( int i = 0 ; i < N ; i++) {
			person[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int n = in.nextInt();
			for ( int j = 0 ; j <  n ;j++) {
				person[i].add(in.nextInt()-1);
			}
		}
		
		dp = new int[1<<11][1<<11];
		for ( int i = 0 ; i < 1<<11 ; i++) {
			for ( int j = 0 ; j < 1<<11 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		
		int ans = func(0,0);
		if ( ans == inf) {
			System.out.print(-1);
		}else {
			System.out.print(ans);
		}
	}
	
	public static int func(int len,int p) {
	
		if ( len == N) {
			if ( p == (1<<(M)) - 1 ) {
				return 0;
			}else {
				return inf;
			}
		}
		
		int ret = dp[len][p];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		ret = Math.min(ret, func(len+1,p));
		
		int tmp = p;
		for ( int j = 0 ; j < person[len].size() ; j++ ) {
			
			tmp = tmp | (1<<person[len].get(j));
			
		}
		
		ret = Math.min(ret,1+func(len+1,tmp));

		
		return dp[len][p] = ret;
	}
}
