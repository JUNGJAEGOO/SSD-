package back1520;

import java.util.*;

public class Main {
	static int N,M;
	static int mat[][];
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		M = in.nextInt();
		N = in.nextInt();
		mat = new int[M][N];
		
		for ( int i = 0 ; i < M ; i++) {
			for ( int j =0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		dp = new int[M][N];
		
		for ( int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(0,0));
		
	}
	
	public static int func(int x,int y) {
		
		//System.out.println(x+" "+y);
		
		if ( x == M-1 && y == N-1) {
			return 1;
		}
		
		int ret = dp[x][y];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( y < N-1) {
			if ( mat[x][y+1] < mat[x][y]) {
				ret += func(x,y+1);
			}
		}
		
		if ( y > 0) {
			if ( mat[x][y-1] < mat[x][y]) {
				ret += func(x,y-1);
			}
		}
		
		if ( x < M - 1) {
			if ( mat[x+1][y] < mat[x][y]) {
				ret += func(x+1,y);
			}
		}

		if ( x > 0) {
			if ( mat[x-1][y] < mat[x][y]) {
				ret += func(x-1,y);
			}
		}
		
		return dp[x][y] = ret;
	}
}
