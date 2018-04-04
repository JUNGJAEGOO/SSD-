package back14698;

import java.util.*;

public class Main {
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			int n = in.nextInt();
			
			PriorityQueue<Long> list = new PriorityQueue<>();
			for ( int i = 0 ; i < n ; i++) {
				list.add(in.nextLong());
			}

			long sum  = 1;
			while ( true ) {
				if ( list.size() == 1) {
					break;
				}
				
				long a = list.poll();
				long b = list.poll();
				
				//System.out.println(a);
				sum *=  ( (a%1000000007) * (b%1000000007) ) % 1000000007;
				list.add( a*b );
				sum %= 1000000007;
				
			}

			System.out.println(sum);
			T--;
		}
	}
}
