package back10842;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		int M = Integer.parseInt(info[0]);
		int N = Integer.parseInt(info[1]);
		
		char[][][][][] rule = new char[M][M][3][3][3];
		
		int nowX = 1;
		int nowY = 1;
		
		for ( int i = 0 ; i < (M-1)*(M-1) ; i++) {
			
			String tmp = in.nextLine();
			char[] r = tmp.toCharArray();
			int cnt = 0;
			for ( int j = 0 ; j < 3 ; j++) {
				for ( int k = 0 ; k < 3 ; k++) {
					for ( int s = 0 ; s < 3 ; s++) {
						rule[nowX][nowY][j][k][s] = r[cnt];
						cnt++;
					}
				}
			}
			
			nowY++;
			if ( nowY >= M ) {
				nowY = 1;
				nowX++;
			}
		}
		
		node mat[][] = new node[M][M];
		for ( int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < M  ; j++) {
				mat[i][j] = new node(0,1);
			}
		}
		
		for( int i = 0 ; i < N ; i++) {
			
			info = in.nextLine().split(" ");
			int zero = Integer.parseInt(info[0]);
			int one = Integer.parseInt(info[1]);
			int two = Integer.parseInt(info[2]);
			
			int startX = M-1;
			int startY = 0;
			
			while ( true ) {
				mat[startX][startY].before = mat[startX][startY].num;
				if ( zero != 0 ) {
					mat[startX][startY].num = mat[startX][startY].num;
					zero--;
				}else if ( one != 0) {
					mat[startX][startY].num = mat[startX][startY].num + 1;
					one--;
				}else {
					mat[startX][startY].num = mat[startX][startY].num + 2;
					two--;
				}
				startX--;
				if ( startX == -1) {
					startX = 0;
					startY++;
					if ( startY == M) {
						break;
					}
				}
			}
			
			for ( int j = 1 ; j < M ; j++) {
				for ( int k = 1 ; k < M ; k++) {
					
					int D = mat[j-1][k-1].num - mat[j-1][k-1].before;
					int L = mat[j][k-1].num - mat[j][k-1].before;
					int U = mat[j-1][k].num - mat[j-1][k].before;
					
					//System.out.println(D+" "+L+" "+U);
					
					char select = rule[j][k][L][D][U];
					
					if ( select == 'L') {
						mat[j][k].before = mat[j][k].num;
						mat[j][k].num = mat[j][k].num + L;
					}else if ( select == 'D') {

						mat[j][k].before = mat[j][k].num;
						mat[j][k].num = mat[j][k].num + D;
					}else {

						mat[j][k].before = mat[j][k].num;
						mat[j][k].num = mat[j][k].num + U;
					}
					
				}
			}
		}
		
		for ( int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				System.out.print(mat[i][j].num+" ");
			}System.out.println();
		}
		
	}
	
	public static class node{
		int before;
		int num;
		node ( int before,int num){
			
			this.before = before;
			this.num = num;
		}
	}
}
