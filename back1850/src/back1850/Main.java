package back1850;

import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		String a = new String();
		String b = new String();
		for (int i = 0 ; i < A ; i++) {
			a += "1";
		}
		for (int i = 0 ; i < B ; i++) {
			b += "1";
		}
		BigInteger x = new BigInteger(a);
		BigInteger y = new BigInteger(b);
		BigInteger res = x.gcd(y);
		System.out.print(res);
		
	}
}
