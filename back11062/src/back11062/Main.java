package back11062;

import java.util.*;

public class Main {
	static int arr[];
	static int dp[][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0 ) {
			
			int x = in.nextInt();
			
			arr = new int[x];
			
			for ( int i = 0 ; i < x ; i++) {
				arr[i] = in.nextInt();
			}
			
			dp = new int[1001][1001][2];
			for ( int i = 0 ; i < 1001 ; i ++) {
				for ( int j = 0 ; j < 1001 ; j++) {
					for ( int k = 0 ; k < 2 ; k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			
			
			System.out.println(func(0,x-1,1));
			
			T--;
		}
	}
	
	public static int func(int l, int r , int g) {
		
		if ( l==r && g == 1) {
			return arr[l];
		}
		
		if ( l==r && g == 0) {
			return 0;
		}
		
		int ret = dp[l][r][g];
		if ( ret != -1) {
			return ret;
			
		}
		
		ret = 0;
		
		if ( g == 1) {
			ret = Math.max(arr[l] + func(l+1,r,0), arr[r] + func(l,r-1,0) );
		}else if ( g == 0) {
			ret = Math.min(func(l+1,r,1), func(l,r-1,1) );
		}
		
		
		return dp[l][r][g] = ret;
	}
}
