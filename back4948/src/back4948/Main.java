package back4948;

import java.util.Scanner;

public class Main {
	static boolean prime[];
	static int cnt;
	public static void main(String args[]) {
		prime = new boolean[123456*2+1];
		eratos();
		Scanner in = new Scanner(System.in);
		while ( true ) {
			int N = in.nextInt();
			if ( N == 0) {
				return;
			}
			cnt = 0;
			for ( int i = N+1 ; i <= 2*N ; i++) {
				if ( prime[i] == false) {
					//System.out.print(i+" ");
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void eratos(){
		
		prime[1] = true;
		for ( int i = 2 ; i <= 123456*2 ; i++) {
			if ( prime[i] == false) {
				for ( int j = i+i ; j <= 123456*2 ; j= j+i) {
					if ( j > 123456*2) {
						break;
					}
					prime[j] = true;
				}
			}
		}
		
	}
}
