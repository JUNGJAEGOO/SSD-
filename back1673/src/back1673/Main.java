package back1673;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while( in.hasNext() ) {
			long n = in.nextLong();
			long k = in.nextLong();
			long coupon = 0;
			long chicken = 0;
			long couponnam = 0; 
			
			while ( true ) {
				
				chicken += n;
				coupon = (n + couponnam)/k;
				couponnam = (n + couponnam )%k;
				n = coupon;
				
				
				if ( n == 0) {
					break;
				}
				
			}
			
			System.out.println(chicken);
		}
	}
}
