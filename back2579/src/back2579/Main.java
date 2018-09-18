package back2579;

import java.util.*;

public class Main {
	static int arr[];
	static int dp[][];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		arr = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		dp = new int[N+1][3];
		
		for ( int i = 0 ; i < 3 ; i++) {
			for ( int j = 0 ; j < N+1 ; j++) {
				dp[j][i] = -1;
			}
		}
		
		dp[1][1] = dp[1][2] = arr[1];
		System.out.println(Math.max(go(N,1), go(N,2)));
		
		/*for ( int i = 0 ; i < 2 ; i++) {
			for ( int j = 0 ; j < N+1 ; j++) {
				System.out.print(dp[j][i]+" ");
			}System.out.println();
		}*/
		
	}
	
	public static int go(int now,int before){
		
		//System.out.println(now+" "+before);
		
		if ( now == 0) {
			return 0;
		}
		
		int ret = dp[now][before];
		if ( ret != -1) {
			return ret;
		}

		ret = 0;
		
		
		if ( before != 1 ) {
				ret = Math.max(arr[now]+go(now-2,1), arr[now]+go(now-2,2));
			
		}else {
			
				ret = arr[now]+go(now-1,2);
			
		}
		

		
		return dp[now][before] = ret;
	}
}
