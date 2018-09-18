package back1904;

import java.util.*;

public class Main {
	static int N;
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		dp = new int[2][1000001];
		for (int i = 0 ; i < 2 ; i++) {
			for ( int j = 0 ; j < 1000001 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(0,0));
		
	}
	
	public static int func(int now,int len) {
		
		//System.out.println(now + " " + len);
		
		if ( len == N) {
			return 1;
		}
		
		int ret = dp[now][len];
		if ( ret != -1) {
			return ret;
		}
		ret= 0;
		
		if ( len+2 <= N) {
			ret += func(0,len+2);
		}
		if ( len+1 <= N) {
			ret += func(1,len+1);
		}
		
		//System.out.print("ret "+ret);
		
		return dp[now][len] = ret % 15746;
		
	}
}
