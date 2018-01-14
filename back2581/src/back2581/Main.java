package back2581;

import java.util.Scanner;

public class Main {
	static boolean prime[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int start = in.nextInt();
		int end = in.nextInt();
		long sum = 0;
		prime = new boolean[10001];
		eratos();
		int min = 10001;
		for ( int i = start ; i <= end ; i++) {
			if ( prime[i] == false) {
				sum += i;
				if ( i < min) {
					min = i;
				}
			}
		}
		
		if ( sum == 0 ) {
			System.out.print(-1);
		}else {
			System.out.print(sum+"\n"+min);
		}
	}
	public static void eratos() {
		prime[1] = true;
		for ( int i = 2; i <= 10000 ; i++) {
			if ( prime[i] == true ) {
				continue;
			}else {
				prime[i] = false;
				for ( int j = i+i ; j <= 10000 ; j = j + i) {
					if ( j > 10000) {
						break;
					}else {
						prime[j] = true;
					}
				}
			}
		}
	}
}
