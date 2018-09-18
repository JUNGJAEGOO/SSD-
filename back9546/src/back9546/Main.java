package back9546;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		int dp[] = new int[31];
		dp[1] = 1;
		int diff = 2;
		for ( int i = 2 ; i < 31 ; i++) {
			dp[i] = dp[i-1] + diff;
			diff *= 2;
		}
		
		while (T > 0 ) {
			
			int x = in.nextInt();
			
			System.out.println(dp[x]);
			
			T--;
		}
	}
}
