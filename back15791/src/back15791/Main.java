package back15791;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		long boonmo = 1;
		long boonza = 1;
		
		for (int i = 2 ; i <= M ; i++) {
			boonmo =  ( boonmo * i ) % 1000000007;
		}
		
		for ( int i = N ; i >= N-M+1 ; i--) {
			boonza = ( boonza * i ) % 1000000007;
		}
		
		System.out.println(boonza/boonmo);
	}
}
