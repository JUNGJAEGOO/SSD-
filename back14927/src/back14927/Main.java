package back14927;

import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int mat[][]= new int[N+2][N+2];
		
		for( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ;j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		cal(mat);
		
		
	
	}
	
	public static int cal(int[][] mat) {
		int ans = 0 ;
		for ( int i = 1 ; i <= N-1 ; i++) {
			
			
				for ( int s = 1 ; s<= N ;s++) {
					if ( mat[i][s] == 1) {
						mat[i][s] = 0;
						mat[i+1][s] = 1 - mat[i+1][s];
						mat[i+2][s] = 1 - mat[i+1][s];
						mat[i+1][s-1] = 1 - mat[i+1][s];
						mat[i+1][s+1] = 1 - mat[i+1][s];
						ans++;
					}
				}
			
		}
		
		for ( int k = 1 ; k <= N ; k++) {
			if (mat[N][k] == 1) {
				mat[N][k] = 0;
				mat[N-1][k] = 1-mat[N-1][k];
				mat[N][k+1] = 1-mat[N][k+1];
				mat[N][k-1] = 1- mat[N][k-1];
				ans++;
			}
		}
		
		int sum = 0;
		for( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ;j++) {
				sum += mat[i][j];
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		
		if ( sum == 0) {
			return ans;
		}else {
			return -1;
		}
	}
}
