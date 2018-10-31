package back14395;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int s,t;
	static int dp[][];
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		dp = new int[(int)1e8][4];
		for ( int i = 0 ; i < dp.length ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(s,0));
		
	}
	
	public static int func(int num,int opr) {
		
		System.out.println(num);
		
		if ( num == t) {
			return 0;
		}
		
		int ret = dp[num][opr];
		if ( ret != -1) {
			return ret;
		}
		ret = INF;
		
		if ( (long)num + (long)num <= t) {
			ret = Math.min(ret, 1 + func(num+num,0));
		}
		ret = Math.min(ret, 1 + func(0,1));
		if ( (long)num * (long)num <= t) {
			ret = Math.min(ret, 1 + func(num*num,2));
		}
		if ( num != 0 ) {
			ret = Math.min(ret, 1 + func(1,3));
		}
		
		return dp[num][opr] = ret;
		
	}
}
