package back4781;

import java.util.Scanner;

public class Main {
	static int dp[];
	static node arr[];
	static int N,M;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
		
			N = (int)in.nextFloat();
			M = (int)(in.nextFloat()*100+0.5);
			//System.out.print(M);
			if ( N == 0 && M == 0) {
				return;
			}
			dp = new int[10001];
			
			for(int j = 0 ; j <= 10000 ; j++) {
				dp[j] = -1;
			}
			
			arr = new node[N];
			for (int i = 0 ; i < N ; i++) {
				arr[i] = new node();
				arr[i].kcal = (int)in.nextFloat();
				arr[i].cost = (int)(in.nextFloat()*100+0.5);
			}
			
			//System.out.println(dp[700]);
			
			//System.out.println(func(0));
			System.out.println(func(M));
			
		}
	}
	
	public static int func(int m) {
		
		//System.out.println(m);
		
		int ret = dp[m];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for (int i = 0 ; i < N ; i++) {
			
			//System.out.println(m-arr[i].cost);
			
			if ( m - arr[i].cost >= 0) {
				
				ret = Math.max(ret,arr[i].kcal+func(m-arr[i].cost));
			}
		}
		
		
		//System.out.println(ret);
		
		return dp[m] = ret;
	}
	
	public static class node{
		int kcal;
		int cost;
	}
}
