package back1934;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T> 0) {
			
			BigInteger A = in.nextBigInteger();
			BigInteger B = in.nextBigInteger();
			
			BigInteger gcd = A.gcd(B);
			
			
			A = A.divide(gcd);
			B = B.divide(gcd);
			
			System.out.println(A.multiply(B).multiply(gcd));
			
			T--;
		}
	}
}
