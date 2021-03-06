package back2098;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int mat[][];
	static int d[][];
	static int N,inf = 190000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		mat= new int[N][N];
		d = new int[N][1<<N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
			Arrays.fill(d[i], inf);
		}
		System.out.println(N<<1);
		System.out.println(TSP(0,1));
		
	}
	
	public static int TSP(int cur,int visit) {
		
		if ( visit == (1<<N)-1) {
			return mat[cur][0];
		}
		
		if ( d[cur][visit] != inf) {
			return d[cur][visit];
		}
		
		for ( int i = 0 ; i < N ; i++) {
			if ( (visit&(1<<i)) == 0 && mat[cur][i] != 0 ) {
				d[cur][visit] = Math.min(d[cur][visit], mat[cur][i]+TSP(i,visit|(1<<i)));
			}
		}
		return d[cur][visit];
	}
}
