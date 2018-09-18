
import java.util.*;

public class source1 {
	static long N;
	static long K;
	static long dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		
		dp = new long[201][201];
		
		for ( int i = 0 ; i < 201 ; i++) {
			for (int j = 0 ; j < 201 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(0,0));
		
		
	}
	
	public static long func(int sum,int len) {
		
		if ( sum > N ) {
			return 0;
		}
		
		if ( len > K) {
			return 0;
		}
		
		if ( sum == N) {
			return 1;
		}
		
		long ret = dp[sum][len];
		
		if ( ret != -1) {
			return ret;
		}
		
		ret = 0;
		
		for ( int i = 0 ; i <= N ; i++) {
			ret += func(sum+i,len+1);
		}
		
		return dp[sum][len] = ret % 1000000000;
		
	}
}
