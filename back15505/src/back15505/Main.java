package back15505;

import java.util.*;

public class Main {
	static int N,M;
	static int R[][];
	static int B[][];
	static int G[][];
	static int Y[][];
	static int dp[][];
	static int ans = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		R = new int[N+1][M+1];
		G = new int[N+1][M+1];
		B = new int[N+1][M+1];
		Y = new int[N+1][M+1];
		
		dp = new int[101][4];
		for (int i = 1 ; i <= 100 ; i++) {
			for (int j = 0 ; j < 4 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				R[i][j] = in.nextInt();
			}
		}
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				B[i][j] = in.nextInt();
			}
		}
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				G[i][j] = in.nextInt();
			}
		}
		for ( int i =  0; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				Y[i][j] = in.nextInt();
			}
		}
		
		System.out.println(func(1,0));
		
		System.out.println("»¡ ÆÄ ÃÊ ³ë");
		for ( int i = 0 ; i <= 100 ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		
		System.out.println(ans);
	}
	
	static int func(int idx,int color) {
		
		if ( idx == N*M+1) {
			return 0;
		}
		
		int ret = dp[idx][color];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		int row = (idx-1)/M;
		int col = (idx-1)%M;
		
		ret = Math.max(ret, R[row][col]+func(idx+1,0));
		ret = Math.max(ret, B[row][col]+func(idx+1,1));
		ret = Math.max(ret, G[row][col]+func(idx+1,2));
		ret = Math.max(ret, Y[row][col]+func(idx+1,3));
		
		return dp[idx][color] = ret;
	}
}
