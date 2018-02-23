package back9693;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = 1;
		while ( true ) {
			
			int n = in.nextInt();
			if ( n == 0 ) {
				break;
			}
			int five = 0;
			int two = 0;
			for ( int i = 2 ; i <= n ; i++) {
				int tmp = i;
				while ( true) {
					//System.out.println(tmp);
					if ( tmp % 2 == 0) {
						tmp /= 2;
						two++;
					}
					if ( tmp % 5 == 0) {
						tmp /= 5;
						five++;
					}
					if ( tmp == 0 || (tmp % 5 != 0 && tmp % 2 != 0) ) {
						break;
					}
				}
			}
			
			//System.out.println(two+" "+five);
			
			System.out.println("Case #"+t+": "+Math.min(two, five));
			t++;
		}
	}
}
