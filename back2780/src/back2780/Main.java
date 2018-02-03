package back2780;

import java.util.Scanner;

public class Main {
	static int dp[][][];
	static int mat[][];
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while ( T> 0) {
			
			N = in.nextInt();
			dp = new int[1001][4][3];
			
			for (int i = 0 ; i < 1001 ; i++) {
				for (int j = 0 ; j < 4 ; j++) {
					for (int k = 0 ; k < 3 ; k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			
			int ans = 0;
			for (int i = 0 ; i < 4 ; i++) {
				for (int j = 0 ; j < 3 ; j++) {
					ans += (func(1,i,j));
					ans %= 1234567;
				}
			}
			sb.append(ans+"\n");
			T--;
		}
		System.out.print(sb);
	}
	
	public static int func(int len,int x,int y) {
		
		if ( x == 3 && y > 0 ) {
			return 0;
		}
		if ( len == N) {
			return 1;
		}
		
		int ret = dp[len][x][y];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for (int i = 0 ; i < 4 ; i++) {
			if ( x+X[i] < 4 && x+X[i] >= 0 && y+Y[i] < 3 && y+Y[i] >= 0 ) {
				
					ret += func(len+1,x+X[i],y+Y[i]);
					ret %= 1234567;
				
			}
		}
		
		return dp[len][x][y] = ret;
		
	}
}
