package back13416;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int n = in.nextInt();
			int A[] = new int[n];
			int B[] = new int[n];
			int C[] = new int[n];
			long sum = 0;
		
			
			for (int i = 0 ; i < n ; i++) {
				A[i] = in.nextInt();
				B[i] = in.nextInt();
				C[i] = in.nextInt();
				int max = A[i];
				max = Math.max(max, Math.max(B[i], C[i]));
				if ( max > 0 ) {
					sum += max;
				}
			}
			
			System.out.println(sum);
			
			
			T--;
		}
	}
}
