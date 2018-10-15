package back2616;
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int dp[][];
	static int arr[];
	static int consec;
	static int sum[];
	
	public static void main(String args[]) throws Exception{
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		consec = Integer.parseInt(br.readLine());
		
		int tmp = 0;
		for ( int i = 0 ; i < consec ; i++) {
			tmp += arr[i];
		}
		
		sum = new int[N-consec+1];
		sum[0] = tmp;
		
		for ( int i = 1 ; i <= N - consec ; i++) {
			sum[i] = sum[i-1] - arr[i-1] + arr[i+consec-1];
		}
		
		dp = new int[N+1][4];
		for ( int i = 0 ; i < N+1 ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(0,0));
	}
	
	public static int func(int pos,int con) {
		
		if ( pos >= N-consec+1 ) {
			return 0;
		}
		
		int ret = dp[pos][con];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		if ( pos+1 < N) {
			ret = Math.max(ret, func(pos+1,con));
		}
		
		if ( con < 3 ) {
			ret = Math.max(ret, sum[pos] + func(pos+consec,con+1));
		}
		
		return dp[pos][con] = ret;
	}
}
