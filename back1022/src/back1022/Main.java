package back1022;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int r1 = in.nextInt();
		int c1 = in.nextInt();
		int r2 = in.nextInt();
		int c2 = in.nextInt();
		int ROW = Math.abs(r1-r2);
		int COL = Math.abs(c1-c2);
		String mat[][] = new String[10002][10002];
		int X = 5000;
		int Y = 5000;
		mat[X][Y] = "1";
		int len = 1;
		int cnt = 2;
		int Ygo = 1;
		int Xgo = -1;
		
		lop:
		while ( true) {
			
			//System.out.println(X+","+Y+" "+cnt);
			System.out.println(cnt);
			for (int i = 0 ; i < len ; i++) {
				Y = Y + Ygo;
				if ( Y > 10001 || Y < 0) {
					break lop;
				}
				mat[X][Y] = String.valueOf(cnt);
				cnt++;
				
			}
			
			//System.out.println(X+","+Y);
			
			for (int i = 0 ; i < len ; i++) {
				X = X + Xgo;
				if ( X > 10001 || X < 0) {
					break lop;
				}
				mat[X][Y] = String.valueOf(cnt);
				cnt++;
			}
			
			len++;
			if ( cnt >= 100000001) {
				break;
			}
			Ygo *= -1;
			Xgo *= -1;
		}
		
		for (int i = 4995 ; i <= 5005 ; i++) {
			for (int j = 4995 ; j <= 5005 ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
	}
}
