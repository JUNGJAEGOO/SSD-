package back2661;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		func(0,"");
	}
	
	public static void func(int len,String now) {
		
		if ( len == N) {
			System.out.println(now);
			System.exit(0);
		}
		
		String tmp1 = now+"1";
		String tmp2 = now+"2";
		String tmp3 = now+"3";
		boolean pass1 = true;
		boolean pass2 = true;
		boolean pass3 = true;
		lop1:
		for (int j = 1 ; j <= tmp1.length()/2 ; j++) {
			//System.out.println("hi"+len);
			for (int i = 0 ; i < len ; i++) {
				if (i+j+j > len+1) {
					continue;
				}
				//System.out.println("false "+ tmp1.substring(i, i+j)+" vs "+tmp1.substring(i+j, i+j+j));
				if ( tmp1.substring(i, i+j).equals(tmp1.substring(i+j, i+j+j)) ) {
					pass1 = false;
					break lop1;
				}
			}
		}
		
		lop2:
		for (int j = 1 ; j <= tmp2.length()/2 ; j++) {
				for (int i = 0 ; i < len ; i++) {
					if (i+j+j > len+1) {
						continue;
					}
					//System.out.println("false "+ tmp2.substring(i, i+j)+" vs "+tmp2.substring(i+j, i+j+j));
					if ( tmp2.substring(i, i+j).equals(tmp2.substring(i+j, i+j+j)) ) {
						pass2 = false;
						break lop2;
				}
			}
		}
		
		lop3:
		for (int j = 1 ; j <= tmp3.length()/2 ; j++) {
				for (int i = 0 ; i < len ; i++) {
					if (i+j+j > len+1) {
						continue;
					}
					//System.out.println("false "+ tmp3.substring(i, i+j)+" vs "+tmp3.substring(i+j, i+j+j));
					if ( tmp3.substring(i, i+j).equals(tmp3.substring(i+j, i+j+j)) ) {
						pass3 = false;
						break lop3;
				}
			}
		}
		
		if ( pass1) {
		func(len+1,tmp1);
		}
		if ( pass2) {
		func(len+1,tmp2);
		}
		if ( pass3) {
		func(len+1,tmp3);
		}
		
	}
}
