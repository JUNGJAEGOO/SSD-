package back1676;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int cnt = 0;
		BigInteger sum = BigInteger.ONE;

		if ( N == 0) {
			System.out.print(cnt);
			return;
		}
		
		for ( int i = 2 ; i<= N ; i++) {
			sum = sum.multiply(BigInteger.valueOf(i));
			//System.out.println(sum);
		}
		
		while ( true) {
			if ( sum.mod(BigInteger.valueOf(5)).compareTo(BigInteger.ZERO) == 0 ) {
				cnt++;
				sum = sum.divide(BigInteger.valueOf(5));
			}else {
				break;
			}
		}
		
		System.out.print(cnt);
	}
}
