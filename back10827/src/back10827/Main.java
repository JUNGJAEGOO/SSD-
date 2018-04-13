package back10827;

import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		double A = in.nextDouble();
		int B = in.nextInt();
		int cnt = 1;
		double other = Math.pow(A, B);
		int len = String.valueOf(A).length()-String.valueOf(A).indexOf(".");
		int reallen = String.valueOf(other).indexOf(".");
		
		long tmp = (long)  (A * (Math.pow(10, len-1)) );
		//System.out.println(tmp);
		BigInteger a = BigInteger.valueOf(tmp);
		//System.out.println(a);
		a = a.pow(B);
		//System.out.println(a);
		
		char[] tmptmp = String.valueOf(a).toCharArray();
		ArrayList<Character> ans = new ArrayList<>();
		for ( int i = 0 ; i < tmptmp.length ; i++) {
			ans.add(tmptmp[i]);
		}
		
		System.out.println(reallen);
		ans.add(reallen, '.');
		for ( int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i));
		}
	}
}
