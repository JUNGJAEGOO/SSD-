package backe3109;

import java.util.Scanner;

public class Main {
	static int R,C;
	static char mat[][];
	static boolean visit[][];
	static int cnt = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String init[] = in.nextLine().split(" ");
		R = Integer.parseInt(init[0]);
		C = Integer.parseInt(init[1]);
		mat = new char[R][C];
		
		for (int i = 0 ; i < R ; i++){
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		visit = new boolean[R][C];
		for (int i = 0 ; i < R ; i++) {
			if ( mat[i][0] =='.') {
				cnt+=func(i,0);
			}
		}
		
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
		
		System.out.print(cnt);
	}
	
	public static int func(int x,int y) {
		
		mat[x][y] = 'x';
		if ( y == C-1) {
			System.out.println("hi");
			return 1; 
		}
		
		if ( x-1 >= 0 && y+1 < C && mat[x-1][y+1] == '.') {
			if ( func(x-1,y+1) == 1 ) {
				return 1;
			}
		}
		
		if ( y+1 < C && mat[x][y+1] == '.' ) {
			if ( func(x,y+1) == 1) {
				return 1;
			}
		}
		
		if ( x+1 < R && y+1 < C && mat[x+1][y+1] == '.' ) {
			if ( func(x+1,y+1) == 1) {
				return 1;
			}
		}
		
		return 0;
	}
}
