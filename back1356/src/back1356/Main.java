package back1356;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		
		char tmp[] = input.toCharArray();

		int div = 1;
		
		while ( div < tmp.length ) {
			char left[] = new char[div];
			char right[] = new char[tmp.length];

			BigInteger a = new BigInteger("1");
			BigInteger b = new BigInteger("1");
			
			for ( int i = 0 ; i < div ; i++) {
				left[i] = tmp[i] ;
				//System.out.print(left[i]+" ");
				long tmp2 = Long.parseLong(String.valueOf(left[i]));
				a = a.multiply(BigInteger.valueOf(tmp2));
			}//System.out.println();
			for ( int i = div ; i < tmp.length ; i++) {
				
				right[i] = tmp[i];
				//System.out.print(right[i]+" ");
				long tmp3 = Long.parseLong(String.valueOf(right[i]));
				b = b.multiply(BigInteger.valueOf(tmp3));
			}//System.out.println();

			
			if ( a.compareTo(b) == 0) {
				System.out.println("YES");
				return;
			}
			div++;
		}
		
		System.out.println("NO");
	}
}
