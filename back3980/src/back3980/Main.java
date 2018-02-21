package back3980;

import java.util.*;

public class Main {
	static int mat[][];
	static int dp[];
	//static boolean visit[];
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0) {
			
			mat = new int[11][11];
			for (int i = 0 ; i < 11 ; i++) {
				for (int j = 0 ; j < 11 ; j++) {
					mat[i][j] = in.nextInt();
				}
			}
			
			dp = new int[11];
		
				for (int j = 0 ; j < 11 ; j++) {
					dp[j] = -1;
				}
		
		
			T--;
		}
	}

}
