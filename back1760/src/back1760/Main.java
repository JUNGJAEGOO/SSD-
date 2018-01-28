package back1760;

import java.util.Scanner;

public class Main {
	static int M,N;
	static int mat[][];
	static boolean visit[][];
	static int ans = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		M = in.nextInt();
		N = in.nextInt();
		mat = new int[M][N];
		for (int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		back(0,0,0,true);
		System.out.println(ans);
	}
	
	public static void back(int x,int y,int sum,boolean start) {
		
		if ( start == false) {
			if ( checkCols(x,y) == false && checkRows(x,y) == false) {
				ans = Math.max(sum,ans);
				return;
			}
		}
		
		for (int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == 0 ) {
					if ( checkCols(i,j) == true && checkRows(i,j) == true) {
						mat[i][j] = 3;
						System.out.println(i+","+j);
						back(i,j,sum+1,false);
						System.out.println("hi jack");
						mat[i][j] = 0;
					}
				}
			}
		}
		
	}
	
	public static boolean checkCols(int x,int y) {

		int rightgoo = 0;
		int leftgoo = 0;
		int leftlimit = 0;
		int rightlimit = 0;
		
		for ( int i = y+1 ; i < N ; i++) {
			if ( y >= N) {
				break;
			}
			
			if ( mat[x][i] == 2) {
				rightlimit = i;
				break;
			}else if ( mat[x][i] == 1) {
				rightgoo++;
			}else if ( mat[x][i] == 3) {
				return false;
			}
		}
		
		for ( int i = y-1 ; i >= 0 ; i--) {
			if ( i < 0 ) {
				break;
			}
			
			if ( mat[x][i] == 2) {
				leftlimit = i;
				break;
			}else if ( mat[x][i] == 1) {
				leftgoo++;
			}else if ( mat[x][i] == 3) {
				return false;
			}
		}
		
		if ( rightlimit - leftlimit == 2) {
			return false;
		}
		
		if ( leftgoo + rightgoo == rightlimit - leftlimit - 2 ) {
			return false;
		}
		
		
		return true;
		
	}
	
	public static boolean checkRows(int x,int y) {
		
		int upgoo = 0;
		int downgoo = 0;
		int uplimit = 0;
		int downlimit = 0;
		
		for ( int i = x+1 ; i < M ; i++) {
			if ( i >= M) {
				break;
			}
			
			if ( mat[i][y] == 2) {
				downlimit = i;
				break;
			}else if ( mat[i][y] == 1) {
				downgoo++;
			}else if ( mat[i][y] == 3) {
				return false;
			}
		}
		
		for ( int i = x-1 ; i >= 0 ; i--) {
			if ( i < 0 ) {
				break;
			}
			
			if ( mat[i][y] == 2) {
				uplimit = i;
				break;
			}else if ( mat[i][y] == 1) {
				upgoo++;
			}else if ( mat[i][y] == 3) {
				return false;
			}
		}
		
		if ( downlimit - uplimit == 2) {
			return false;
		}
		
		if ( downgoo + upgoo == downlimit - uplimit - 2 ) {
			return false;
		}
		
		
		return true;
	}
}
