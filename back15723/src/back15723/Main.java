package back15723;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int inf = 100;
		int mat[][] = new int[27][27];
		for ( int i = 0 ; i < 27 ; i++ ) {
			for ( int j = 0 ; j < 27 ; j++) {
				mat[i][j] = inf;
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			
			String info[] = in.nextLine().split(" ");
			int x = info[0].charAt(0)-'a';
			int y = info[2].charAt(0)-'a';
			mat[x][y] = 1;
			
		}
		
		for ( int k = 0 ; k < 27 ; k++) {
			for ( int i = 0 ; i < 27 ; i++) {
				for ( int j = 0 ; j < 27 ; j++) {
					if ( i == j ) {
						continue;
					}
					if ( mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		int M = Integer.parseInt(in.nextLine());
		for ( int j = 0 ; j < M ; j++) {
			
			String info[] = in.nextLine().split(" ");
			int x = info[0].charAt(0)-'a';
			int y = info[2].charAt(0)-'a';
			
			if ( mat[x][y] != inf) {
				System.out.println("T");
			}else {
				System.out.println("F");
			}
			
		}
	}

}
