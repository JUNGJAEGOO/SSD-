package back2749;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int dp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BigInteger N = in.nextBigInteger();
		dp = new int[1500001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
	
		int cnt = 4;
		while ( true ) {
			dp[cnt] = (dp[cnt-1]+dp[cnt-2])%1000000;
			/*if ( dp[cnt-2] == 1 && dp[cnt-1] == 1 && dp[cnt] == 2) {
				System.out.println(cnt);
				System.out.println(cnt-4+" "+dp[cnt-4]);
				System.out.println(cnt-3+" "+dp[cnt-3]);
				System.out.println(cnt-2+" "+dp[cnt-2]);
				System.out.println(cnt-1+" "+dp[cnt-1]);
				System.out.println(dp[cnt]);
				break;
			}*/
			cnt++;
			if ( cnt == 1500001) {
				break;
			}
		}
		
		if ( N.compareTo(BigInteger.valueOf(1500000)) >= 0) {
			//System.out.println("go");
			N = N.mod(BigInteger.valueOf(1500000));
		}
		
		System.out.println(dp[Integer.parseInt(String.valueOf(N))]);
		
	}
}
