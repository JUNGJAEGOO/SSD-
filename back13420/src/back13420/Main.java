package back13420;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			String ins[] = in.nextLine().split(" ");
			String A = ins[0];
			String B = ins[2];
			String operator = ins[1];
			String suspect = ins[4];
			
			long a = Long.parseLong(A);
			long b = Long.parseLong(B);
			long ans = 0 ;
			if ( operator.equals("*") ) {
				ans = a * b;
			}else if (  operator.equals("-") ) {
				ans = a - b;
			}else if (  operator.equals("+") ) {
				ans = a + b;
			}else {
				ans = a / b;
			}
			
			if ( ans == Long.parseLong(suspect) ) {
				System.out.println("correct");
			}else {
				System.out.println("wrong answer");
			}
			
			T--;
		}
	}
}
