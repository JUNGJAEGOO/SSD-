package back1952;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		boolean mat[][] = new boolean[N][M];
		
		
		int cnt = 0;
		
		int X[] = {0,1,0,-1};
		int Y[] = {1,0,-1,0};
		
		int nowX = 0;
		int nowY = 0;
		int go = 0;
		
		mat[nowX][nowY] = true;
		int cut = 0;
		int move = 1;
		
		while ( true ) {
			
			//System.out.println(nowX+","+nowY+" "+go);
			
			if ( move == N*M) {
				break;
			}
			
			int nx = nowX + X[go];
			int ny = nowY + Y[go];
			
			if ( nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if ( mat[nx][ny] == false ) {
					mat[nx][ny] = true;
					nowX = nx;
					nowY = ny;
					move++;
				}else {
					go = ( go + 1 ) % 4;
					cut++;
				}
			}else {
				go = ( go + 1 ) % 4;
				cut++;
			}
			
		}
		
		System.out.print(cut);
	}
}
