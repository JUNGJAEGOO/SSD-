package back2698;

import java.util.Scanner;

public class Main {
	static long dp[][][];
	static int n,k;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		dp = new long[101][101][2];
		
		
		
		while ( T > 0) {
			
			n = in.nextInt();
			k = in.nextInt();
			
			for (int i = 0 ; i <= 100 ; i++) {
				for ( int j = 0 ; j <= 100 ; j++) {
					for ( int k = 0 ; k < 2 ; k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			
			long ans = 0;
			ans += func(0,0,0);
			System.out.println(ans);
			//ans += func(0,0,1);
			
			//System.out.println(ans);
			T--;
		}
	}
	
	public static long func(int len,int cnt,int before) {
		
		
		if ( len == n ) {
			if ( cnt == k) {
				return 1;
			}else {
				return 0;
			}
		}
		
		long ret = dp[len][cnt][before];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( before == 1) {
			ret += func(len+1,cnt+1,1);
			ret += func(len+1,cnt,0);
		}else {
			ret += func(len+1,cnt,1);
			ret += func(len+1,cnt,0);
		}
			
		//System.out.println();
		return dp[len][cnt][before] = ret;
		
	}
}
