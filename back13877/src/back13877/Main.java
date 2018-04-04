package back13877;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String ans[][] = new String[T][3];
		while ( T > 0) {
			
			int n = in.nextInt();
			int number = in.nextInt();
			
			BigInteger octo = BigInteger.ZERO;
			String tmp[] = String.valueOf(number).split("");
			int eight = 1;
			for ( int i = tmp.length-1 ; i >= 0 ; i--) {
				if ( Integer.parseInt(tmp[i]) >= 8) {
					octo = BigInteger.ZERO;
					break;
				}
				octo = octo.add( BigInteger.valueOf(Integer.parseInt(tmp[i]) * eight) );
				eight *= 8;
			}
			
			BigInteger hexa = BigInteger.ZERO;
			String tmp2[] = String.valueOf(number).split("");
			int hex = 1;
			for ( int i = tmp2.length-1 ; i >= 0 ; i--) {
				hexa = hexa.add( BigInteger.valueOf(Integer.parseInt(tmp2[i]) * hex) );
				hex *= 16;
			}
			
			ans[n-1][0] = String.valueOf(octo);
			ans[n-1][1] = String.valueOf(number);
			ans[n-1][2] = String.valueOf(hexa);
			
			T--;
		}
		
		for ( int i = 0 ; i < ans.length ; i++) {
			System.out.println((i+1)+" "+ans[i][0]+" "+ans[i][1]+" "+ans[i][2]);
		}
	}
}
