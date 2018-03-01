package back1786;

import java.util.*;

public class Main {
	static ArrayList<Integer> same = new ArrayList<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String pattern = in.nextLine();
		
		int fail[] = make(pattern);
		KMP(pattern,input,fail);
		
		for (int i = 0 ; i < same.size() ; i++) {
			System.out.print(same.get(i)+" ");
		}
		
	}
	
	public static int[] make(String pattern) {
		int fail[] = new int[pattern.length()];
		char[] p = pattern.toCharArray();
		int j = 0;
		for (int i = 1 ; i < pattern.length() ; i++) {
			while ( j > 0 && p[i] != p[j]) {
				j = fail[j-1];
			}
			if ( p[i] == p[j]) {
				fail[i] = ++j;
			}
		}
		
		return fail;
	}
	
	public static void KMP(String pattern,String origin,int[] fail) {
		char[] ori = origin.toCharArray();
		char[] p = pattern.toCharArray();
		int j = 0;
		int ans = 0;
		for (int i = 0 ; i < ori.length ; i++) {
			while ( j > 0 && ori[i] != p[j]) {
				j = fail[j-1];
			}
			if ( ori[i] == p[j]) {
				if ( j == p.length - 1 ) {
					same.add(i-j+1);
					j = fail[j];
					ans++;
				}else {
					j++;
				}
			}else {
				j = 0;
			}
		}
		System.out.println(ans);
	}
}
