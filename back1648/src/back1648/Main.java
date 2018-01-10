package back1648;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static int N,M;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			N = 4; //in.nextInt();
			M = in.nextInt();
			dp = new int[N*M+1][1<<(M*2) + 1];
			for ( int i = 0 ; i <= N*M ; i++) {
				for ( int j = 0 ; j <= 1<<(M*2) ; j++) {
					dp[i][j] = -1;
				}
			}
			System.out.println(func(0,0));
			T--;
		}
		
	}
	
	public static int func(int now,int state) {
		
		if ( now == N*M) {
			return 1;
		}

		int ret = dp[now][state];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( (state&1) == 1 ) {
			return func(now+1,state>>1);
		}else {
			
			if ( (now + 1)% (M) != 0 && (state&1) == 0 && (state&2)==0) {
				ret += func(now+2,state>>2);
			}
			
			if ( now < (N-1)*M) {
				ret += func(now+1,(state>>1)|(1<<(M-1)));
			}
		}
		
		
		
		return ret%9901;
	}
}
