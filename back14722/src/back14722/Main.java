package back14722;

import java.util.*;

public class Main {
	static int mat[][];
	static int dp[][][];
	static int N;
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		dp = new int[3][N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				for (int s = 0; s < 3 ; s++) {
					dp[s][i][j] = -1;
				}
			}
		}
		
		System.out.println(func(2,0,0));
	}
	
	public static int func(int before,int X,int Y) {
		if ( X >= N || Y >= N) {
			return -inf;
		}
		
		if ( X == N-1 && Y == N-1) {
			
			if ( before == 0) {
				if ( mat[N-1][N-1] == 1) {
					return 1;
				}
			}else if ( before == 1) {
				if ( mat[N-1][N-1] == 2) {
					return 1;
				}
			}else if ( before == 2) {
				if ( mat[N-1][N-1] == 0) {
					return 1;
				}
			}
			
			return 0;
		}
		
		int ret = dp[before][X][Y];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( before == 0) {
			if ( mat[X][Y] == 1) {
				ret = Math.max(ret, 1+func(1,X+1,Y));
				ret = Math.max(ret, 1+func(1,X,Y+1));
			}
				
		}else if ( before == 1) {
			if ( mat[X][Y] == 2) {
				ret = Math.max(ret, 1+func(2,X+1,Y));
				ret = Math.max(ret, 1+func(2,X,Y+1));
			}
		}else if ( before == 2) {
			if ( mat[X][Y] == 0) {
				ret = Math.max(ret, 1+func(0,X+1,Y));
				ret = Math.max(ret, 1+func(0,X,Y+1));
			}
		}
		
		ret = Math.max(ret, func(before,X+1,Y));
		ret = Math.max(ret, func(before,X,Y+1));
		
		return dp[before][X][Y] = ret;
	}
}
