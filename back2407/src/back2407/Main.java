package back2407;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		
		for ( int i = N-M+1 ; i <= N ; i++) {
			up = up.multiply(BigInteger.valueOf(i));
		}
		
		for ( int i = 2 ; i <= M ; i++) {
			down = down.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(up.divide(down));
	}
}
