package back2169;

import java.util.*;

public class Main {
	static int mat[][];
	static int N,M;
	static int inf = 100000000;
	static int X[] = {1,0,0};
	static int Y[] = {0,-1,1};
	static int dp[][][];
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N+2][M+2];
		dp = new int[N+2][M+2][3];
		visit = new boolean[N+2][M+2];
		
		for (int i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j<= M ; j++) {
				mat[i][j] = in.nextInt();
				for ( int k = 0 ; k < 3 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		

	}

}
