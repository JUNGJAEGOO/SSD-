package back14890;

import java.util.Scanner;

public class Main {
	static int N,L;
	static int [][]mat;
	static int tmpcol[];
	static int tmprow[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		L = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int res = 0;
		for (int i = 0 ; i < N ; i++) {
			//System.out.println(checkRow(i));
			boolean ok = true;
			boolean pass = checkRow(i);
			for (int j = 0 ; j < N ; j++) {
				//System.out.print(tmprow[j]+" ");
				if ( tmprow[j] >= 2) {
					ok = false;
				}
			}
			if ( ok && pass ) {
				res++;
			}
			//System.out.println();
		}
		//System.out.println("--------------");
		for (int i = 0 ; i < N ; i++) {
			//System.out.println(checkCol(i));
			boolean ok = true;
			boolean pass = checkCol(i);
			for (int j = 0 ; j < N ; j++) {
				//System.out.print(tmpcol[j]+" ");
				if ( tmpcol[j] >= 2) {
					ok = false;
				}
			}
			if ( ok && pass)  {
				res++;
			}
			//System.out.println();
		}
		
		System.out.println(res);
	}
	
	public static boolean checkRow(int row) {
		
		tmprow = new int[N];
		
		for (int i = 0 ; i < N-1 ; i++) {
			if ( mat[row][i] > mat[row][i+1] ) {
				if ( mat[row][i]  == mat[row][i+1] + 1) {
					for (int j = 1 ; j <= L ; j++) {
						if ( i+j >= N) {
							return false;
						}
						if ( mat[row][i+1] != mat[row][i+j]) {
							return false;
						}
						tmprow[i+j]++;
					}
				}else {
					return false;
				}
			}else if ( mat[row][i] < mat[row][i+1]) {
				if ( mat[row][i] +1  == mat[row][i+1]) {
					for (int j = 0 ; j < L ; j++) {
						if ( i-j < 0) {
							return false;
						}
						if ( mat[row][i] != mat[row][i-j] ) {
							return false;
						}
						tmprow[i-j]++;
					}
				}else {
					return false;
				}
			}
		}
		
		return true;
	}

	
	public static boolean checkCol(int col) {
		
		tmpcol = new int[N];
		
		for (int i = 0 ; i < N-1 ; i++) {
			if ( mat[i][col] > mat[i+1][col] ) {
				if ( mat[i][col]  == mat[i+1][col] + 1) {
					for (int j = 1 ; j <= L ; j++) {
						if ( i+j >= N) {
							return false;
						}
						if ( mat[i+1][col] != mat[i+j][col]) {
							return false;
						}
						tmpcol[i+j]++;
					}
				}else {
					return false;
				}
			}else if ( mat[i][col] < mat[i+1][col]) {
				if ( mat[i][col] +1  == mat[i+1][col]) {
					for (int j = 0 ; j < L ; j++) {
						if ( i-j < 0) {
							return false;
						}
						if ( mat[i][col] != mat[i-j][col] ) {
							return false;
						}
						tmpcol[i-j]++;
					}
				}else {
					return false;
				}
			}
		}
		
		return true;
	}
}
