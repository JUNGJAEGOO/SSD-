package back2875;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		
		int max = 0;
		
		for ( int i = 0 ; i <= K ; i++) {
			
			int new_N = N-(K-i);
			int new_M = M-i;
			
			if ( new_N <= 0 || new_M <= 0) {
				continue;
			}
			
			int girl = new_N;
			int boy = new_M;
			//System.out.println(girl+" "+boy);
			int now = 0;
			while ( true ) {
				
				girl -= 2;
				boy -= 1;
				
				if ( boy < 0 || girl < 0) {
					break;
				}

				now++;
			}
			
			max = Math.max(max, now);
			
		}
		
		System.out.print(max);
	}
}
