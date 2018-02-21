package back11000;

import java.util.*;

public class Main {
	static int mat[][];
	static int dp[][];
	static int N;
	static int max = 0;
	static ArrayList<Integer> res = new ArrayList<>();

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N+1][N+1];
		for (int i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j <= N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		dp = new int[N+1][(1<<21)+1];
		for (int i = 0 ; i <= N ; i++) {
			for (int j = 0 ; j <= (1<<21) ; j++) {
				dp[i][j] = -1;
			}
		}
	
		System.out.println(func(1,1<<1)+1);
		
		
		
	}
	
	public static int func(int now,int visit) {
		//System.out.println(now+" "+visit);
		int ret = dp[now][visit];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		for ( int i = 1 ; i <= N ; i++) {
			if ( mat[now][i] == 1) {
				if ( (visit & (1<<i) ) == 0) {
					ret = Math.max(ret,1+ func(i,visit|(1<<i)));
				}
			}
		}
	
		
		return dp[now][visit] = ret;
	}
	
}
