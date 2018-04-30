package back1535;

import java.util.*;

public class Main {
	static int N;
	static int dmg[];
	static int joy[];
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dmg = new int[N];
		joy = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			dmg[i] = in.nextInt();
			
		}
		
		for ( int i = 0 ; i < N ; i++) {
			joy[i] = in.nextInt();
			
		}
		
		//System.out.print(1<<20);
		
		dp = new int[21][101];
		for (int i = 0 ; i < 21 ; i++) {
			for ( int j = 0 ; j < 101 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(100,0));
		
	}
	
	public static int func(int hp,int idx) {
		
		if ( idx == N) {
			return 0;
		}
		
		int ret = dp[idx][hp];
		if ( ret != -1) {
			return ret;
		}
		
		ret = 0 ;
		
		ret = Math.max(ret, func(hp,idx+1));
		
		if ( hp - dmg[idx] > 0) {
			ret = Math.max(ret, func(hp-dmg[idx],idx+1) + joy[idx]);
		}
		
		return dp[idx][hp] = ret;
	}
}
