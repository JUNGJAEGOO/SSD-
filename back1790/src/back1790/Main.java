package back1790;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		long sum = 0;
		char ans = ' ';
		lop:
		for ( int i = 1 ; i<= N ; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			if ( sum+len >= K) {
				char[] c = str.toCharArray();
				int idx = -1;
				while ( true ) {
					sum++;
					idx++;
					if ( sum == K) {
						ans = c[idx];
						break lop;
					}
				}
			}else {
				sum += len;
			}
		}
		if ( ans == ' ') {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
}
