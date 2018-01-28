package back10971;

import java.util.Scanner;

public class Main {
	static int mat[][];
	static int dp[][];
	static int N;
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		//System.out.println(0|1<<2);
		N = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		dp = new int[N+1][(1<<N)+1];
		for (int i = 0 ; i <= N ; i++) {
			for (int j = 0 ; j <= (1<<N) ; j++) {
				dp[i][j] = -1;
			}
		}
		
		//System.out.println((1<<N)-1);
		
		int ans = inf;
		
		ans = func(0,0);
			//System.out.println(ans);
		
		System.out.println(ans);
	}
	
	public static int func(int pos,int visit) {
		
		//System.out.println(pos+" "+visit);
		
		if ( visit == (1<<N)-1) {
			return mat[pos][0];  // 이걸 왜 하노
		}
		
		int ret = dp[pos][visit];
		if ( ret != -1) {
			return ret;
		}
		ret= inf;
		
		for (int i = 0 ; i < N ; i++) {
			
			if ( mat[pos][i] != 0) {
				//System.out.println(( visit & ( 1<<(i) )));
				if ( ( visit &  (1<<i) )  == 0) {
					ret = Math.min(ret, mat[pos][i] + func(i,visit|(1<<i)) );
				}
			}	
			
		}
		
		//System.out.println(ret);
	
		return dp[pos][visit] = ret;
		
	}
}
