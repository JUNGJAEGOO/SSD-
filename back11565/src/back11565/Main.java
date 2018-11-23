package back11565;

import java.util.*;

public class Main {
	static String a,b;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		a = in.nextLine();
		b = in.nextLine();
		
		int cntOneA = 0;
		int cntOneB = 0;
		for ( int i = 0 ; i < a.length() ; i++) {
			if ( a.charAt(i) == '1' ) {
				cntOneA++;
			}
		}
		for ( int i = 0 ; i < b.length() ; i++) {
			if ( b.charAt(i) == '1' ) {
				cntOneB++;
			}
		}
		
		if ( cntOneA%2 == 1 && (cntOneA+1>=cntOneB) || (cntOneA%2) == 0 && cntOneA >= cntOneB) {
			System.out.print("VICTORY");
		}else {
			System.out.print("DEFEAT");
		}
		
	}
	
	public static class node{
		String str;
		int cnt;
		int one;
		node ( String str , int cnt, int one){
			this.str = str;
			this.cnt = cnt;
			this.one = one;
		}
	}
	
}
