package bacl11051;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		BigInteger boonmo = BigInteger.valueOf(1);
		BigInteger boonza = BigInteger.valueOf(M);
		for ( int i = N ; i >= N-M+1 ; i--) {
			boonmo = boonmo.multiply(BigInteger.valueOf(i));
			
		}
		for ( int i = M-1 ; i >= 2 ; i--) {
			boonza = boonza.multiply(BigInteger.valueOf(i));
		}
		if ( M == 0) {
			boonza = BigInteger.valueOf(1);
		}
		//System.out.println(boonmo+" "+boonza);
		System.out.println(boonmo.divide(boonza).mod(BigInteger.valueOf(10007)));
		
	}
}
