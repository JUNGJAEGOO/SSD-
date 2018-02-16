package back14720;

import java.util.*;

public class Main {
	static int dp[][];
	static int arr[];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		dp = new int[3][N+1];
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < N+1 ; j++) {
				dp[i][j]= -1;
			}
		}
		arr = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.print(func(2,0));
		
	}
	public static int func(int before,int idx) {
		
		if ( idx >= N) {
			return 0;
		}
		
		int ret = dp[before][idx];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( arr[idx] == 0 && before == 2) {
			ret = Math.max(ret, 1+func(0,idx+1));
		}else if ( arr[idx] == 1 && before == 0) {
			ret = Math.max(ret, 1+func(1,idx+1));
		}else if ( arr[idx] == 2 && before == 1) {
			ret = Math.max(ret, 1+func(2,idx+1));
		}
		
		ret = Math.max(ret , func(before,idx+1));
		
		return dp[before][idx] = ret;
	}
}
