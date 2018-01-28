package back1793;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String ags[]) {
		Scanner in = new Scanner(System.in);
		
		BigInteger dp[] = new BigInteger[251];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.valueOf(3);
		
		for (int i = 3 ; i <= 250 ; i++) {
			dp[i] = dp[i-2].multiply(BigInteger.valueOf(2));
			dp[i] = dp[i].add(dp[i-1]);
		}
		
		while ( in.hasNext() ) {
			int N = in.nextInt();
			System.out.println(dp[N]);
		}
		
	}
}
