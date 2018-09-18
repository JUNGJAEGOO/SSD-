package back2445;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for ( int i = 1 ; i <= 2*N-1 ; i++) {
			
			if ( i < N) {
				
				for ( int j = 0 ; j < i ; j++) {
					System.out.print("*");
				}
				for ( int j = 0 ; j < N-i ; j++) {
					System.out.print(" ");
				}
				
				for ( int j = 0 ; j < N-i ; j++) {
					System.out.print(" ");
				}
				for ( int j = 0 ; j < i ; j++) {
					System.out.print("*");
				}
				
				
				System.out.println();
			}else if ( i > N) {
				
				for ( int j = 0 ; j < 2*N-i ; j++) {
					System.out.print("*");
				}
				for ( int j = 0 ; j <  i-N; j++) {
					System.out.print(" ");
				}
				for ( int j = 0 ; j <  i-N; j++) {
					System.out.print(" ");
				}
				for ( int j = 0 ; j < 2*N-i ; j++) {
					System.out.print("*");
				}
				System.out.println();
			}else if ( i == N) {
				for ( int j = 0 ; j < 2*N ; j++) {
					System.out.print("*");
				}System.out.println();
				
			}
			
			
		}
	}
}
