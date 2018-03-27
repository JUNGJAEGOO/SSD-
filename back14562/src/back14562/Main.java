package back14562;

import java.util.*;

public class Main {
	static int dp[][];
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T> 0) {
			
			int A = in.nextInt();
			int B = in.nextInt();
			
			dp = new int[2001][2001];
			for (int i = 0 ; i < 2001 ; i++) {
				for (int j = 0 ; j < 2001 ; j++) {
					dp[i][j] = -1;
				}
			}
			
			System.out.println(func(A,B));
			
			T--;
		}
	}
	
	public static int func(int A,int B) {
		
		//System.out.println(A+"  "+B);
		
		if ( A > B) {
			return inf;
		}
		
		if ( A == B) {
			return 0;
		}
		
		int ret = dp[A][B];
		if ( ret != -1) {
			return ret;
		}
		
		ret = Math.min(1+func(A+A,B+3), 1+func(A+1,B));
		
		return dp[A][B] = ret;
		
	}
}
