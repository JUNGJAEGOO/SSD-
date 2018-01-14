package back2580;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static class node{
		int x,y;
		node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int mat[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new int[11][11];
		ArrayList<String> zeros = new ArrayList<>();
		int startX = 1;
		int startY = 1;
		int zero = 0;
		for ( int i = 1 ; i<= 9 ; i++) {
			for ( int j = 1 ; j<= 9 ; j++){
				mat[i][j] = in.nextInt();
			}
		}
		func();
	}
	
	public static void func() {
		
		//System.out.println("시작점은 "+x+","+y+" zeros "+zero);
		int r = -1;
		int c = -1;
		for ( int i = 1 ; i<= 9 ; i++) {
			for ( int j = 1 ; j<= 9 ; j++) {
				if (mat[i][j] == 0 ) {
					r = i;
					c = j;
					break;
				}
			}
		}
		
		
		if ( r == -1) {
				for ( int i = 1 ; i <= 9 ; i++) {
					for ( int j = 1 ; j<= 9 ; j++) {
						System.out.print(mat[i][j]+" ");
					}System.out.println();
				}
			System.exit(0);
		}
		
					for ( int z = 1 ; z <= 9 ;z++) {
						boolean pass = true;
						mat[r][c] = z;
						
						if ( pass == true) {
						for ( int s = 1 ; s <= 9 ; s++) {
							if ( s != r) {
								if ( mat[s][c] == mat[r][c]) {
									pass = false;
								}
							}
						}
						}
						
						if ( pass == true) {
						for ( int s = 1 ; s <= 9 ; s++) {
							if ( s != c) {
								if ( mat[r][s] == mat[r][c]) {
									pass = false;
								}
							}
						}
						}
						
						int jumpx = (r-1)/3;
						int jumpy = (c-1)/3;
						
						if ( pass == true) {
						for ( int s = 3*jumpx + 1 ; s<= 3*(jumpx+1) ; s++) {
							for ( int t = 3*jumpy + 1 ; t<= 3*(jumpy+1) ; t++) {
								if ( s != r && t != c) {
									if ( mat[r][c] == mat[s][t]) {
										pass = false;
									}
								}
							}
						}
						}
						
						if ( pass == false) {
							mat[r][c] = 0;
						}
						else {
							func();
							mat[r][c] = 0;
						}
					}
			
		
		
			
	}
}
	
