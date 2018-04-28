package back5555;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String want = in.nextLine();
		
		int N = Integer.parseInt(in.nextLine());
		
		String arr[] = new String[N];
		
		int cnt = 0;
		for ( int i = 0 ; i < N ; i++) {
			String str = in.nextLine();
			
			arr[i] = str + str;
			
			int fail[] = make(want);
			int x = KMP(fail,want,arr[i]);
			
			if ( x != -1) {
				cnt++;
			}
		}
		System.out.print(cnt);
		
	}
	
	public static int KMP(int fail[],String pattern,String origin) {
		//System.out.println(pattern+" "+origin);
		
		char p[] = pattern.toCharArray();
		char ori[] = origin.toCharArray();
		int find = -1;
		int j = 0 ;
		for ( int i = 0 ; i < ori.length ; i++) {
			//System.out.println(i+" "+j);
			while ( j>0 && ori[i] != p[j]) {
				j = fail[j-1];
			}
			
			if ( ori[i] == p[j]) {
				if ( j == p.length -1) {
					//System.out.println("hi");
					find = i;
					j = fail[j];
					
				}else {
					j++;
				}
		
			}else {
				j = 0;
			}
			
		}
		
		return find;
	}
	
	public static int[] make(String pattern) {
		
		int j = 0;
		char c[] = pattern.toCharArray();
		int fail[] = new int[c.length];
		
		for ( int i = 1 ; i < c.length ; i++) {
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
