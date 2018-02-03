package back2630;

import java.util.Scanner;

public class Main {
	static int mat[][];
	static int white = 0,blue = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
				
			}
		}
		
		func(N,0,0);
		
		System.out.println(white+"\n"+blue);
		
	}
	
	public static void func(int len,int sX,int sY) {
		
		if ( len == 1) {
			if ( mat[sX][sY] == 1) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		
		int sumW = 0;
		int sumB= 0;
		for (int i = 0 ; i < len ; i++) {
			for (int j = 0 ; j < len ; j++) {
				if ( mat[sX+i][sY+j] == 1) {
					sumB++;
				}else {
					sumW++;
				}
			}
		}
		
		if ( sumB == 0 && sumW > 0) {
			white++;
			return;
		}else if ( sumW == 0 && sumB > 0) {
			blue++;
			return;
		}
		
		
		
		func (len/2,sX,sY);
		func (len/2,sX+len/2,sY);
		func (len/2,sX,sY+len/2);
		func (len/2,sX+len/2,sY+len/2);
		
		
	}
}
