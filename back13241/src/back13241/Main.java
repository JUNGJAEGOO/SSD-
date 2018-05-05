package back13241;

import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BigInteger A = in.nextBigInteger();
		BigInteger B = in.nextBigInteger();
		
		BigInteger gcd = A.gcd(B);
		
		BigInteger MokA = A.divide(gcd);
		BigInteger MokB = B.divide(gcd);
		
		System.out.println(MokA.multiply(MokB).multiply(gcd));
	}
}
