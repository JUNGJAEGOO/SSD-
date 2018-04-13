package back1837;

import java.math.*;
import java.util.*;

public class Main {
	public static boolean isPrime[];
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		BigInteger A = in.nextBigInteger();
		
		//System.out.println(BigInteger.valueOf(9).pow(100));
		
		int K = in.nextInt();
		isPrime = new boolean[2000001];
		isPrime[0] = true;
		isPrime[1] = true;
		ArrayList<Integer> prime = new ArrayList<>();
		for ( int i = 2 ; i< 2000001 ; i++ ) {
			
			if ( isPrime[i] == false) {
				prime.add(i);
				for ( int j = i + i ; j < 2000001 ; j = j + i) {
					if ( j > 2000001) {
						break;
					}else {
						isPrime[j] = true;
					}
				}
			}
		}
		
		//System.out.println(prime.size());
		
		int p = -1;
		for ( int i = 0 ; i < prime.size() ; i++) {
			//System.out.println(A+" % "+prime.get(i)+" "+A.mod(BigInteger.valueOf(prime.get(i))));
			
			if ( BigInteger.valueOf(prime.get(i)).compareTo(A) > 0 ) {
				break;
			}
			if ( A.mod(BigInteger.valueOf(prime.get(i))).compareTo(BigInteger.ZERO) == 0 ) {

				if ( p == -1) {
					p = prime.get(i);
				}else {
					p = Math.min(p,prime.get(i) );
				}
				
			}
		}
		
		//System.out.println(p);
		
		if ( p < K) {
			System.out.println("BAD "+p);
		}else {
			System.out.println("GOOD");
		}
		
	}
}
