package back3165;

import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		BigInteger N = in.nextBigInteger();
		int K = in.nextInt();
		
		//System.out.print(N+" "+K);
		
		String str =  "";
		
		for ( int i = 0 ; i < K ; i++) {
			str += "5";
		}
		
		if ( N.toString().length() >= K) {
			int diff = N.toString().length() - K;
			
			String STR = "";
			for ( int j = 0 ; j < diff  ; j ++) {
				
				STR+= N.toString().charAt(j);
				
			}
			
			//System.out.println(STR);
			
			BigInteger tmp;
			
			if( STR.length() == 0) {
				tmp = new BigInteger("0");
			}else {
				tmp = new BigInteger(STR);
			}
			
			
			while ( true ) {
				
				String tmptmp = "";
				
				for ( int j = 0 ; j < K ; j++) {
					tmptmp += "5";
				}
				
				BigInteger now = new BigInteger(tmp+tmptmp);
				
				
				if ( now.compareTo(N) >= 0) {

					System.out.println(now);
					break;
				}
				
				tmp = tmp.add(BigInteger.ONE);
				
			}
			
			
		}else {
			System.out.print(str);
		}
	}
}
