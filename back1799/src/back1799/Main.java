package back1799;

import java.util.Scanner;

public class Main {
	static int N;
	static int mat[][];
	static int color[][];
	static int max[] = new int[2];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		color = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = 1-in.nextInt();
				if ( i%2 == 0) {
					if ( j%2 == 0) {
						color[i][j] = 0;
					}else {
						color[i][j] = 1;
					}
				}else {
					if ( j%2 == 1) {
						color[i][j] = 0;	
					}else {
						color[i][j] = 1;
					}
				}
			}
		}
		
	/*	for (int i = 1 ;i<= N ; i++) {
			for (int j =1 ; j<= N ; j++) {
				System.out.print(color[i][j]+" ");
			}System.out.println();
		}
		*/
		
		func(0,0,0);
		func(0,0,1);
		System.out.println(max[0]+max[1]);
		
		//System.out.println(max);
	}
	
	public static void func(int v,int ans,int Color) {
		

		max[Color] = Math.max(ans, max[Color]);
		
		for (int s = v+1 ; s< N*N ; s++) {
			int i = s/N;
			int j = s%N; 
				if ( color[i][j] != Color) {  // ÇÙ½É!! Èæ°ú ¹éÀº µû·Î Ã³¸®
					continue;
				}
				
				if ( mat[i][j] != 1 && mat[i][j] != 2  ) {
					if ( ok(i,j) ) {
						mat[i][j] = 2;
						func(s,ans+1,Color);
						mat[i][j] = 0;
					}
				}
			
		}
		
		
	}
	
	public static boolean ok(int x,int y) {
		
		int sx = x-1,sy = y+1;
		int rightup = 0,rightdown =0;
		int leftup = 0,leftdown =0;
		int cnt = 0;
		while ( sx>= 0 && sy < N) {
			if ( mat[sx][sy] == 2) {
				return false;
			}
			if ( mat[sx][sy] == 1) {
				rightup++;
			}
			cnt++;
			sx--; sy++;
		}
		
		sx = x-1; sy = y-1;
		
		while ( sx>=  0&& sy >= 0) {
			if ( mat[sx][sy] == 2) {
				return false;
			}
			if ( mat[sx][sy] == 1) {
				leftup++;
			}
			cnt++;
			sx--; sy--;
		}
		
		
		sx = x+1; sy = y+1;
		
		while ( sx < N && sy < N) {
			if ( mat[sx][sy] == 2) {
				return false;
			}
			if ( mat[sx][sy] == 1) {
				rightdown++;
			}
			cnt++;
			sx++; sy++;
		}
		
		sx = x+1; sy = y-1;
		
		while ( sx < N && sy >= 0) {
			if ( mat[sx][sy] == 2) {
				return false;
			}
			if ( mat[sx][sy] == 1) {
				leftdown++;
			}
			cnt++;
			sx++; sy--;
		}
		
		
		return true;
	}
}
