package back6131;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int cnt = 0;
		for ( int i = 1 ; i<= 500 ; i++) {
			for ( int j = 1 ; j <= 500 ; j++) {
				if ( i*i  == j*j + N) {
					cnt++;
				}
			}
		}
		
		System.out.print(cnt);
	}
}
