package back1629;

import java.util.*;

public class Main {
	static long mod;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		mod = in.nextLong();
		
		System.out.println(power(A%mod,B));
		
	}
	
	public static long power(long x,long y) {
		
		long ret = 1;
		
		while ( y > 0) {
			if ( y % 2 == 1) {
				ret *= x;
				ret %= mod;
			}
			x *= x;
			x %= mod;
			y /= 2;
		}
		return ret;
	}
}
