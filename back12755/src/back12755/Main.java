package back12755;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int idx = 1;
		int cnt = 0;
		
		double a = System.currentTimeMillis();
		
		while ( true ) {
			
			String str = String.valueOf(idx);
			if ( str.length() + cnt < N) {
				cnt = cnt + str.length();
			}else {
				
				for ( int i = 0 ; i < str.length() ; i++) {
					cnt++;
					if ( cnt == N ) {
						System.out.print(str.charAt(i));
						return;
					}
					
				}
				
			}
			
			idx++;
		}
		
		// 49999998 은7 부터 시작 7 3 0 1 5 8 7 7 
		
		//double b =  System.currentTimeMillis();
		
	}
}
