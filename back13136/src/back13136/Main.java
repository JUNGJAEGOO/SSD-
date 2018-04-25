package back13136;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		long C = in.nextLong();
		
		if ( A % C == 0) {
			A = A / C;
		}else {
			A =  ( A / C ) + 1;
		}
		
		if ( B % C == 0) {
			B = B / C;
		}else {
			B =  ( B / C ) + 1;
		}
		System.out.print(A*B);
	}
}
