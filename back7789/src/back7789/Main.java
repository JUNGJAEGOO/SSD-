package back7789;

import java.util.Scanner;

public class Main {
	static boolean isPrime[];
	
	public static void main(String args[]) {
		isPrime = new boolean[10000001];
		eratos();
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int NEW = Integer.parseInt(String.valueOf(M) + String.valueOf(N));
		//System.out.println(NEW);
		//System.out.println(isPrime[N]);
		if ( isPrime[N] == false && isPrime[NEW] == false) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
	}
	
	public static void eratos() {
		isPrime[1] = true;
		isPrime[0] = true;
		for ( int i = 2 ; i<= 10000000 ; i++) {
			if ( isPrime[i] == false) {
				for ( int j = i + i ; j <= 10000000 ; j = j + i) {
					if ( j > 10000000 ) {
						break;
					}
					isPrime[j] = true;
				}
			}
		}
	}
}
