package back2530;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		int D = in.nextInt();
		
		int s = D%60;
		int m = D/60;
		int h = 0;
		if ( m >= 60) {
			h = m/60;
			m = m%60;
		}
		
		C += s;
		B += m;
		A += h;
		
		if ( C >= 60) {
			B = B + C/60;
			C %= 60;
		}
		if ( B >= 60) {
			A = A  + B/60;
			B %= 60;
		}
		if ( A >= 24) {
			A %= 24;
		}
		System.out.print(A+" "+B+" "+C);
	}
}
