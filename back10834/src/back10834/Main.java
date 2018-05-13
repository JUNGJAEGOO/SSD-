package back10834;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new  Scanner(System.in);
		int M = in.nextInt();
		
		long sum = 0;
		
		long a = in.nextLong();
		long b = in.nextLong();
		sum = a * b;
		int dir = 0;
		
		int band = in.nextInt();
		if ( band == 1) {
			dir = 1;
		}
		
		
		for ( int i = 1 ; i < M ; i++) {
			
			a = in.nextLong();
			b = in.nextLong();
			band = in.nextInt();

			sum = sum*b/a;
			
			if ( band == 0) {
			}else {
				dir = 1 - dir;
			}
			
		}
		
		
		System.out.print(dir+" "+(long)sum);

		
	}
}
