package back2660;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int mat[][] = new int[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = 100000000;
			}
		}
		
		while ( true ) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			
			if ( x == -1) {
				break;
			}
			
			x--;
			y--;
			
			mat[x][y] = 1;
			mat[y][x] = 1;

		}
		
		for ( int k = 0 ; k < N ; k++) {
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					if ( mat[i][k] + mat[k][j] < mat[i][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		ArrayList<Integer> MINNER = new ArrayList<>();
		int MIN = 100000000;
		for ( int i = 0 ; i < N ; i++) {
			int tmpMAX = 0;
			for ( int j = 0 ; j < N ; j++) {
				if ( i == j ) {
					continue;
				}
				if ( mat[i][j] > tmpMAX) {
					tmpMAX = mat[i][j];
				}
				//System.out.print(mat[i][j]+" ");
			}//System.out.println();
			
			if ( tmpMAX < MIN) {
				MIN = tmpMAX;
				MINNER = new ArrayList<>();
				MINNER.add((i+1));
			}else if ( tmpMAX == MIN) {
				MINNER.add((i+1));
			}
		}
		
		System.out.println(MIN+" "+MINNER.size());
		Collections.sort(MINNER);
		for  (int i = 0 ; i <MINNER.size() ; i++) {
			System.out.print(MINNER.get(i)+" ");
		}
		
	}
}
