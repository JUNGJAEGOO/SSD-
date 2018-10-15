package back14731;

import java.util.*;
import java.io.*;

public class Main {
    static final int mod = (int)1e9 + 7;
    static HashMap<Integer,Long> hm = new HashMap<>();
	public static void main(String args[]) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
	
		for (int i = 0 ; i < N ; i++) {
			
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            sum +=  ( ( (a%mod) * (b%mod) ) % mod ) * (fast_power(2,b-1) % mod)  % mod;
            sum %= mod;
		}
		
		sum %= mod;
		System.out.println(sum);
		
	}
	
	public static long fast_power(long base,long power) {
		
		long res = 1;
		
		while ( power > 0 ) {
			
			if ( power % 2 == 1) {
				res = (res * base )%mod;
			}
			
			base = (base%mod * base%mod) % mod;
			power /= 2;
		}
		
		
		return res;
		
	}
    
}
