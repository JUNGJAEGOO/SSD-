package back10476;

import java.util.*;

public class Main {
	static int N,K;
	static int left[];
	static int right[];
	static int dp[][][];
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
	
		left = new int[N];
		right = new int[N];
		int sum = 0;
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			left[i] = x;
			right[i] = y;
			sum += x;
			sum += y;
		}
		
		int zero = in.nextInt();
		zero = in.nextInt();
		
		dp = new int[3][201][201];
		for (int i = 0 ; i < 3 ; i++) {
			for ( int j = 0 ; j < 201 ; j++) {
				for ( int k = 0 ; k < 201 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		//System.out.println(sum);
		System.out.println(sum-func(0,0,K,0));
	}
	
	public static int func(int flag,int len,int k,int sum) {
		
		//System.out.println(flag+" "+len+" "+k+" sum: "+sum);
		
		if ( len == N && k == 0) {
			return 0;
		}
		if ( len == N && k > 0) {
			//System.out.println("hi");
			return inf;
		}
		
		int ret = dp[flag][len][k];
		if (ret != -1) {
			return ret;
		}
		
		ret = inf;
		// 0 은 아무것도 안함 1은 왼쪽 2는 오른쪽
		if ( flag == 0) {
			ret = Math.min(ret, func(0,len+1,k,sum));
			if ( k > 0) {
				ret = Math.min(ret, left[len]+func(1,len+1,k-1,sum+left[len]));
				ret = Math.min(ret, right[len]+func(2,len+1,k-1,sum+right[len]));
			}
		}else if ( flag == 1) {
			ret = Math.min(ret, func(0,len+1,k,sum));
			if ( k > 0) {
				ret = Math.min(ret, left[len]+func(1,len+1,k-1,sum+left[len]));
			}
		}else if ( flag == 2) {
			ret = Math.min(ret, func(0,len+1,k,sum));
			if ( k > 0 ) {
				ret = Math.min(ret, right[len]+func(2,len+1,k-1,sum+right[len]));
			}
		}
		
		
		return  dp[flag][len][k] = ret;
	}
}
