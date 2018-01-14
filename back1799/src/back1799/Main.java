package back1799;

import java.util.Scanner;

public class Main {
	static int N;
	static int mat[][];
	static int origin[][];
	static int max = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N+1][N+1];
		origin = new int[N+1][N+1];
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				mat[i][j] = in.nextInt();
				origin[i][j] = mat[i][j];
			}
		}
		
		func();
		System.out.println(max);
	}
	
	public static void func() {
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
		// 제로 체크
		int one = 0;
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				if ( mat[i][j] == 1) {
					one++;
					break;
				}
			}
		}
		if ( one == 0 ) {
			int sum = 0;
			
			for ( int i = 1 ; i <= N ; i++) {
				for ( int j = 1 ; j <= N ; j++) {
					if ( mat[i][j] == 3) {
						sum++;
					}
				}
			}
			if ( sum > max) {
				max = sum;
				return;
			}
		}
		
		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				if ( mat[i][j] == 1) {
					System.out.println(i+","+j);
					
								
					// 좌상 대각선
					int leftUP = 0;
					while ( true) {
						if ( mat[i-leftUP][j-leftUP] == 1) {
							mat[i-leftUP][j-leftUP] = 0;
						}
						leftUP++;
						if ( i-leftUP < 1 || j-leftUP < 1) {
							break;	
						}
					}
					// 우상 대각선
					int rightUP = 0;
					while ( true) {
						if ( mat[i-rightUP][j+rightUP] == 1 ) {
							mat[i-rightUP][j+rightUP] = 0;
						}
						rightUP++;
						if ( i-rightUP < 1 || j+rightUP > N) {
							break;	
						}
					}
					// 좌하 대각선
					int leftDOWN = 0;
					while ( true) {
						if ( mat[i+leftDOWN][j-leftDOWN]  == 1) {
							mat[i+leftDOWN][j-leftDOWN] = 0;
						}
						leftDOWN++;
						if ( i+leftDOWN > N || j-leftDOWN < 1) {
							break;	
						}
					}
					// 우하 대각선
					int rightDOWN = 0;
					while ( true) {
						if ( mat[i+rightDOWN][j+rightDOWN] == 1) {
							mat[i+rightDOWN][j+rightDOWN] = 0;
						}
						rightDOWN++;
						if ( i+rightDOWN > N || j+rightDOWN > N) {
							break;	
						}
					}
					mat[i][j] = 3;
					
					func();
					
					// 좌상 대각선
					leftUP = 0;
					while ( true) {
						if ( origin[i-leftUP][j-leftUP] != 0 && mat[i-leftUP][j-leftUP] != 3 ) {
							mat[i-leftUP][j-leftUP] = 1;
						}
						leftUP++;
						if ( i-leftUP < 1 || j-leftUP < 1 ) {
							break;	
						}
					}
					// 우상 대각선
					rightUP = 0;
					while ( true) {
						if ( origin[i-rightUP][j+rightUP] != 0 &&  mat[i-rightUP][j+rightUP] != 3 ) {
							mat[i-rightUP][j+rightUP] = 1;
						}
						rightUP++;
						if ( i-rightUP < 1 || j+rightUP > N ) {
							break;	
						}
					}
					// 좌하 대각선
					leftDOWN = 0;
					while ( true) {
						if ( origin[i+leftDOWN][j-leftDOWN] != 0 && mat[i+leftDOWN][j-leftDOWN] != 3) {
							mat[i+leftDOWN][j-leftDOWN] = 1;
						}
						leftDOWN++;
						if (i+leftDOWN > N || j-leftDOWN < 1 ) {
							break;	
						}
					}
					// 우하 대각선
					rightDOWN = 0;
					while ( true) {
						if (origin[i+rightDOWN][j+rightDOWN] != 0 &&  mat[i+rightDOWN][j+rightDOWN] != 3  ) {
							mat[i+rightDOWN][j+rightDOWN] = 1;
						}
						rightDOWN++;
						if ( i+rightDOWN > N || j+rightDOWN > N ) {
							break;	
						}
					}
					mat[i][j] = 1;
					
				}
			}
		}
		
		
	}
}
