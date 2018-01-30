package back6591;

import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while ( true ) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			if ( A== 0 && B==0) {
				break;
			}
			if ( B> A-B) {
				B = A-B;
			}
			
			
			BigInteger sum = BigInteger.ONE;
			for (long i = 1 ; i <= B ; i++) {
				BigInteger tmp = BigInteger.valueOf(A-B+i);
				sum = sum.multiply(tmp);
				sum = sum.divide(BigInteger.valueOf(i));
			}
			sb.append(sum+"\n");
			//System.out.println(sum.divide(sum2));
		}
		System.out.print(sb);
	}
}
