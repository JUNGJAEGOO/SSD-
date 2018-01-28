package back2228;

import java.util.Scanner;

public class Main {
	static int N,M;
	static long dp[][][];
	static int arr[];
	static int sum[];
	static int inf = -32768*1000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		dp = new long[101][101][101];
		for (int i = 0 ; i <= 100 ; i++) {
			for (int j = 0 ; j <= 100 ; j++) {
				for (int k = 0 ; k <= 100 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		arr = new int[N+1];
		for (int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		sum = new int[N+1];
		
		for (int i = 1 ; i<= N ; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		long ans = inf;
		for (int i = 1 ; i<= N ; i++) {
			ans = Math.max(ans, arr[i]+func(i,i,1));
			//System.out.println(arr[i]+func(i,i,1));
			//System.out.println("-=----");
		}
		System.out.println(ans);
	}
	
	public static long func(int start,int end,int cnt) {
		//System.out.println(start+" "+end+" "+cnt);
		if ( cnt == M) {
			//System.out.println("hi");
			//System.out.println(start+" "+end+" "+cnt);
			return 0;
		}
		
		if ( end > N && cnt < M) {
			return inf;
		}
		
		long ret = dp[start][end][cnt];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		for (int i = end+2 ; i <= N ; i++) {
			
			for (int j = i ; j <= N ; j++) {
				
				ret = Math.max(ret,sum[j]-sum[i-1]+func(i,j,cnt+1));
				
			}
		}
			
		
		
		//System.out.println(ret);
		
		return dp[start][end][cnt] = ret;
		
	}
}
