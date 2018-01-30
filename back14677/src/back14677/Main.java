package back14677;

import java.util.Scanner;

public class Main {
	static int N;
	static char IN[];
	static int dp[][][];
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		IN = in.nextLine().toCharArray();
		dp = new int[3][N*3+1][N*3+1];
		
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0 ; j <= N*3 ; j++) {
				for (int k = 0 ; k <= N*3 ; k++) {
					dp[i][j][k] = -1;
				}	
			}
		}
		
		if ( IN[0] != 'B' && IN[IN.length-1] != 'B') {
			System.out.println(0);
			return;
		}
		int ans1=0,ans2=0;
		if ( IN[0] == 'B') {
			ans1 = 1+func(0,0,1,IN.length-1);
		}
		if ( IN[IN.length-1] == 'B') {
			ans2 = (1+func(0,0,0,IN.length-2));
		}
		System.out.println(Math.max(ans1,ans2));
	}
	
	// B = 0 L = 1 D = 2
	public static int func(int day,int state,int l,int r) {
		
		//System.out.println(day+": "+state+" "+l+" "+r);
		
		if ( day == N) {
			return 0;
		}
		
		int ret = dp[state][l][r];
		if ( ret != - 1) {
			return ret;
		}
		ret = 0;
		
		if ( state == 0) {
			if ( IN[l] == 'L') {
			ret = Math.max(ret, 1+func(day,1,l+1,r) );
			}
			if ( IN[r] == 'L') {
			ret = Math.max(ret, 1+func(day,1,l,r-1) );
			}
		}else if ( state == 1) {
			if ( IN[l] == 'D') {
			ret = Math.max(ret, 1+func(day+1,2,l+1,r) );
			}
			if ( IN[r] == 'D') {
			ret = Math.max(ret, 1+func(day+1,2,l,r-1) );
			}
		}else if ( state == 2) {
			if ( IN[l] == 'B') {
				
			ret = Math.max(ret, 1+func(day,0,l+1,r));
			}
			if ( IN[r] == 'B') {
			ret = Math.max(ret, 1+func(day,0,l,r-1));
			}
		}
		
		
		return dp[state][l][r] = ret;
	}
}
