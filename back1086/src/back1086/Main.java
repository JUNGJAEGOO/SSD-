package back1086;

import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static String arr[];
	static int dp[][];
	static int N;
	static int K;
	static int Klength;
	
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		arr = new String[N+1];
		dp = new int[N+1][(2<<N)+1];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLine();
		}
		for ( int i = 0 ; i <= N ; i++) {
			for ( int j = 0 ; j <= (2<<N) ; j++) {
				dp[i][j] = -1;
			}
		}
		//System.out.println(1<<2);
		K = Integer.parseInt(in.nextLine());
		if ( K < 10) {
			Klength = 1;
		}else if ( K < 100) {
			Klength = 2;
		}else if ( K == 100) {
			Klength = 3;
		}
		
		double a = System.currentTimeMillis();
		System.out.println(func("",0,0));
		double b = System.currentTimeMillis();
		System.out.println(b-a);
		
	}

	public static int func(String hi,int num,int state) {
		/*if( num >= 3 ) {
			if ( Integer.parseInt(hi.substring(hi.length()-2,hi.length()))%K != 0 ) {
				return 0;
			}
		}*/
		if ( num == N ) {
			if ( (new BigInteger(hi)).mod(BigInteger.valueOf(K)).compareTo(BigInteger.valueOf(0)) != 0 ) {
				return 0;
			}
			//System.out.println(hi);
			return 1;
		}
		
		
		int ret = dp[num][state];
		if ( ret != -1 ) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			if ( state == 0) {
				//System.out.println((state)|(1<<(i+1)));
				ret += func(String.valueOf(arr[i])+hi,num+1,(state)|1<<((i+1)));
			}
			else if ( (state&(1<<(i+1))) == 0) {
				//System.out.println(ret);
				ret += func(String.valueOf(arr[i])+hi,num+1,(state)|(1<<(i+1)));
			}
		}
		
		return ret;
		
	}


	

}	
