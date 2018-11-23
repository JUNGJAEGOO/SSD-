package back2315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int inf = Integer.MAX_VALUE;
	static int dp[][][];
	static int D[];
	static int W[];
	static int N,M;
	static int sum[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = 0;
		sum = new int[N+1];
		D = new int[N+1];
		W = new int[N+1];
		
		for ( int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dist = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			D[i] = dist;
			W[i] = w;
			
			sum[i] = sum[i-1] + w;
			
		}
		
		dp = new int[1001][1001][2];
		for ( int i = 0 ; i < 1001 ; i++) {
			for ( int j  = 0 ; j < 1001 ; j++) {
				for ( int k = 0 ; k < 2 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		
		System.out.print( func(M,M,0) );
		
	}
	
	public static int func(int left, int right, int dir) {
		
		
		if ( left == 1 && right == N) {
			return 0;
		}
		
		int ret = dp[left][right][dir];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		int now = dir == 0 ? left : right;
		if ( left - 1 >= 1 ) {
			ret = Math.min(ret, func(left-1,right,0) + (D[now]-D[left-1])*(sum[N]-sum[right]+sum[left-1]) );
			
		}
		
		if ( right + 1 <= N ) {
			ret = Math.min(ret, func(left,right+1,1) + (D[right+1]-D[now])*(sum[N]-sum[right]+sum[left-1]) );
			
		}
		
		
		return dp[left][right][dir] = ret;
		
	}
}
