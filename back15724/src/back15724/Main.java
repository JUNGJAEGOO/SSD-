package back15724;

import java.util.Scanner;

public class Main {
	static int mat[][];
	static int R,C;
	static long tree[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		mat = new int[R+1][C+1];
		tree = new long[R+1][C+1];
		for ( int i = 1 ; i <= R ; i++ ) {
			for ( int j = 1 ; j <= C; j++) {
				mat[i][j] = in.nextInt();
				update(i,j,mat[i][j]);
			}
		}
		
		int M = in.nextInt();
		for ( int i = 0 ; i < M ; i++) {
			
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			
			System.out.println(sum(x2,y2)-sum(x1-1,y2)-sum(x2,y1-1)+sum(x1-1,y1-1));
		}
	}
	
	public static void update(int idx,int idx2,long x) {
		for ( int i = idx ; i <= R ; i += (i & -i) ) {
			for ( int j = idx2 ; j <= C ; j += (j & -j) ) {
				tree[i][j] += x;
			}
		}
	}
	
	public static long sum(int x,int y) {
		long sum = 0;
		
		for ( int i = x ; i > 0 ; i -= (i&-i)) {
			for ( int j = y ; j > 0 ; j -= (j&-j)) {
				sum += tree[i][j];
			}
		}
		
		
		return sum;
	}
}
