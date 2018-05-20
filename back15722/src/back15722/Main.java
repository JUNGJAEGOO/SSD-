package back15722;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int x = 0;
		int y = 0;
		int cnt = 1;
		
		int second = 0;
		int flag = 1;
		
		
		if ( N == 0) {
			System.out.print(0+" "+0);
			return;
		}
		
		
		lop:
		while ( true ) {
			
			for ( int i = 0 ; i < cnt ; i++) {
				y = y + flag*1;
				second++;
				if ( second == N) {
					break lop;
				}
			}
			
			for ( int i = 0 ; i < cnt ; i++) {
				x = x + flag*1;
				second++;
				if ( second == N) {
					break lop;
				}
			}
			
			flag *= -1;
			cnt++;
			
		}
		
		System.out.print(x+" "+y);
	}
}
