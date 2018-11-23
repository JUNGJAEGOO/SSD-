package back16400;

import java.util.*;

public class Main {
	
	static boolean isP[];
	static int N;
	static ArrayList<Integer> prime = new ArrayList<>();
	static int dp[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		isP = new boolean[N+1];
		eratos();
			
		dp = new int[40001];
		dp[0] = 1;
		for ( int i = 0 ; i < prime.size() ; i++) {
			
			for ( int j = prime.get(i) ; j <= 40000 ; j++) {
				dp[j] = ( dp[j] + dp[j-prime.get(i)] ) % 123456789;
			}
			
		}
		
		System.out.print(dp[N]);
	}
	

	
	public static void eratos() {
		isP[0] = true;
		isP[1] = true;
		
		for ( int i = 2 ; i <= N ; i++) {
			if ( isP[i] == false ) {
				prime.add(i);
				for ( int j = i+i ; j <= N ; j = j + i) {
					if ( j > N ) {
						break;
					}
					isP[j] = true;
				}
			}
		}
	}
}
