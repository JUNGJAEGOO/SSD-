package back2240;

import java.io.*;
import java.util.*;

public class Main {
	static int T,W;
	static int arr[];
	static int dp[][][];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[T+1];
		for ( int i = 1 ; i <= T ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[3][1001][31];
		for (int i = 0 ; i< 3 ; i++) {
			for ( int j = 0 ; j < 1001 ; j++) {
				for ( int k = 0 ; k < 31 ; k++) {
					dp[i][j][k] = -1;
				}	
			}
		}
		
		System.out.print(func(1,0,W));
		
	}
	
	public static int func(int pos,int time,int limit) {
		
		if ( time == T ) {
			return 0;
		}
		
		int ret = dp[pos][time][limit];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( pos == 1) {
			if ( arr[time+1] == 1) {
				ret = Math.max(ret, 1 + func(1,time+1,limit));
			}else {
				ret = Math.max(ret, func(1,time+1,limit));
			}
			
			if ( limit -1 >= 0 ) {
				if ( arr[time+1] == 2) {
					ret = Math.max(ret , 1 + func(2,time+1,limit-1));
				}else {
					ret = Math.max(ret , func(2,time+1,limit-1));
				}
			}
			
		}else {
			if ( limit-1 >= 0) {
				if ( arr[time+1] == 1) {
					ret = Math.max(ret, 1 + func(1,time+1,limit-1));
				}else {
					ret = Math.max(ret, func(1,time+1,limit-1));
				}
			}
			
			if ( arr[time+1] == 2) {
				ret = Math.max(ret , 1 + func(2,time+1,limit));
			}else {
				ret = Math.max(ret , func(2,time+1,limit));
			}
		}
		
		return dp[pos][time][limit] = ret;
	}
}
