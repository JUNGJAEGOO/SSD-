package back11443;

import java.math.*;
import java.util.*;

public class Main {
	public static void main( String args[] ){
		
		Scanner in = new Scanner(System.in);
		BigInteger N = in.nextBigInteger();
		
		long dp[] = new long[1000001];
		dp[1] = 1;
		dp[2] = 1;
		
		for ( int i = 3 ; i <= 1000000 ; i ++) {
			dp[i] = (dp[i-1] + dp[i-2])%1000000007;
		}
		
		long real[] = new long[1000001];
		real[0] = 0;
		real[1] = 0;
		for (int i = 2 ; i <= 1000000 ; i++) {
			if ( i % 2 == 1) {
				real[i] = real[i-1];
			}else {
				real[i] = (real[i-2] + dp[i]) % 1000000007 ;
			}
		}
		
		for ( int i = 3 ; i <= 1000000 ; i++) {
			
			if ( real[i] == 1) {
				System.out.println(i);
			}
			//System.out.println(real[i]);
			
		}
		
	}
}
