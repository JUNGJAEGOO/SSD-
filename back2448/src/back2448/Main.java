package back2448;

import java.util.*;

public class Main {
	public static void main(String args[] ){
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int tmp = N;
		int K = 0;
		while ( N % 2 == 0) {
			N /= 2;
			K++;
		}
		
		for (int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print("£ª");
			}System.out.println();
		}
	}
}
