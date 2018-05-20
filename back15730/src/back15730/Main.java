package back15730;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int C = in.nextInt();
		
		int mat[][] = new int[R][C];
		for (int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int sum = 0;
		
		boolean wall[][] = new boolean[R][C];
		for ( int i = 0 ; i <R ; i++) {
			for ( int j = 0 ; j < C ; j++) {
				if ( i == 0 || j == 0 || i == R-1 || j == C-1) {
					continue;
				}
				
				
			}
		}
		
		int h[][] = new int[R][C];
		
		for ( int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C ; j++) {
				if ( i == 0 || j == 0 || i == R -1 || j == C - 1) {
					continue;
				}
				
				int min  = 1000001;
				
				if ( i-1 == 0) {
					min = Math.min(min, mat[i-1][j]);
				}
				if ( j-1 == 0) {
					min = Math.min(min, mat[i][j-1]);
				}
				if ( i+1 == R-1) {
					min = Math.min(min, mat[i+1][j]);
				}
				if ( j+1 == C-1) {
					min = Math.min(min, mat[i][j+1]);
				}
				
				if ( min < mat[i][j] ) {
					h[i][j] = mat[i][j];
				}else {
					h[i][j] = min;
				}
			}
		}
		
		for ( int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C ; j++) {
				System.out.print(h[i][j]+" ");
			}System.out.println();
		}
		
		System.out.print(sum);
		
	}
}
