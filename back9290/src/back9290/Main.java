package back9290;

import java.util.Scanner;

public class Main {
	static char mat[][];
	static char nam;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		int cnt =1;
		StringBuilder sb = new StringBuilder();
		while ( T > 0) {
			
			mat = new char[3][3];
			
			for (int i = 0 ; i <3 ; i++) {
				char[] tmp = in.nextLine().toCharArray();
				for ( int j = 0 ; j < 3 ; j++) {
					mat[i][j] = tmp[j];
				}
			}
			
			nam = in.nextLine().charAt(0);
			make();
			
			sb.append("Case "+cnt+":\n");
			for (int i = 0 ; i < 3 ; i++) {
				for ( int j = 0 ; j < 3 ; j++) {
					sb.append(mat[i][j]);
				}sb.append("\n");
			}
			cnt++;
			T--;
		}
		System.out.print(sb);
	}
	
	public static void make() {
		
		for (int i = 0 ; i < 3 ; i++) {
			int sum = 0;
			int blank = 0;
			int x = -1,y = -1;
			for (int j = 0 ; j < 3 ; j++) {
				if ( mat[i][j] == '-') {
					blank++;
					x = i;
					y = j;
				}else if ( mat[i][j] == nam) {
					sum++;
				}
			}
			
			if ( sum == 2 && blank == 1) {
				mat[x][y] = nam;
				return;
			}
		}
		
		for (int j= 0 ; j < 3 ; j++) {
			int sum = 0;
			int blank = 0;
			int x = -1,y = -1;
			for (int i = 0 ; i < 3 ;i++) {
				if ( mat[i][j] == '-') {
					blank++;
					x = i;
					y = j;
				}else if ( mat[i][j] == nam) {
					sum++;
				}
			}
			
			if ( sum == 2 && blank == 1) {
				mat[x][y] = nam;
				return;
			}
		}
		
		int sum = 0;
		int blank = 0;
		int x= -1,y= -1;
		if ( mat[0][0] == nam) {
			sum++;
		}if ( mat[1][1] == nam) {
			sum++;
		}if ( mat[2][2] == nam) {
			sum++;
		}
		
		if ( mat[0][0] == '-') {
			blank++;
			x = 0; y= 0;
		}if ( mat[1][1] == '-') {
			blank++;
			x = 1; y = 1;
		}if ( mat[2][2] == '-') {
			blank++;
			x = 2 ; y = 2;
		}
		
		if ( sum == 2 && blank == 1) {
			mat[x][y] = nam;
			return;
		}
		
		sum = 0;
		blank = 0;
		x= -1;y= -1;
		if ( mat[0][2] == nam) {
			sum++;
		}if ( mat[1][1] == nam) {
			sum++;
		}if ( mat[2][0] == nam) {
			sum++;
		}
		
		if ( mat[0][2] == '-') {
			blank++;
			x = 0; y= 2;
		}if ( mat[1][1] == '-') {
			blank++;
			x = 1; y = 1;
		}if ( mat[2][0] == '-') {
			blank++;
			x = 2 ; y = 0;
		}
		
		if ( sum == 2 && blank == 1) {
			mat[x][y] = nam;
			return;
		}
		
	}
}
