package back14501;

import java.io.*;
import java.util.*;

public class Main2 {
	static int N;
	static int t[];
	static int p[];
	static int dp[];
	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[1500001];
		for ( int i = 0 ; i < 1500001 ; i++ ) {
			dp[i] = -1;
		}
		
		t = new int[N+1];
		p = new int[N+1];
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = func(0);
		System.out.print(ans);
	}
	
	public static int func(int len) {
		
		if ( len >= N ) {
			return 0;
		}
		
		int ret = dp[len];
		if ( ret != -1) {
			return ret;
		}

		ret = func(len+1);
		if ( len+t[len] <= N) {
		ret = Math.max(ret, p[len]+func(len+t[len]));
		}
		return dp[len] = ret;
	}
}
