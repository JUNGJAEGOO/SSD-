package back1507;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int mat[][] = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
				
			}
		}
		
		int dist[][] = new int[N][N];
		
		for (int k = 0 ; k < N ; k++) {
			
			for ( int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					
					if ( i == j || i == k || k == j) {
						continue;
					}
					
					//System.out.println("hi");
				
					if ( mat[i][j] == mat[i][k] + mat[k][j]) {
						dist[i][j] = 1;
					}else if ( mat[i][j] > mat[i][k] + mat[k][j]) {
						System.out.println(-1);
						return;
					}
						
				}
				
			}
		}
		
		/*for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				System.out.print(dist[i][j]+" ");
			}System.out.println();
		}*/
		
		int ret = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = i ; j < N ; j++) {
				ret += (1-dist[i][j]) * mat[i][j];
			}
		}
		System.out.print(ret);
	}
}
