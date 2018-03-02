package back5528;

import java.util.Scanner;

public class Main {
	static int dp[][][][];
	static int N,M;
	static char[] S;
	static char[] T;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		char[] s = in.nextLine().toCharArray();
		char[] t = in.nextLine().toCharArray();
		
		S = new char[N+1];
		T = new char[M+1];
		for (int i = 1 ; i <= N ; i++) {
			S[i] = s[i-1];
		}
		for (int i = 1 ; i <= M ; i++) {
			T[i] = t[i-1];
		}
		
		dp = new int[2001][2001][2][2];
		for (int i = 0 ; i < 2001 ; i++) {
			for (int j = 0 ; j < 2001 ; j++) {
				for (int k = 0 ; k < 2 ; k++) {
					for (int z = 0 ;z < 2 ; z++) {
						dp[i][j][k][z] = -1;
					}
				}
			}
		}
		
		int ans = 0;
		ans = Math.max(ans, func(0,0,0,0));
		
			if ( ans%2 == 1 ) {
				System.out.println(ans);
			}else {
				System.out.println(ans-1);
			}
		
	}
	
	public static int func(int l,int r,int state,int jump) {
		
		//System.out.println(l+" "+r+" "+state);
		
		int ret = dp[l][r][state][jump];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		if ( state == 0) {
			if( l+1 <= N && S[l+1] == 'I') {
				ret = Math.max(ret,func(l+1,r,1,jump)+1);
			}
			if ( r+1 <= M &&  T[r+1] == 'I' ) {
				ret = Math.max(ret,func(l,r+1,1,jump)+1);
			}
		}else {
			if( l+1 <= N && S[l+1] == 'O' ) {
				ret = Math.max(ret,func(l+1,r,0,jump)+1);
			}
			if ( r+1 <= M && T[r+1] == 'O' ) {
				ret = Math.max(ret,func(l,r+1,0,jump)+1);
			}
		}
		if ( jump == 0) {
			for (int i = l ; i <= N ; i++) {
				for (int j = r ; j<= M ; j++) {
					ret = Math.max(ret, func(i,j,state,1));
				}
			}	
		}
		
		return dp[l][r][state][jump] = ret;
		
	}
}
