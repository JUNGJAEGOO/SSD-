package back15739;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long mat[][] = new long[N][N];
		long target = ( N * (N * N + 1) ) / 2;
		boolean pass = true;
		boolean visit[] = new boolean[(int) (target+1)];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextLong();
				if ( visit[(int) mat[i][j]] == false) {
					visit[(int) mat[i][j]] = true;
				}else {
					pass = false;
				}
				
			}
		}
		
		//System.out.print(pass);
		
		for ( int i = 0 ; i < N ; i++) {
			long sum = 0;
			for ( int j = 0 ; j < N ; j++) {
			
				sum += mat[i][j];
			}
			if ( sum != target) {
				pass = false;
			}
			
		}
		
		for ( int i = 0 ; i < N ; i++) {
			long sum = 0;
			for ( int j = 0 ; j < N ; j++) {
				
				sum += mat[j][i];
			}
			if ( sum != target) {
				pass = false;
			}
			
		}
		
		int X = 0;
		int Y = 0;
		
		long sum = mat[X][Y];
		
		while ( true ) {
			X++;
			Y++;
			if ( X >= N || Y >= N) {
				break;
			}
			
			sum += mat[X][Y];
		}
		
		if ( sum != target) {
			pass = false;
		}
		
		X = N-1;
		Y = 0;
		
		sum = mat[X][Y];
		
		while ( true ) {
			X--;
			Y++;
			if ( X < 0 || Y >= N) {
				break;
			}
			
			sum += mat[X][Y];
		}
		
		if ( sum != target) {
			pass = false;
		}
		
		if ( pass ) {
			System.out.print("TRUE");
		}else {
			System.out.print("FALSE");
		}
	}
}
