package back2502;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int D = in.nextInt();
		int N = in.nextInt();
		
		int A[] = new int[31];
		int B[] = new int[31];
		A[1] = 1;
		A[2] = 0;
		B[1] = 0;
		B[2] = 1;
		A[3] = 1;
		B[3] = 1;
		for ( int i = 4 ; i<= 30 ; i++) {
			A[i] = A[i-1] + A[i-2];
			B[i] = B[i-1] + B[i-2];
		}
		
		int dA = A[D];
		int dB = B[D];
		
		for ( int x = 1 ; x <= 10000 ; x++) {
			for (int y = 1 ; y <= 10000 ; y++) {
				if ( dA*x + dB*y == N) {
					System.out.println(x+"\n"+y);
					return;
				}
			}
		}
		
		
	}
}
