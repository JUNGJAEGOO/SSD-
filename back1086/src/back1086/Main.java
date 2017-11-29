package back1086;

import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger arr[] = new BigInteger[N];
		
		BigInteger x = BigInteger.valueOf(1);
		for ( int i = 1 ; i <= N ; i++) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = new BigInteger(br.readLine());
		}
		
		String tmp = br.readLine();
		BigInteger K = new BigInteger(tmp);
		int result = 0;
		BigInteger zero = new BigInteger("0");
		for ( int i = 0 ; i < N ; i++) {
			//System.out.println(arr[i]+"%"+K+" "+arr[i].remainder(K));
			BigInteger nam = arr[i].remainder(K);
			//System.out.println(nam.compareTo(zero));
			if ( nam.compareTo(zero) == 0 ) {
				result++;
			}
		}
		
		long boonza = 1;
		
		for ( int i = 1 ; i <= N-1 ; i++) {
			boonza *= i;
		}
		boonza *= result;
		
		//System.out.println(boonza+"/"+x);
		BigInteger y = BigInteger.valueOf(boonza).gcd(x);
		BigInteger realp = BigInteger.valueOf(boonza).divide(y);
		BigInteger realq = x.divide(y);
		System.out.println(realp+"/"+realq);
		
	}



	

}	
