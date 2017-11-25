package back1350;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int in[] = new int[N];
		StringTokenizer tmp = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < N ; i++) {
			in[i] = Integer.parseInt(tmp.nextToken());
			//in[i] = 999999999;
		}
		
		int danwi = Integer.parseInt(br.readLine());
		
		int mok;
		int nam;
		long result = 0;
		for ( int i = 0 ; i < N ; i++) {
			mok = in[i]/danwi;
			nam = in[i]%danwi;
			result += mok;
			if ( nam != 0) {
				result++;
			}
			
		}
		
		BigInteger a = BigInteger.valueOf(result);
		BigInteger b = BigInteger.valueOf(danwi);
		BigInteger res = a.multiply(b);
		System.out.println(res);
		
		
		}
}
