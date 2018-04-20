package back1834;

import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		
		BigInteger sum = BigInteger.ZERO;
		for ( int i = 1 ; i<= N-1 ; i++) {
			if ( i >= N) {
				break;
			}
			//System.out.println(sum);
			sum =  sum.add(BigInteger.valueOf(N).multiply(BigInteger.valueOf(i)).add(BigInteger.valueOf(i)) );
		}
		System.out.print(sum);
	}
}
