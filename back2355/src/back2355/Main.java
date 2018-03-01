package back2355;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BigInteger i = in.nextBigInteger();
		BigInteger j = in.nextBigInteger();
		if ( i.compareTo(j) > 0) {
			BigInteger tmp = i;
			i = j;
			j = tmp;
		}
		
		BigInteger sum2 = ((j.add(BigInteger.ONE)).multiply(j) ).divide(BigInteger.valueOf(2)); 
		BigInteger sum1 = ((i.subtract(BigInteger.ONE)).multiply(i) ).divide(BigInteger.valueOf(2)); 
		System.out.println(sum2.subtract(sum1));
	}
}
