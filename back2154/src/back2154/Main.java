package back2154;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		String origin= "";
		double a = System.currentTimeMillis();
		for (int i = 1 ; i<= 100000 ; i++) {
			sb.append(String.valueOf(i));
		}
		double b = System.currentTimeMillis();
		//System.out.println(b-a);
		origin = sb.toString();
				
		String pattern = String.valueOf(N);
		
		int fail[] = make(pattern);
		int idx = KMP(fail,origin,pattern);
		System.out.println(idx);
		
		
	}
	
	public static int KMP(int fail[],String origin,String pattern) {
		char[] c = pattern.toCharArray();
		char[] ori = origin.toCharArray();
		int j = 0;
		int ans = 0;
		
		lop:
		for (int i = 0 ; i < ori.length ; i++ ) {
			System.out.println(i+" "+j);
			while ( j > 0 && ori[i] != c[j]) {
				j = fail[j-1];
			}
			if ( ori[i] == c[j]) {
				if ( j == c.length-1) {
					ans = i-j;
					j = fail[j];
					
					break lop;
				}else {
					j++;
				}
			}else {
				j = 0;
			}
			
			
		}
		
		return ans;
	
	}
	
	public static int[] make(String pattern) {
		int[] fail = new int[pattern.length()];
		char[] c = pattern.toCharArray();
		int j = 0;
		for (int i = 1 ; i < c.length ; i++) {
			while ( j > 0 && c[i] != c[j]) {
				j = fail[j-1];
			}
			if ( c[i] == c[j]) {
				fail[i] = ++j;
			}
		}
		
		
		
		return fail;
	}
}
