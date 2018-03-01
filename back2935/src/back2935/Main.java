package back2935;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BigInteger a = new BigInteger(in.nextLine());
		String operator = in.nextLine();
		BigInteger b = new BigInteger(in.nextLine());
		if ( operator.equals("+")) {
			System.out.println(a.add(b));
		}else if ( operator.equals("*")) {
			System.out.println(a.multiply(b));
		}
	}
}
