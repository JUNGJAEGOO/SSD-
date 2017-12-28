package back14614;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		BigInteger c = new BigInteger(st.nextToken());
		BigInteger two = BigInteger.valueOf(2);
		BigInteger zero = BigInteger.valueOf(0);
		long ans;
		//System.out.println(c+" "+two+" "+zero);
		if ( c.mod(two) == zero ) {
			System.out.println("it's zero");
			ans = (a^b)^b;
		}else {
			ans = a^b;
		}
		
		System.out.println(ans);
	}
}
