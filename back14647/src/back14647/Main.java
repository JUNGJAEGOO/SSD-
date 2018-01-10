package back14647;

import java.util.Scanner;

public class Main {
	static int mat[][];
	static int N,M;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N][M];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int row[] = countRow();
		int col[] = countCol();
		int maxrow = 0;
		int rowidx = 0;
		int maxcol = 0;
		int colidx = 0;
		for ( int i = 0 ; i < row.length ; i++) {
			if ( row[i] > maxrow) {
				maxrow = row[i];
				rowidx = i;
			}
		}
		for ( int i = 0 ; i < col.length ; i++) {
			if ( col[i] > maxcol) {
				maxcol = col[i];
				colidx = i;
			}
		}
		int max;
		char pandan;
		
		if ( maxrow > 0 || maxcol > 0) {
		
		if ( maxrow >= maxcol) {
			pandan = 'R';
		}else {
			pandan = 'C';
		}
		
		if ( pandan == 'R') {
			for ( int i = 0 ; i < M ; i++) {
				mat[rowidx][i] = -1;
			}
		}else if ( pandan == 'C') {
			for ( int i = 0 ; i < N ; i++) {
				mat[i][colidx] = -1;
			}
		}
		}
		
		int hit = 0;
		for ( int i = 0 ; i < N ; i++ ) {
			for ( int j = 0 ; j < M ; j++) {
				int now = mat[i][j];
				char[] nowchar = String.valueOf(now).toCharArray();
				for ( int k = 0 ; k < nowchar.length ; k++) {
					if ( nowchar[k] == '9') {
					//System.out.println(i+","+j);
					hit++;
					}
				}
			}
		}
		
		System.out.println(hit);
		
	}
	
	public static int[] countRow() {
		int num[] = new int[N];
		for ( int i = 0 ; i < N ; i++ ) {
			for ( int j = 0 ; j < M ; j++) {
				int now = mat[i][j];
				char[] nowchar = String.valueOf(now).toCharArray();
				for ( int k = 0 ; k < nowchar.length ; k++) {
					if ( nowchar[k] == '9') {
					num[i]++;
					}
				}
			}
		}
		
		return num;
	}
	
	public static int[] countCol() {
		int num[] = new int[M];
		for ( int j = 0 ; j < M ; j++) {
			for ( int i = 0 ; i < N ; i++) {
				int now = mat[i][j];
				char[] nowchar = String.valueOf(now).toCharArray();
				for ( int k = 0 ; k < nowchar.length ; k++) {
					if ( nowchar[k] == '9') {
					num[j]++;
					}
				}
			}
		}
		
		return num;
	}
}
