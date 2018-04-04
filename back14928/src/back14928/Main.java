package back14928;

import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BigInteger A = in.nextBigInteger();
		System.out.print(A.mod(BigInteger.valueOf(20000303)) );
	}
}
