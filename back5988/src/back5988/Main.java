package back5988;

import java.util.Scanner;
import java.math.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while ( N > 0) {
			
			BigInteger A  = in.nextBigInteger();
			if ( A.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0 ) {
				System.out.println("even");
			}else {
				System.out.println("odd");
			}
			
			N--;
		}
	}
}
