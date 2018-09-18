package back1463;

import java.io.*;
import java.util.*;

public class Main {
	static int dp[];
	static int inf = 1000000000;
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		dp = new int[1000001];
		Arrays.fill(dp, -1);
		
		System.out.print(func(X));
		
	}
	
	public static int func(int x) {
		
		if ( x == 1) {
			return 0;
		}
		
		int ret = dp[x];
		if (ret != -1) {
			return ret;
		}
		ret = inf;
		
		if ( x%3==0) {

			ret = Math.min(ret, func(x/3)+1);
		
		}
		
		if ( x%2==0) {

			ret = Math.min(ret, func(x/2)+1);
		
		}
		
		ret = Math.min(ret, func(x-1)+1);
	
		return dp[x] = ret;
	}
}
